package com.hideraldo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hideraldo.bookstore.domain.Categoria;
import com.hideraldo.bookstore.domain.Livro;
import com.hideraldo.bookstore.repositories.CategoriaRepository;
import com.hideraldo.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instaciaBaseDados() {
		Categoria cat1 = new Categoria(null, "Informárica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Luis V. Gerstern", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H. G. Hells", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "The War of the Worlds", "H. G. Hells", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);
		
		cat1.getLivro().addAll(Arrays.asList(l1, l2));
		cat2.getLivro().addAll(Arrays.asList(l3, l4, l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
