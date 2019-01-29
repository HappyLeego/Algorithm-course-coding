package nuaa.lily;

import java.util.Scanner;

public class Multiple {
	public static long multiple(int n){
		if(n == 1){
			return 1;
		}else{
			return n*multiple(n-1);
		}
	}
	//·ÇµÝ¹é
	public static long multiple1(int n){
		if(n == 1){
			return 1;
		}
		
		int b = 1;
		int c = 0;
		for(int i = 2; i <= n ; i++){
			c = i*b;
			b = c;
		}
		return c;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(multiple1(n));
	}
}
