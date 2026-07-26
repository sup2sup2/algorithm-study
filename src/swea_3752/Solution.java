package swea_3752;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution
{	
	static int n;
	static int[] score;
	static boolean[] total;

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			score = new int[n];
			int sum = 0;
		
			for(int i = 0; i < n; i++) {
				
				score[i] = Integer.parseInt(st.nextToken());
				sum += score[i];
				
			}
			
			total = new boolean[sum+1];
			
			for(int i = 0; i < n; i++) {
				
				for(int j = sum - score[i]; j >= 0; j--) {
					if(total[j]) {
						total[j + score[i]] = true;
					}

				}
				if(!total[score[i]]) {
					total[score[i]] = true;
				}
				
			}
			int cnt = 0;
			for(int i = 0; i < total.length; i++) {
				if(total[i]) {
					cnt++;
				}
			}
			
			System.out.println("#" + t + " " + (cnt+1));
			
		}
		
		
	}
}