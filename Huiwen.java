package com.offer;

import java.util.Stack;

import com.offer.PrintSame.Node;

public class Huiwen {
	public static class Node{
		public int value;
		public Node next;
		public Node(int data){
			this.value = data;
		}
	}
	
	public static boolean isHuiwen1(Node head){
		if(head == null || head.next == null){
			return true;
		}
		Stack<Node> s = new Stack<Node>();
		Node p = head;
		
		while(p != null){
			s.push(p);
			p = p.next;
		}
		
		while(head != null){
			if(head.value != s.pop().value){  //每次比较就已经弹出了！！所以下面不需要再弹出！！
				return false;
			}
			head = head.next;
		//	s.pop();
		}
		return true;
	}
	
	public static boolean isHuiwen2(Node head){
		if(head == null || head.next == null){
			return true;
		}
		Node right = head;
		Node cur = head;
		while(cur.next != null && cur.next.next != null){
			right = right.next;
			cur = cur.next.next;
		}
		
		Stack<Node> stack = new Stack<Node>();
		while(right != null){
			stack.push(right);
			right = right.next;
		}
		
		while(!stack.empty()){
			if(head.value != stack.pop().value){
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	public static boolean isHuiwen3(Node head){
		if(head == null || head.next == null){
			return true;
		}
		Node n1 = head;
		Node n2 = head;
		while(n2.next != null && n2.next.next != null){
			n1 = n1.next;
			n2 = n2.next.next;
		}
		n2 = n1.next;
		n1.next = null;
		Node n3;
		
		while(n2 != null){
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		
		n3 = n1;
		n2 = head;
		boolean res = true;
		while(n1 != null && n2 != null){
			if(n1.value != n2.value){
				res = false;
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		
		n1 = n3.next;
		n3.next = null;
		while(n1 != null){
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		
		return res;
		
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(2);
		Node node4 = new Node(1);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		System.out.println(isHuiwen3(head));
	}
}
