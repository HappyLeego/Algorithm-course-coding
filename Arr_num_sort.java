package com.offer;

public class Arr_num_sort {
	//把小于等于num的数放在左边，大于num的数放在右边
	public static void partition(int[] arr,int L, int R,int num){
		int less = L - 1;
		int cur = L;
		while(cur <= R){
			if(arr[cur] <= num){
				swap(arr,++less,cur++);
			}else{
				cur++;
			}
		}
	}
	//把小于num的数放在左边，等于的放在中间，大于的放在右边
	
	public static void partition_flag(int[] arr, int L, int R,int num){
		int less = L - 1;
		int more = R + 1;
		int cur = L;
		while(cur < more){
			if(arr[cur] < num){
				swap(arr,++less,cur++);
			}else if(arr[cur] > num){
				swap(arr,--more,cur);
			}else{
				cur++;
			}
		}
	}
	public static void swap(int[] arr, int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {3,4,5,1};
		int num = 4;
		partition(arr, 0, arr.length-1, num);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		int[] arr1 = {9,2,1,4,4,4,6,3,2,4};
		partition_flag(arr1, 0, arr1.length-1, num);
		for(int i = 0; i < arr1.length;i++){
			System.out.print(arr1[i]+" ");
		}
	}
}
