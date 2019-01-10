package com.offer;

import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int[] arr){
		if(arr == null || arr.length < 2){
			return;
		}
		sortProcess(arr, 0, arr.length-1);
	}
	
	public static void sortProcess(int[] arr, int L, int R){
		if(L == R){
			return;
		}
		int middle = L + ((R-L)>>1);
		sortProcess(arr, L, middle);
		sortProcess(arr, middle+1, R);
		merge(arr,L,middle,R);
	}
	
	public static void merge(int[] arr, int L, int middle, int R){
		int[] help = new int[R-L+1];
		int i = 0;
		int p1 = L;
		int p2 = middle + 1;
		while(p1 <= middle && p2 <= R){
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= middle){
			help[i++] = arr[p1++];
		}
		while(p2 <= R){
			help[i++] = arr[p2++];
		}
		for(int j = 0 ; j < (R-L+1) ; j++){
			arr[L+j] = help[j];
		}
	}
	
	//一个绝对正确的数组排序的方法
	public static void comparator(int[] arr){
		Arrays.sort(arr);
	}
	
	//test,随机数组产生器
	public static int[] generateRandomArray(int maxSize, int maxValue){
		int[] arr = new int[(int) ((int)(maxSize+1)*Math.random())];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}
	
	//数组的copy
	public static int[] copyArray(int[] arr){
		if(arr == null){
			return null;
		}
		int[] copyArr = new int[arr.length];
		for(int i = 0; i< arr.length;i++){
			copyArr[i] = arr[i];
		}
		return copyArr;
	}
	
	//数组的比较
	public static boolean isEqual(int[] arr1, int[] arr2){
		if(arr1 == null && arr2 != null || arr1 != null && arr2 == null){
			return false;
		}
		if(arr1 == null && arr2 == null){
			return true;
		}
		if(arr1.length != arr2.length){
			return false;
		}
		for(int i = 0; i < arr1.length; i++){
			if(arr1[i] != arr2[i]){
				return false;
			}
		}
		return true;
	}
	
	//输出数组
	public static void printArr(int[] arr){
		if(arr == null || arr.length <= 0){
			return;
		}
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int testTimes = 500;
		int maxSize = 100;
		int maxValue = 100;
		boolean success = true;
		for(int i = 0; i < testTimes;i++){
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort(arr1);
			comparator(arr2);
			if(!isEqual(arr1, arr2)){
				success = false;
				break;
			}
		}
		System.out.println(success ? "Nice" : "Fuck");
		
		int[] arr = generateRandomArray(maxSize, maxValue);
		printArr(arr);
		
		mergeSort(arr);
		printArr(arr);
	}
}
