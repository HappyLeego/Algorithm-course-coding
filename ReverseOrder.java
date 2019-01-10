package com.offer;

public class ReverseOrder {
	public static void reverseOrder(int[] arr){
		if(arr == null && arr.length < 2){
			return;
		}
		processSort(arr,0,arr.length-1);
	}
	
	public static void processSort(int[] arr, int L, int R){
		if(L == R){
			return;
		}
		int middle = L + ((R-L)>>1);
		processSort(arr, L, middle);
		processSort(arr, middle + 1, R);
		merge(arr,L,middle,R);
	}
	
	public static void merge(int[] arr, int L, int middle, int R){
		int[] help = new int[R-L+1];
		int i = 0;
		int p1 = L;
		int p2 = middle + 1;
		while(p1 <= middle && p2 <= R){
			if(arr[p1] > arr[p2]){
				System.out.println("<" + arr[p1] + "," + arr[p2] + ">");
				help[i++] = arr[p1++];
			}else{
				help[i++] = arr[p2++];
			}
			
		}
		
		while(p1 <= middle){
			help[i++] = arr[p1++];
		}
		
		while(p2 <= R){
			help[i++] = arr[p2++];
		}
		
		for(i = 0; i < (R-L+1); i++){
			arr[L+i] = help[i];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,5,3,6,4};
		reverseOrder(arr);
	}
}
