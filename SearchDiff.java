package com.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchDiff {
	public static void find1(int[] arrA, int[] arrB,int N, int M){
		List<Integer> list = new ArrayList<Integer>();
	
		int k = 0;
		for(int i = 0; i < M; i++){
			for(int j = 0; j < N;j++){
				if(arrB[i] == arrA[j]){
					break;
				}
				if(j==N-1){
					list.add(arrB[i]);
				}
			}
		}
		int[] arr = new int[list.size()];
		for(int i = 0; i < arr.length;i++){
			arr[i] = list.get(i).intValue();
			System.out.print(arr[i]+",");
		}
	}
	
	public static int binarySearch(int[] arr, int x){
		int low = 0;
		int high = arr.length-1;
		while(low <= high){
			int middle = (low + high)/2;
			if(arr[middle] == x){
				return 1;
			}else if(arr[middle] < x){
				low = middle + 1;
			}else{
				high = middle - 1;
			}
		}
		return 0;
	}
	
	public static void find2(int[] arrA, int[] arrB,int N, int M){
	    List<Integer> list = new ArrayList<Integer>();
	    int flag = 0;
	    for(int i = 0; i < M; i++){
	    	flag = binarySearch(arrA, arrB[i]);
	    	if(flag == 0){
	    		list.add(arrB[i]);
	    	}
	    }
	    
	    int[] arr = new int[list.size()];
	    for(int i = 0; i < arr.length;i++){
	    	arr[i] = list.get(i).intValue();
	    }
	    
	    for(int i = 0; i < arr.length;i++){
			arr[i] = list.get(i).intValue();
			System.out.print(arr[i]+",");
		}
	}
	
	public static void find3(int[] arrA, int[] arrB,int N, int M){
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arrB.length;i++){
			set.add(arrB[i]);
		}
		int i = 0;
		for (Integer integer : set) {
			arrB[i] = integer;
			i++;
		}
		int n = 0;
		int m = 0;
		List<Integer> list = new ArrayList<Integer>();
		while(n < N && m < M){
			if(arrA[n] < arrB[m]){
				n++;
			}else if(arrA[n] == arrB[m]){
				n++;
				m++;
				continue;
			}else{
				list.add(arrB[m]);
				m++;
			}
			
			if(n == N-1 && m != M-1){
				for(int i1 = m; i1 < M; i1++){
					list.add(arrB[i1]);
				}
			}
		}
		
		int[] arr = new int[list.size()];
		for(int j = 0; j < arr.length;j++){
			arr[j] = list.get(j);
		}
		
		for(int i3 = 0; i3 < arr.length; i3++){
			arr[i3] = list.get(i3).intValue();
			System.out.print(arr[i3]+",");
		}
	}
	
	public static void main(String[] args) {
		int[] arrA = {2,4,5,7,8};
		int[] arrB = {10,4,5,9};
		
		find1(arrA,arrB,arrA.length,arrB.length);
		
		find2(arrA,arrB,arrA.length,arrB.length);
		
		find3(arrA,arrB,arrA.length,arrB.length);
	}
}
