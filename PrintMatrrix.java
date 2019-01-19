package com.offer;

import java.util.Scanner;

public class PrintMatrrix {
	public static void main(String[] args) { int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } }; 
	printMatrix(matrix); 
	System.out.println();
	rotate(matrix);
	print(matrix);
	
	} 
	
	
	public static void printMatrix(int[][] matrix){
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while(tR <= dR && tC <= dC){
			printCircle(matrix, tR++, tC++, dR--, dC--);
		}
		
	}
	public static void printCircle(int[][] matrix, int tR,int tC,int dR, int dC){
		if(tR == dR){
			for(int i = tC; i <= dC; i++){
				System.out.print(matrix[tR][i] + " ");
			}
		}else if(tC == dC){
			for(int i = tR; i <= dR; i++){
				System.out.print(matrix[i][tC] + " ");
			}
		}else{
			int curC = tC;
			int curR = tR;
			while(curC != dC){
				System.out.print(matrix[tR][curC]+" ");
				curC++;
			}
			while(curR != dR){
				System.out.print(matrix[curR][dC]+" ");
				curR++;
			}
			while(curC != tC){
				System.out.print(matrix[curR][curC] + " ");
				curC--;
			}
			while(curR != tR){
				System.out.print(matrix[curR][curC] + " ");
				curR--;
			}
		}
	}
	
	public static void rotate(int[][] matrix){
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while(tR < dR){
			rotateEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}
	
	public static void rotateEdge(int[][] m, int tR,int tC,int dR,int dC){
		int times = dC - tC;
		int temp = 0;
		for(int i = 0; i != times;i++){
			temp = m[tR][tC+i];
			m[tR][tC+i] = m[dR-i][tC];
			m[dR-i][tC] = m[dR][dC-i];
			m[dR][dC-i] = m[tR + i][dC];
			m[tR + i][dC] = temp;
			
		}
	}
	
	public static void print(int[][] matrix){
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		for(int j = 0; j <= dR ;j++){
			for(int i = 0; i <= dC; i++){
				System.out.print(matrix[j][i] + " ");
			}
			System.out.println();
		}
	}
}
