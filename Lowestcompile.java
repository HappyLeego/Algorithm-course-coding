package com.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lowestcompile {
	public static class Mycomparater implements Comparator<String>{

		@Override
		public int compare(String s1, String s2) {
			
			return (s1+s2).compareTo(s2+s1);
		}
			
	}
	
	public static String lowestCompile(String[] strs){
		if(strs == null || strs.length == 0){
			return "";
		}
		Arrays.sort(strs,new Mycomparater());
		String s = "";
		for(int i = 0; i < strs.length; i++){
			s+=strs[i];
		}
		return s;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
	    String[] strs = new String[n];
	    for(int i = 0; i < n; i++){
	    	strs[i] = scan.next();
	    }
	    System.out.println(lowestCompile(strs));
	}
}
