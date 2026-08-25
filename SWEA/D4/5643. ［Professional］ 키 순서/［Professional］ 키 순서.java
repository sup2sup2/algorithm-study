

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, m;
	static boolean[][] board;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++ ) {
			n = Integer.parseInt(br.readLine());
			board = new boolean[n+1][n+1];
			m = Integer.parseInt(br.readLine());
			for(int i = 0; i < m; i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				board[a][b] = true;
			}
			
			for(int k = 1; k <= n; k++) {
				for(int i = 1; i <= n; i++) {
					for(int j = 1; j <= n; j++) {
						if(board[i][k] && board[k][j]) {
							board[i][j] = true;
						}
					}
				}
			}
			
			int ans = 0;
			for(int i = 1; i <= n; i++) {
				int cnt = 0;
				for(int j = 1; j <= n; j++) {
					if(board[i][j] || board[j][i]) {
						cnt++;
					}
				}
				if(cnt == n-1) {
					ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
			
		}
	}

}
