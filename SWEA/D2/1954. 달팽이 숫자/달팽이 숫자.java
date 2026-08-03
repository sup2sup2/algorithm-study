
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[][] map;
    static boolean[][] check;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	n = Integer.parseInt(br.readLine());
        	map = new int[n][n];
        	check = new boolean[n][n];
        	int cnt= 1;
        	int curR = 0;
        	int curC = 0;
        	int ind = 0;
        	System.out.println("#" + t);
        
        	while(cnt<=n*n) {
        		map[curR][curC] = cnt++;
        		check[curR][curC] = true;
        		int fr = curR + dr[ind % 4];
        		int fc = curC + dc[ind % 4];
        		if(fr < 0 ||  fr >= n || fc < 0 || fc >= n || check[fr][fc]) {
        			curR = curR + dr[(1+ind) % 4];
        			curC = curC + dc[(1+ind) % 4];
        			ind++;
        			continue;
        		}
        		curR = fr;
        		curC = fc;
        	}
        	
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			System.out.print(map[i][j] + " ");
        		}
        		System.out.println();
        	}
        }
    }
}