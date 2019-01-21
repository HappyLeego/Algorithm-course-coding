package com.offer;

public class GetSucessorNode {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		public Node(int value){
			this.value = value;
		}
	}
	
	public static Node getSuccessorNode(Node node){
		if(node == null){
			return node;
		}
		if(node.right != null){
			return getLeftNode(node.right);
		}else{
			Node parent = node.parent;
			while(parent != null && parent.left != null){
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	
	public static Node getLeftNode(Node node){
		if(node == null){
			return node;
		}
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	
	public static void main(String[] args) {
		
	}
}
