package com.offer;

import java.util.Arrays;

import javax.swing.plaf.SliderUI;

import org.omg.PortableInterceptor.SUCCESSFUL;

public class SortAlgorithm {
	public static int[] bubbleSort(int[] arr){
		if(arr == null || arr.length < 2){
			return null;
		}
		for(int j = arr.length-1; j > 0;j--){
		    for(int i = 0 ; i < j;i++){
				if(arr[i] > arr[i+1]){
					swap(arr,i,i+1);
				}
			}
		}
		return arr;
		
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void selectSort(int[] arr){
		if(arr == null || arr.length < 2){
			return;
		}
		for(int i = 0; i < arr.length;i++){
			int minIndex = i;
			for(int j = i+1; j < arr.length; j++){
				minIndex = arr[j]<arr[minIndex] ? j : minIndex;
			}
			
			swap(arr,i,minIndex);
		}
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
		}
		
	}
	
	public static void insertSort(int[] arr){
		if(arr == null || arr.length < 2){
			return;
		}
		
		for(int i = 1; i < arr.length; i++){
			for(int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--){
				swap(arr, j, j+1);
			}
		}
		
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
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
		
//		int[] arr = {5,3,1,8,7};
//		bubbleSort(arr);
//		System.out.println();
//		selectSort(arr);
//		System.out.println();
//		insertSort(arr);
		
		int testTimes = 500;
		int maxSize = 10;
		int maxValue = 10;
		boolean success = true;
		for(int i = 0; i < testTimes;i++){
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			bubbleSort(arr1);
			comparator(arr2);
			if(!isEqual(arr1, arr2)){
				success = false;
				break;
			}
		}
		System.out.println(success ? "Nice" : "Fuck");
		
		int[] arr = generateRandomArray(maxSize, maxValue);
		printArr(arr);
		
		bubbleSort(arr);
		printArr(arr);
	}
}
