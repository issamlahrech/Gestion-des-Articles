package com.lahrech.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lahrech.entities.Article;
import com.lahrech.entities.Categorie;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	@Query("select a from Article a where a.categorie=:c")
	public List<Article> findByCategorie(@Param ("c") Categorie categorie);
	

}
