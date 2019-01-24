package com.offer;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GreedyCostAlgorithm {
	public static class Node{
		int c;
		int p;
		public Node(int p,int c){
			this.c = c;
			this.p = p;
		}
	}
	
	public static class MinheapComparator implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2){
			return o1.c - o2.c;
		}
	}
	
	public static class MaxHeapComparator implements Comparator<Node>{
		@Override
		public int compare(Node o1,Node o2){
			return o2.p-o1.p;
		}
	}
	
	public static int greedyCost(int k, int W,int[] profits,int[] cost){
		Node[] nodes = new Node[profits.length];
		for(int i = 0; i < profits.length; i++){
			nodes[i] = new Node(profits[i],cost[i]);
		}
		PriorityQueue<Node> minHeapCost = new PriorityQueue<Node>(new MinheapComparator());
		PriorityQueue<Node> maxHeapProfit = new PriorityQueue<Node>(new MaxHeapComparator());
		
		for(int i = 0 ; i < profits.length ; i++){
			minHeapCost.add(nodes[i]);
		}
		for(int i = 0; i < k; i++){
			while(!minHeapCost.isEmpty() && minHeapCost.peek().c <= W){
				maxHeapProfit.add(minHeapCost.poll());
			}
			if(maxHeapProfit.isEmpty()){
				return W;
			}
			W+=maxHeapProfit.poll().p;
		}
		return W;
		
	}
	public static void main(String[] args) {
		int[] profits = {3,1,2};
		int[] cost = {10,12,20};
		System.out.println(greedyCost(3, 10, profits, cost));
	}
}
