package GreedyMethodProblems;
import java.util.*;

// problem statement gfg

public class OptimalMergePattern {
	
	public int answer(int[] sizes) {
		
		if(sizes.length == 1) {
			return sizes[0];
		}
		
		int result = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0; i < sizes.length; i++) {
			q.add(sizes[i]);
		}
		
		while(q.size() > 1) {
			
			int l1 = q.remove();
			int l2 = q.remove();
			
			result += l1 + l2;
			q.add(l1 + l2);
			
		}
		
		return result;
	}

	public static void main(String[] args) {
		int sizes[] = new int[] { 2, 3, 5, 6};
		OptimalMergePattern m = new OptimalMergePattern();
		System.out.println(m.answer(sizes));
		
	}

}

// time complexity -> n