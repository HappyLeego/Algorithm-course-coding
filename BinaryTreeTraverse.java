package com.offer;

import java.util.Stack;

public class BinaryTreeTraverse {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int data){
			this.value = data;
		}
	}
	//递归三种
	public static void preOrder(Node head){
		
		if(head != null){
			System.out.print(head.value + " ");
			preOrder(head.left);
			preOrder(head.right);		
		}
		//System.out.println();
	}
	
	public static void inOrder(Node head){
		
		if(head != null){
			inOrder(head.left);
			System.out.print(head.value + " ");
			inOrder(head.right);		
		}
		
	}
	
	public static void postOrder(Node head){
		
		if(head != null){
			postOrder(head.left);
			postOrder(head.right);
			System.out.print(head.value + " ");
		}
	
	}
	
	public static void preOrderTraverse(Node head){
		System.out.println("先序非递归遍历：");
		if(head != null){
			Stack<Node> stack = new Stack<Node>();
			stack.push(head);
			while(!stack.isEmpty()){
				head = stack.pop();
				System.out.print(head.value + " ");
				if(head.right != null){
					stack.push(head.right);
				}
				if(head.left != null){
					stack.push(head.left);
				}
				
			}
		}
		System.out.println();
	}
	
	public static void inOrderTraverse(Node head){
		System.out.println("中序非递归遍历：");
		if(head != null){
			Stack<Node> stack = new Stack<Node>();
			while(!stack.isEmpty() || head != null){
				if(head != null){
					stack.push(head);
					head = head.left;
				}else{
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
		
		System.out.println();
	}
	
	public static void postOrderTraverse(Node head){
		System.out.println("后序非递归遍历：");
		if(head != null){
			Stack<Node> stack = new Stack<Node>();
			Stack<Node> s = new Stack<Node>();
			stack.push(head);
			while(!stack.isEmpty()){
				head = stack.pop();
				s.push(head);
				if(head.left != null){
					stack.push(head.left);
				}
				if(head.right != null){
					stack.push(head.right);
				}
				
			}
			
			while(!s.isEmpty()){
				System.out.print(s.pop().value+" ");
		}
		
		}
		
		System.out.println();
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		Node node5 = new Node(6);
		Node node6 = new Node(7);
		
		head.left = node1;
		head.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = null;
		node3.right = null;
		node4.left = null;
		node4.right = null;
		node5.left = null;
		node5.right = null;
		node6.left = null;
		node6.right = null;
		System.out.println("先序递归遍历：");
		preOrder(head);
		System.out.println();
		preOrderTraverse(head);
		System.out.println("中序递归遍历：");
		inOrder(head);
		System.out.println();
		inOrderTraverse(head);
		System.out.println("后序递归遍历：");
		postOrder(head);
		System.out.println();
		postOrderTraverse(head);
		
	}
}
