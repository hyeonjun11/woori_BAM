package test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("명령어 입력 >>");
			String cmd = sc.nextLine();
			
			if(cmd.equals("exit")) {
				System.out.println("프로그램을 종료합니다");
				break;
				
			}
			if(cmd.equals("continue")) {
				continue;
			}
			System.out.println("입력된 명령어 :");
		}
		sc.close();
		}
}
