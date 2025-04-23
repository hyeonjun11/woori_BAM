package com.woori.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
	
		System.out.println("학생의 수를 입력하세요.");
		int num = sc.nextInt();
		int[] scores = new int[num]; 
		
		System.out.println("학생의 이름을 입력하세요.");
		String[] names = new String[num];
		
		
		System.out.println("학생의 점수를 입력하세요.");
		int[] score = new int[num];
		
		switch () {
		case 10: 
			System.out.println("A");
			break;
		case 9:
			System.out.println("B");
			break;
		default:
			System.out.println("C");
		}
		
		
		for(i=0; i<num;i++) {
			System.out.println("학");
		}
		
		
		

	}
}
