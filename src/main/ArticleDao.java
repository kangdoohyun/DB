package main;

import java.util.ArrayList;

public class ArticleDao {
	private DBUtil db = new DBUtil();

	public ArrayList<Article> getArticles() {
		String sql = "select * from article";
		return db.getRows(sql);
	}

	public int updateArticle(String title, String body, int aid) {
		String sql = "update article set title = ?, body = ? where id = ?";
		return db.updateQuery(sql, title, body, aid);
	}

	public int deleteArticle(int aid) {
		String sql = "delete from article where id = ?";
		return db.updateQuery(sql, aid);
	}

	public int insertArticle(String title, String body) {
		String sql = "insert into article set title = ?, body = ?, nickname = '익명', regDate = NOW(), hit = 0";
		return db.updateQuery(sql, title, body);
	}

	public Article getArticleById(int aid) {
		String sql = "select * from article where id = ?";
		return db.getRow(sql, aid);
	}
}
