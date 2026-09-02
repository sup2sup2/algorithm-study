import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int r,c;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	static char[][] map;
	static boolean[][] visited;
	
	static int ans;
	
	static void dfs(int curr, int curc) {
		visited[curr][curc] = true;
		
		ans++;
		
		for(int i = 0; i < 4; i++) {
			int nr = dr[i] + curr;
			int nc = dc[i] + curc;
			
			if(nr<0 || nr >= r || nc < 0 || nc >= c) {
				continue;
			}
			if(visited[nr][nc] || map[nr][nc] == '#') {
				continue;
			}
			
			dfs(nr, nc);
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			
			map = new char[r][c];
			visited = new boolean[r][c];
			
			ans = 0;
			
			for(int i = 0; i < r; i++) {
				String s = br.readLine();
				for(int j = 0; j < c; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			dfs(startR, startC);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb);
	}

}
