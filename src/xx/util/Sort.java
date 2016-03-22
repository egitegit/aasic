package xx.util;

import java.util.Arrays;
import java.util.Random;

public class Sort {
	private int[] nums = new int[10];
	public void generate() {
		Random random = new Random();
		for(int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(100);
		}
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < nums.length; i++) {
			stringBuilder.append(nums[i]);
			stringBuilder.append(" ");
		}
		return stringBuilder.substring(0, stringBuilder.length() - 1);
	}
	
	public void selectSort() {
		int index;
		for(int i = 0; i < nums.length - 1; i++) {
			index = i;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[index] > nums[j])
					index = j;
			}
			if(index != i) {
				int temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
			}
			System.out.println(this);
		}
	}
	
	public void bubbleSort() {
		int temp;
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length - 1 - i; j++) {
				if(nums[j] > nums[j + 1]) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
			System.out.println(this);
		}
	}
	
	public void quickSort(int start, int end) {
		int lo = start, hi = end - 1;
		int mid = nums[(hi + lo)/2];
		int temp;
		
		while(lo <= hi) {
			while(lo < end && nums[lo] < mid)
				lo++;
			while(hi >= start && nums[hi] > mid)
				hi--;
			if(lo <= hi) {
				temp = nums[lo];
				nums[lo] = nums[hi];
				nums[hi] = temp;
				lo++;
				hi--;
			}
			System.out.println(this);
		}
		
		if(lo < end) 
			quickSort(lo, end);
		if(hi > start)
			quickSort(start, hi + 1);
	}
	public void quickSort2(int start, int end) {
		int lo = start, hi = end - 1;
		int index = lo;
		int temp;
		while(lo <= hi) {
			while(hi >= start && nums[hi] >= nums[index]) {
				hi--;
			}
			if(hi >= lo) {
				temp = nums[hi];
				nums[hi] = nums[index];
				nums[index] = temp;
				index = hi--;
			}
			while(lo < end && nums[lo] <= nums[index]) {
				lo++;
			}
			if(hi >= lo) {
				temp = nums[lo];
				nums[lo] = nums[index];
				nums[index] = temp;
				index = lo++;
			}
		}
		if(index > start)
			quickSort(start, index);
		if(end > index + 1)
			quickSort(index + 1, end);
	}
	
	public void insertSort() {
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i] < nums[j]) {
					int temp = nums[i];
					for(int p = i; p > j; p--) {
						nums[p] = nums[p - 1];
					}
					nums[j] = temp;
				}
			}
			System.out.println(this);
		}
	}
	
	public void sort() {
		Arrays.sort(nums);
	}
	
	public void shift() {
		int temp;
		for(int i = 0, j = nums.length - 1; i < j; i++, j--) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			System.out.println(this);
		}
	}
}