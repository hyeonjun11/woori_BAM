package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.woori.BAM.dto.Article;
import com.woori.BAM.util.Util;

public class App {
	// 전역변수 ==> this (자기 자신을 의미 , 객체)
	private List<Article> articles; // List 타입의 articles
	private int lastArticleId;

	// 생성자를 통해서 초기화 기존 code(static 제거 한 상태)
	App() {
		articles = new ArrayList<>(); // 데이터의 구조 ArrayList 형태 객체가 생성
		lastArticleId = 1;
	}

	void run() {
		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);

		makeTestData(); // 중요 ---> 해당 메소드가 만들어 지는 위치? static 메소드일 수 밖에 없는 이유?

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (cmd.equals("article write")) {
				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();

				Article article = new Article(lastArticleId, Util.getDateStr(), title, body, 0);
				articles.add(article);

				System.out.println(lastArticleId + "번 글이 생성되었습니다");
				lastArticleId++;

			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다");
					continue;
				}

				System.out.println("번호	|	제목	|		날짜		  	| 	조회수");

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d	|	%s	|	%s	|	%d\n", article.getId(), article.getTitle(),
							article.getRegDate(), article.getViewCnt());
				}

			} else if (cmd.startsWith("article detail ")) {

				int id = getCmdId(cmd);

				// id 가 0으로 리턴시 처리로직 보강
				if (id == 0) {
					continue;
				}

				Article foundArticle = getArticleById(id);  //article or null 

				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다");
					continue;
				}

				foundArticle.increaseViewCnt();

				System.out.println("번호 : " + foundArticle.getId());
				System.out.println("날짜 : " + foundArticle.getRegDate());
				System.out.println("제목 : " + foundArticle.getTitle());
				System.out.println("내용 : " + foundArticle.getBody());
				System.out.println("조회수 : " + foundArticle.getViewCnt());

			} else if (cmd.startsWith("article modify ")) {
				int id = getCmdId(cmd);

				// id 가 0으로 리턴시 처리로직 보강
				if (id == 0) {
					continue;
				}

				Article foundArticle = getArticleById(id);  //article or null 

				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다");
					continue;
				}

				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("수정할 내용 : ");
				String body = sc.nextLine().trim();

				foundArticle.setTitle(title);
				foundArticle.setBody(body);

				System.out.println(id + "번 게시물이 수정되었습니다");

			} else if (cmd.startsWith("article delete ")) {
				int id = getCmdId(cmd);

				// id 가 0으로 리턴시 처리로직 보강
				if (id == 0) {
					continue;
				}

				Article foundArticle = getArticleById(id);  //article or null 

				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다");
					continue;
				}

				articles.remove(foundArticle);

				System.out.println(id + "번 게시물이 삭제되었습니다");

			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}

		}

		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}

	private Article getArticleById(int id) {

		for (Article article : articles) {
			if (article.getId() == id) {
				return article; 	// return article , 메서드 종료 
			}
		}

		return null;

	}

	private int getCmdId(String cmd) {
		String[] cmdBits = cmd.split(" ");

		int id = 0;

		try {
			id = Integer.parseInt(cmdBits[2]);
			return id; // id를 넘겨주고 메서드 종료
		} catch (NumberFormatException e) {
			System.out.println("명령어가 올바르지 않습니다");
			return 0; // "asd " ---> 0
		}

	}

	private void makeTestData() {
		System.out.println("5개의 데이터가 생성되었습니다.");
		for (int i = 1; i <= 5; i++) {

			articles.add(new Article(lastArticleId++, Util.getDateStr(), "제목"+i, "내용"+i, i*10));
		}
	}
}
