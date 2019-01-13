package com.offer;

import java.util.Arrays;

public class RandomQuickSort {
	public static void quickSort(int[] arr){
		if(arr == null || arr.length < 2){
			return;
		}
		randomQuickSort(arr, 0, arr.length - 1);
	}
	
	public static void randomQuickSort(int[] arr, int L , int R){
		
		if(L < R){
			swap(arr, L + (int)(Math.random()*(R-L+1)), R);
			int[] p = partition(arr, L, R);
			randomQuickSort(arr, L, p[0] - 1);
			randomQuickSort(arr, p[1] + 1, R);
			
		}
	}
	
	public static int[] partition(int[] arr, int L, int R){
		int less = L - 1;
		int more = R;
		while(L < more){
			if(arr[L] < arr[R]){
				swap(arr,++less,L++);
			}else if(arr[L] > arr[R]){
				swap(arr,--more,L);
			}else{
				L++;
			}
			
		}
		swap(arr,more,R);
		return new int[] {less+1,more};
	}
	
	//Êä³öÊý×é
	public static void printArr(int[] arr){
		if(arr == null || arr.length <= 0){
			return;
		}
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {1,5,3,77,4,2,1,1};
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		quickSort(arr);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}




