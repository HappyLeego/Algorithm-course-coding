package com.offer;

import java.util.Scanner;

public class IslandProblem {
	public static int island(int[][] arr){
		if(arr == null || arr[0] == null){
			return 0;
		}
		int N = arr.length;
		int M = arr[0].length;
		int res = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M;j++){
				if(arr[i][j] == 1){
					res++;
					infect(arr,i,j,N,M);
				}
			}
		}
		return res;
	}
	public static void infect(int[][] arr, int i,int j,int N,int M){
		if(i<0 || i >= N|| j<0 || j >= M || arr[i][j] != 1){
			return;
		}
		arr[i][j] = 2;
		infect(arr,i+1,j,N,M);
		infect(arr,i-1,j,N,M);
		infect(arr, i, j-1, N, M);
		infect(arr, i, j+1, N, M);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); 
		int M = scan.nextInt();
		
		int[][] m = new int[N][M];
		for(int i = 0; i < N; i++){
			for(int j = 0 ; j < M;j++){
				m[i][j] = scan.nextInt();
			}
		}
		
		System.out.println(island(m));
	}
}
