package com.luna.dao;

import java.util.List;
import com.luna.entities.Article;

public interface ArticleDAO {

	public void insertArticle(Article Art);

	public void updateArticle(Article Art);

	public void removeArticle(int idArticle);

	public Article getArticle(int idArticle);

	public List<Article> getAllArticle();

}
