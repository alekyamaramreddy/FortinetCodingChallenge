package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KSetProblem {

	// TODO Auto-generated constructor stub

	// We can solve this problem recursively, we keep an array for sum of each
	// partition and a boolean array to check whether an element is already
	// taken into some partition or not.
	// First we need to check some base cases,
	// If K is 1, then we already have our answer, complete array is only subset
	// with same sum.
	// If N < K, then it is not possible to divide array into subsets with equal
	// sum, because we can’t divide the array into more than N parts.
	// If sum of array is not divisible by K, then it is not possible to divide
	// the array. We will proceed only if k divides sum. Our goal reduces to
	// divide array into K parts where sum of each part should be array_sum/K
	// In below code a recursive method is written which tries to add array
	// element into some subset. If sum of this subset reaches required sum, we
	// iterate for next part recursively, otherwise we backtrack for different
	// set of elements. If number of subsets whose sum reaches the required sum
	// is (K-1), we flag that it is possible to partition array into K parts
	// with equal sum, because remaining elements already have a sum equal to
	// required sum.

	public static boolean separate(List<Integer> list, int k) {

		if (k == 1)
			return true;

		// if k is greater than total number of elements, then no partition
		// possible.

		if (list.size() < k)
			return false;

		// if the sum of the elements in the list is not divisible by k, then we
		// cannot partition the array in to k sets.

		int sum = 0;
		for (int i : list) {
			sum = sum + i;
			// System.out.println(sum);
		}

		if ((sum % k) != 0)
			return false;

		// else there is a possibility of making this set

		int subsetPos = sum / k; // possible number of subsets
		int[] partition = new int[k]; // creating partitions, to store the sum
										// of each partition.
		boolean parResult[] = new boolean[list.size()]; // boolean array to mark
														// the elements being
														// used or not.

		// Initialize sum of each subset from 0
		for (int i = 0; i < k; i++)
			partition[i] = 0;

		// Initializing this array, indication that none of the elements were
		// used.
		for (int i = 0; i < list.size(); i++)
			parResult[i] = false;

		// starting with last element in the list and marking that the element
		// is used.

		partition[0] = list.get(list.size() - 1);
		parResult[list.size() - 1] = true;

		// making a recursive call to check k partition condition.
		return isKPartitionPossibleRec(list, partition, parResult, subsetPos, k, list.size(), 0, list.size() - 1);
	}

	private static boolean isKPartitionPossibleRec(List<Integer> list, int[] partition, boolean[] parResult,
			int subsetPos, int k, int N, int startPos, int endPos) {
		// TODO Auto-generated method stub

		if (partition[startPos] == subsetPos) {
			if (startPos == k - 2)
				return true;
			// recursive call for next substitution
			return isKPartitionPossibleRec(list, partition, parResult, subsetPos, k, N, startPos + 1, N - 1);

		}

		// start from last element and include elements into current partition
		for (int i = endPos; i >= 0; i--) {
			// if already taken, continue
			if (parResult[i])
				continue;
			int temp = partition[startPos] + list.get(i);

			// if temp variable is less than subset then only include the
			// element and call recursively
			if (temp <= subsetPos) {
				// mark the element and include into current partition sum
				parResult[i] = true;
				partition[startPos] += list.get(i);
				boolean nxt = isKPartitionPossibleRec(list, partition, parResult, subsetPos, k, N, startPos, i - 1);
				parResult[i] = false; // making element as noticed.
				partition[startPos] -= list.get(i);
				if (nxt)
					return true;
			}
		}

		return false;
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of partitions\n");

		int k = sc.nextInt();

		System.out.println("Enter the elements and enter any NON INTEGER to stop consuming the input");
		List<Integer> list = new ArrayList<Integer>();

		while (sc.hasNextInt()) {
			list.add(sc.nextInt());

		}

		sc.close();
		// list.add(2);
		// list.add(3);
		// list.add(4);
		// list.add(5);
		// list.add(6);
		// list.add(2);

		boolean result = separate(list, k);
		System.out.println(result);

	}
}
