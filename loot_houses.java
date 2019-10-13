//  Ques>>  A thief wants to loot houses. He knows the amount of money in each house. 
//         He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
//
//  Input Format
//  Line 1 : An integer N 
//  Line 2 : N spaced integers denoting money in each house
//
//  Output Format
//  Line 1 : Maximum amount of money looted

package DP;

import java.util.*;
import java.util.Scanner;

public class loot_houses {

	public static int getMaxMoney(int arr[], int n){

		int[] memory =new int[arr.length+1];

		memory[0]=0;
		memory[1]=arr[0];
		

		for(int i=2; i<= arr.length;i++) {

			int ans1= Integer.MIN_VALUE;
			
			for(int j=0; j<i-1; j++) {
				if(memory[j]>ans1) {
					ans1=memory[j];
				}
			}
			memory[i]= arr[i-1]+ans1;
		}

		int ansfinal= Math.max(memory[arr.length],memory[arr.length-1]);
		
		return ansfinal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}
		System.out.println(getMaxMoney(arr, n));
	}
}
