package GreedyMethodProblems;

import java.util.*;

public class JobSeqDeadline {

	class Job implements Comparable<Job> {
		int id;
		int profit;
		int deadline;

		public Job(int id, int profit, int deadline) {
			this.id = id;
			this.profit = profit;
			this.deadline = deadline;
		}

		@Override
		public int compareTo(Job o) {
			return o.profit - this.profit; // descending order
		}

	}

	public void MaxProfit(ArrayList<Job> array) {

		// here i am calculating the maximum slots i have
		int max = 0;
		for (Job j : array) {
			if (j.deadline > max) {
				max = j.deadline;
			}
		}

		// sorted in descending order
		Collections.sort(array);

		// slots are represented through array
		int[] selectedJobs = new int[max];

		// if for a job in its deadline slots are empty then add
		int profit = 0;
		for (Job j : array) {

			if (max == 0) {
				break;
			}

			int i = j.deadline - 1;
			while (i >= 0) {
				if (selectedJobs[i] == 0) {
					selectedJobs[i] = j.id;
					profit += j.profit;
					max--;
					break;
				}
				i--;
			}

		}

		
		// printing results
		for (int i : selectedJobs) {
			System.out.print("   " + i);
		}
		System.out.println("\n   profit is " + profit);

	}

	public static void main(String[] args) {
 
		JobSeqDeadline j = new JobSeqDeadline();
		ArrayList<Job> arr = new ArrayList<>();
		 
        arr.add(j.new Job(1, 35, 3));
        arr.add(j.new Job(2, 30, 4));
        arr.add(j.new Job(3, 25, 4));
        arr.add(j.new Job(4, 20, 2));
        arr.add(j.new Job(5, 15, 3));
        arr.add(j.new Job(4, 12, 1));
        arr.add(j.new Job(5, 5, 2));
        
        j.MaxProfit(arr);
		
	}

}

// time complexity is n^2; space is n
