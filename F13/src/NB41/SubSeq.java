package NB41;

import java.util.Random;
import java.util.Scanner;

public class SubSeq {

	static int calls;

	static int getMaxSubSequence(int[] nums, int low, int high) {
		calls++;
		if (low == high) return nums[low];
		int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, sum = 0;
		int mid = low + (high - low) / 2;
		for (int i = mid; i >= 0; i--) {
			sum += nums[i];
			leftSum = Math.max(leftSum, sum);
		}
		sum = 0;
		for (int i = mid + 1; i <= high; i++) {
			sum += nums[i];
			rightSum = Math.max(rightSum, sum);
		}
		int midSum = leftSum + rightSum;
		return Math.max(midSum, Math.max(getMaxSubSequence(nums, low, mid),
				getMaxSubSequence(nums, mid + 1, high)));
	}




	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter array size: ");
		int n = scanner.nextInt();
		//int n = 10;
		int[] nums = randArr(n);
		//int[] nums = new int[] {0, 4, 6, 1, -4, 15, 2};
		int sum = getMaxSubSequence(nums, 0, nums.length - 1);
		System.out.println("Max sum of a subsequence: " + sum);
		System.out.println("Number of function calls: " + calls);


	}

	static int[] randArr(int n) {
		calls = 0;
		int[] nums = new int[n];
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			nums[i] = rand.nextInt(-1000, 1000);
		}
		return nums;
	}
}
