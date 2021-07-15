package GreedyMethodProblems;

import java.util.*;

// compression technique

class Node implements Comparable<Node> {
	char character;
	int frequency;
	Node left, right;

	public Node(char character, int frequency) {
		this.character = character;
		this.frequency = frequency;
		left = right = null;
	}

	@Override
	public int compareTo(Node o) {
		// ascending order
		return this.frequency - o.frequency;
	}

}

public class HuffmanCoding {
//	LinkedList<Integer> codes = new LinkedList<>();

	public Node createHuffTree(char[] ch, int[] f) {

		PriorityQueue<Node> q = new PriorityQueue<>();
		// adding nodes to min heap
		for (int i = 0; i < ch.length; i++) {
			q.add(new Node(ch[i], f[i]));
		}
		
		//
		
		while (q.size() > 1) {

			Node n1 = q.remove();
			Node n2 = q.remove();

			Node n3 = new Node('@', n1.frequency + n2.frequency);
			q.add(n3);

			n3.left = n1;
			n3.right = n2;
		}
		return q.remove();

	}

	// print code of each character
	public void printCode(Node node, String s) {
		// base condition
		if(node.left == null && node.right == null) {
			System.out.println(node.character + " -> " + s);
			return;
		}

		printCode(node.left, s + "0");
		printCode(node.right, s + "1");

	}

	public static void main(String[] args) {

		HuffmanCoding h = new HuffmanCoding();
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
        Node node = h.createHuffTree(charArray, charfreq);
        h.printCode(node, "");
		
		
	}

}
