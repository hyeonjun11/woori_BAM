package com.woori.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		int i = 1;
		
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
			
			
			if (cmd.equals("article list")) {
				System.out.println("게시글이 없습니다");
			 
			} else if (cmd.equals("article write")) {
				System.out.println("제목을 입력하시오");
				System.out.println("제목: ");
				String 제목 = sc.nextLine();
				System.out.println("내용: " );
				String 내용 = sc.nextLine();
				System.out.println(i+"번째 게시글입니다");
				i++;
			} else  
				System.out.println("존재하지 않는 명령어입니다.");
				}

	
		System.out.println("== 프로그램 종료 ==");
		sc.close();
	}
}
