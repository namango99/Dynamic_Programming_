package DP;

import java.util.Scanner;

public class Shortest_Subsequence {
	
//	A person has two string S and V. Now he wants to know the length of the shortest subsequence in S such that it is not a subsequence in V.
//	input format
//	Line 1 : String S of length N (1 <= N <= 1000)
//	Line 2 : String V of length M (1 <= M <= 1000)
//	output format
//	Length of shortest subsequence in S such that it is not a subsequence in V

	public static int solve(String S,String V){
		int[][] dp = new int[S.length()+1][V.length()+1];

		for(int i=0;i<=S.length();i++){
			dp[i][0] = 1;
		}

		for(int i = 0;i<=V.length();i++){
			dp[0][i] = 10009;
		}

		for(int i=1;i<=S.length();i++){
			for(int j=1;j<=V.length();j++){
				char ch = S.charAt(i-1);
				int k ;
				for(k=j-1;k>=0;k--){
					if(V.charAt(k)==ch){
						break;
					}
				}

				if(k==-1){
					dp[i][j] = 1;
				}
				else{
					dp[i][j] = Math.min(dp[i-1][j],dp[i-1][k]+1);
				}
			}
		}

		int ans = dp[S.length()][V.length()];
		if(ans>10009)
			ans = -1;

		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S,V;
		Scanner scan = new Scanner(System.in);
		S = scan.next();
		V = scan.next();
		System.out.println(solve(S,V));
	}

}
