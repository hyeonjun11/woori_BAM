package com.woori.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("학생의 수를 입력하세요 : ");
		int num = scanner.nextInt();
		scanner.nextLine();
		
		int[] scores = new int[num]; 
		String[] names = new String[num];
		String[] grades = new String[num];
		
		
		for(int i = 0; i<num; i++) {
			System.out.print((i+1)+"번 째 학생의 이름 :");
			names[i] = scanner.nextLine();			
			
			System.out.print(names[i]+"의 점수 :");
			scores[i] = scanner.nextInt();
			scanner.nextLine();
		}
		for(int i =0; i< num;i++) {
	
		
		switch (scores[i]/10) {
		case 10: 
			grades[i] = "A";
			break;
		case 9:
			grades[i] = "B";
			break;
		default:
			grades[i] = "C";
		}
		}
		System.out.println("---- 학생 성적 결과 ----- ");
		for(int i =0; i<num; i++) {
			System.out.println(names[i] + " : " + scores[i] + "점 (" + grades[i] + ")");
		}					
	}
}
