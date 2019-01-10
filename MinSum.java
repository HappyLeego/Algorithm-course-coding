package com.offer;

public class MinSum {
	public static int minSum(int[] arr){
		if(arr == null || arr.length < 2){
			return 0;
		}
		return mergeProcess(arr,0,arr.length-1);
	}
	public static int mergeProcess(int[] arr, int L, int R){
		if(L == R){
			return 0;
		}
		int middle = L + ((R-L)>>1);
		return mergeProcess(arr, L, middle) + mergeProcess(arr, middle + 1, R) + merge(arr , L , middle , R);
	}
	
	public static int merge(int[] arr, int L,int middle, int R){
		int[] help = new int[R-L+1];
		int i = 0;
		int p1 = L;
		int p2 = middle + 1;
		int res = 0;
		while(p1 <= middle && p2 <= R){
			res += arr[p1] < arr[p2] ? (R-p2+1)*arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= middle){
			help[i++] = arr[p1++];
		}
		while(p2 <= R){
			help[i++] = arr[p2++];
		}
		
		for(i = 0; i < (R-L+1);i++){
			arr[L+i] = help[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,4,2,5};
		System.out.println(minSum(arr));
	}
}
