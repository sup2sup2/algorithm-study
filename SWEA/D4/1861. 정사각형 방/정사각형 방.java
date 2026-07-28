

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;


public class Solution
{	
	static int n;
	static int[][] board;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static boolean[][] visited;
	
	static int dfs(int r, int c, int cnt) {
	    visited[r][c] = true;
	    int maxCnt = cnt; 

	    for(int i = 0; i < 4; i++) {
	        int fr = dr[i] + r;
	        int fc = dc[i] + c;
	        if(fr >= 0 && fr < n && fc >= 0 && fc < n) {
	            if(!visited[fr][fc] && board[fr][fc] == board[r][c] + 1) {
	                int result = dfs(fr, fc, cnt + 1);
	                maxCnt = Math.max(maxCnt, result);
	            }
	        }
	    }

	    visited[r][c] = false; 
	    return maxCnt;
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				for(int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			int[][] count = new int[n][n];
			for(int i = 0; i < n; i++) {
			    for(int j = 0; j < n; j++) {
			        count[i][j] = dfs(i, j, 1);
			    }
			}
			int max = 0;
			int ans = 0;
			for(int i = 0; i < n; i++) {
			    for (int j = 0; j < n; j++) {
			        if(max < count[i][j]) {
			            max = count[i][j];
			            ans = board[i][j];
			        } else if(max == count[i][j]) {
			            ans = Math.min(ans, board[i][j]);
			        }
			    }
			}
			System.out.println("#" + t + " " + ans + " " + max);
		}
		
	}
}