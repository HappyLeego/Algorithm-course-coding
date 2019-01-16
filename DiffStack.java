package com.offer;

import java.util.Stack;

public class DiffStack {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public DiffStack(){
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
		
	}
	
	public void push(Integer newNum){
		if(stackMin.isEmpty()){
			this.stackMin.push(newNum);
		}else if(newNum < stackMin.peek()){
			this.stackMin.push(newNum);
		}else{
			newNum = this.stackMin.peek();
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}
	
	public Integer pop() throws Exception{
		if(this.stackData.isEmpty()){
			throw new Exception("The stack is empty");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}
	
	public Integer getMin() throws Exception{
		if(this.stackData.isEmpty()){
			throw new Exception("The stack is empty");
		}
		
		return this.stackMin.peek();
	}
}
