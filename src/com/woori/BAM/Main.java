package com.woori.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in); // 최적화 => 자원 1번 사용 개선
		
		while (true) {
			System.out.printf("cmd)");
			String cmd = sc.nextLine();// cmd 변수 ==> 재사용하기 위해서 
			System.out.println("명령어 ) " + cmd);
			if (cmd.equals("exit")) {
				break;
			}

		}
//		 qweqwewqeqwe
		System.out.println("== 프로그램 종료 ==");
		sc.close();
	}
}
