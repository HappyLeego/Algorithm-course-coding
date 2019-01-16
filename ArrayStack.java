package com.offer;


public class ArrayStack {
	private Integer[] arr;
	private Integer index;
	
	public ArrayStack(int initSize) throws Exception{
		if(initSize < 0){
			throw new Exception("The init size is less than zero!");
		}
		arr = new Integer[initSize];
		index = 0;
	}
	
	public Integer peak(){
		if(index == 0){
			return null;
		}
		return arr[index - 1];
	}
	
	public void push(Integer obj) throws Exception{
		if(index == arr.length){
			throw new Exception("The stack is full");
		}
		arr[index++] = obj;
	}
	
	public Integer pop() throws Exception{
		if(index == 0){
			throw new Exception("The stack is empty");
		}
		return arr[--index];
	}
	
	public static class ArrayQueue{
		private Integer[] arr;
		private Integer start;
		private Integer end;
		private Integer size;
		
		public ArrayQueue(int initSize) throws Exception{
			if(initSize < 0){
				throw new Exception("The init size is less than zero");
			}
			arr = new Integer[initSize];
			start = 0;
			end = 0;
			size = 0;
		}
		
		public Integer peak(){
			if(size == 0){
				return 0;
			}
			return arr[start];
		}
		
		public void push(Integer obj) throws Exception{
			if(size == arr.length){
				throw new Exception("The queue is full");
			}
			size++;
			arr[end] = obj;
			end = end == arr.length - 1 ? 0 : end++;
		}
		
		public Integer pop() throws Exception{
			if(size == 0){
				throw new Exception("The queue is empty");
			}
			size--;
			int temp = start;
			start = start == arr.length - 1 ? 0 : start--;
			return arr[temp];
		}
	}
	public static void main(String[] args) {
		
	}
}
