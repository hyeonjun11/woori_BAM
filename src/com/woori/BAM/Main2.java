package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);

		int lastArticleId = 1; // 게시글 번호 , 마지막게시글번호 수정
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해 주세요");
				continue;
			}

			if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();

				Article article = new Article(lastArticleId, title, body);
				articles.add(article);

				System.out.println(lastArticleId + "번글이 생성되었습니다");
				lastArticleId++;

			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다");
					continue;

				}
				System.out.printf("번호    |     제목\n");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d      |     %s\n", article.id, article.title);

				}
			} else if (cmd.startsWith("article detail ")) { // article detail 로 시작하니????
				String[] cmdBits = cmd.split(" ");

//				boolean articleChk = false;      // 객체지향프로그래밍 하기위한 준비
				 
				Article foundArticle = null;	// 객체로 대치(변수 vs 객체 차이점) 변수 1개 , 객체 (번호, 제목 ,내용)
				
				int id = 0;
				try {   // Exception 발생 할 예상 코드 블럭 
					id = Integer.parseInt(cmdBits[2]);  // 재정의 , 가독성(올라감) , 재활용(올라감)
					
				} catch (NumberFormatException e) { // (예외타입 변수명)
					System.out.println("숫자를 입력하세요");
					continue;   // 이하 실행이 안되도록 ==> while 작동 
				} catch (Exception e)	{
					// 그 밖에 모든 Exception 처리한다
				} 
				
				
				
				for (Article article : articles) {
					if (article.id == id) { // 문자로 된 숫자를 ==> 숫자
						foundArticle = article;
						break;
					
					}
				}
				
//				if (articleChk == false) {
				
				if (foundArticle == null) {                       // 개발자 고민할 영역 ==> try catch 문 설명 
					System.out.println(id + "번 게시물이 존재하지 않습니다"); 
					continue;     	// 매우 매우 중요. 아래에서 NuLLPointException 발생이 안되도록 조치
				}
																			// 출력문을 밑으로 내린 이유 cmdBit[2] for문 중요
				System.out.println("번호 :" + foundArticle.id); 				// 재활용을 위한 준비 ==> 많이 사용 ==> 메소드로 구성(메소드화)
				System.out.println("날짜 : ~~~ ");							
				System.out.println("제목 :" + foundArticle.title);
				System.out.println("내용 :" + foundArticle.body);
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}
		sc.close();
		System.out.println("== 프로그램 종료 ==");
	}
}

class Article {
	int id;
	String title;
	String body;

	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}