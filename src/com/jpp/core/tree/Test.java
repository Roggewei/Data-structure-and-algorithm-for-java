package com.jpp.core.tree;

public class Test {
	public static void main(String[] args){
		int[] arr = new int[]{12678686,233,23,23232,23,232,43,52,354,6,657,76,6,678686};
		BinaryTree tree = new BinaryTree(arr[0]);
		for(int i=1;i<arr.length;i++){
			tree.insert(tree, arr[i]);
		}
		tree.findNode(tree, 12678686);
	}
}
