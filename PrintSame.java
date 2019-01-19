package com.offer;

public class PrintSame {
	public static class Node{
		public int value;
		public Node next;
		public Node(int data){
			this.value = data;
		}
	}
	
	public static void printSame(Node head1,Node head2){
		while(head1 != null && head2 != null){
			if(head1.value == head2.value){
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}else if(head1.value < head2.value){
				head1 = head1.next;
			}else{
				head2 = head2.next;
			}
		}
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(1);
		Node head2 = new Node(2);
		Node node1 = new Node(3);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(6);
		
		head1.next = node1;
		node1.next = node3;
		head2.next = node2;
		node2.next = node4;
		
		printSame(head1, head2);
	}
}
