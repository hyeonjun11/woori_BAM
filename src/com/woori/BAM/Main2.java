package com.woori.BAM;
import java.util.Scanner;
public class Main2 {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in); 
       
		int id = 1;	 //while 문 안에 있으면 1이 반복되기때문에 while 문 밖에 선언
		
		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim(); 
			// trim은 입력받는 값의 공백을 제거
			
			
			if (cmd.equals("exit")) {
				break; // exit가 입력되면 while문을 빠져나간다.
			} 
			if (cmd.length() == 0) {  //cmd 문장의 길이가 0이면 실행 
				System.out.println("명령어를 입력해 주세요");
				continue;
				// continue로 넘어가지 않으면 밑에 if문이 실행이 된다
			}
			
			if (cmd.equals("article list")) {
				System.out.println("게시글이 없습니다");
			} else if(cmd.equals("article write")){ // article list가 실행되지 않으면 실행 
				
				
				System.out.printf("제목 : ");
				String title = sc.nextLine().trim(); 
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim(); 
				System.out.println(id +"번글이 생성되었습니다");
				id++;
				
			}else { 		// 위에 if 문이 실행되지않으면  실행 (위 if문이 실행되면 건너뛰고 while 문 처음부터 실행)
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}
		
		sc.close();
		System.out.println("== 프로그램 종료 ==");
	}

}