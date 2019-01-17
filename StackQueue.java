package com.offer;
import java.util.*;

public class StackQueue {
	private Stack<Integer> popStack;
	private Stack<Integer> pushStack;
	
	public StackQueue() {
		popStack = new Stack<Integer>();
		pushStack = new Stack<Integer>();
	}
	
	public Integer outQueue() throws Exception{
		dao();
		if(popStack.isEmpty()){
			throw new Exception("The queue is empty");
		}
		return popStack.pop();
	}
	
	public void inQueue(Integer obj){
		dao();
		pushStack.push(obj);
		dao();
	}
	public void dao(){
		if(!popStack.isEmpty()){
			return;
		}
		while(!pushStack.isEmpty()){
			popStack.add(pushStack.pop());
		}
	}
	
	
	public class QueueStack{
		private Queue<Integer> dataQueue;
		private Queue<Integer> helpQueue;
		public QueueStack(){
			dataQueue = new LinkedList<Integer>();
			helpQueue = new LinkedList<Integer>();
		}
		
		public void push(Integer obj){
			dataQueue.add(obj);
		}
		
		public Integer pop() throws Exception{
			if(dataQueue.isEmpty()){
				throw new Exception("The stack is empty");
			}
			while(dataQueue.size() > 1){
				helpQueue.add(dataQueue.poll());
			}
			int res = dataQueue.poll();
			swap();
			return res;
		}
		
		public Integer peak() throws Exception{
			if(dataQueue.isEmpty()){
				throw new Exception("The stack is empty");
			}
			while(dataQueue.size() > 1){
				helpQueue.add(dataQueue.poll());
			}
			int res = dataQueue.poll();
			helpQueue.add(res);
			swap();
			return res;
		}
		public void swap(){
			Queue<Integer> temp = dataQueue;
			dataQueue = helpQueue;
			helpQueue = temp;
		}
	}
}
