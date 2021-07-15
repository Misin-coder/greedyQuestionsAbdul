package GreedyMethodProblems;

import java.text.DecimalFormat;
import java.util.Arrays;

// problem statement is taken from gfg 
// input and output is from there

public class FractionalKnapsackProblem {

	double[][] array; // 2d array containing profit, weight at each index
	int m; // m is capacity for my bag

	class PW implements Comparable<PW> {
		double pw; // profit to weight ratio 
		double weight; // available weight of that item

		public PW(double pw, double weight) {
			this.pw = pw;
			this.weight = weight;
		}

		@Override
		// decreasing order as my natural ordering
		public int compareTo(PW o) {
			if (this.pw > o.pw) {
				return -1;
			} else if (this.pw < o.pw) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public double maximumProfit(double[][] array, double m) {
		this.array = array;
		
		// pw array will contain profit to weight ratio and weight so i have initialised
		PW[] pw = new PW[this.array.length];
		for (int i = 0; i < pw.length; i++) {
			double pu = (double) array[i][0] / array[i][1];
			double weight = array[i][1];
			pw[i] = new PW(pu, weight);

		}
 
		// decreasing ordering
		Arrays.sort(pw);

		int i = 0;
		double profit = 0;
		while (m > 0) {
			// if remaining weight is less than whole item weight we will add only fraction of item and break
			if (m < pw[i].weight) {
				profit += pw[i].pw * m;
				break;
			}
			// if an item is to added as whole to our bag
			profit += pw[i].pw * pw[i].weight;
			m = m - pw[i].weight;
			i++;
		}

		return profit;

	}

	public static void main(String[] args) {
		double arr[][] = { { 10, 2 }, { 5, 3 }, { 15, 5 }, { 7, 7 }, { 6, 1 }, { 18, 4 }, { 3, 1 } };
		double m = 15;
		FractionalKnapsackProblem fkp = new FractionalKnapsackProblem();
		// the following object help in printing double type value to 2 decimal digit 
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(df.format(fkp.maximumProfit(arr, m)));

	}

}
