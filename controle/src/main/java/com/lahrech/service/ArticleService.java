package com.lahrech.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.lahrech.repositories.ArticleRepository;


import com.lahrech.entities.*;
import com.lahrech.repositories.*;

@Service
public class ArticleService implements com.lahrech.dao.IDao<Article> {

	@Autowired
	private ArticleRepository repository;

	@Override
	public Article create(Article o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Article o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Article update(Article o) {
		return repository.save(o);
	}

	@Override
	public Article findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Article> findAll() {
		return repository.findAll();
	}
	public List<Article> findByCategorie(Categorie categorie){
		return repository.findByCategorie(categorie);
		
	}
	 
}