package main;

import java.util.ArrayList;
import java.util.Scanner;

public class DB {

	public static void main(String[] args) {
ArticleDao articleDao = new ArticleDao();
		
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();

			if (cmd.equals("list")) {

				ArrayList<Article> articles = articleDao.getArticles();
				for(int i = 0; i < articles.size(); i++) {
					System.out.println("제목 : " + articles.get(i).getTitle());
				}
				
			} else if (cmd.equals("add")) {
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();

				articleDao.addArticle(title, body);
				
				
			} else if (cmd.equals("update")) {
				System.out.print("번호 : ");
				int id = Integer.parseInt(sc.nextLine());
				Article article = articleDao.getArticleById(id);

				if (article != null) {
					System.out.print("제목 : ");
					String title = sc.nextLine();
					System.out.print("내용 : ");
					String body = sc.nextLine();
					
					articleDao.updateArticle(id, title, body);
				} else {
					System.out.println("없는 게시물입니다.");
				}
				
			} else if (cmd.equals("delete")) {
				System.out.print("번호 : ");
				int id = Integer.parseInt(sc.nextLine());
				Article article = articleDao.getArticleById(id);

				if (article != null) {
					articleDao.deleteArticle(id);
				} else {
					System.out.println("없는 게시물입니다.");
				}
				
			}
			else if(cmd.equals("read")){
				System.out.print("번호 : ");
				int id = Integer.parseInt(sc.nextLine());
				Article article = articleDao.getArticleById(id);

				if (article != null) {
					System.out.println("번호 : " + article.getId());
					System.out.println("제목 : " + article.getTitle());
					System.out.println("내용 : " + article.getBody());					
				} else {
					System.out.println("없는 게시물입니다.");
				}
			}
		}
	}

}
