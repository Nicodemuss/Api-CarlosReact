package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@RestController
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List <Produto> ListarProdutos(){
		return produtoRepository.findAll();
	}
	
	@PostMapping("/produto")
	public Produto salvar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@GetMapping("/produto/{id}")
	public Produto procurarProduto(@PathVariable Long id) {
		return produtoRepository.getById(id);
	}
	
	@DeleteMapping("/produto/{id}")
	public void deletar(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
	
	@DeleteMapping("/produtodel")
	public void deletartd() {
		produtoRepository.deleteAll();
		}

	
}
 