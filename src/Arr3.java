import java.util.Scanner;

public class Arr3 {
	public static void main(String[] args) {
		int i;
		float sum= 0;
		float avg;
		int[]jumsu = new int[5];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5명의 수학 점수를 입력하시오.");
		for(i=0; i<jumsu.length;i++) {
			jumsu[i] = sc.nextInt();
		}// 총점구하기
		for (i=0; i< jumsu.length;i++) {
				sum += jumsu[i];
		}// 평균구하기
		avg= sum/5;
		System.out.println("총점 = "+ sum + "평균 ="+ avg);
	}
}
