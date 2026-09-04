import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int[][] map;
	static boolean[][] visited;
	static int ans;
	static void dfs(int x, int y) {
		visited[x][y] = true;
		if(map[x][y] == 3) {
			ans = 1;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= 16 || ny < 0 || ny >= 16) {
				continue;
			}
			if(visited[nx][ny] || map[nx][ny] == 1) {
				continue;
			}
			
			dfs(nx, ny);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++) {
            int tc = Integer.parseInt(br.readLine());
			map = new int[16][16];
			int startX,startY;
			startX = 0;
			startY = 0;
			for(int i = 0; i < 16; i++) {
				String a = br.readLine();
				for(int j = 0; j < 16; j++) {
					int num = a.charAt(j) - '0';
					map[i][j] = num;
					if(map[i][j]==2) {
						startX = i;
						startY = j;
					}
					
				}
			}
			visited = new boolean[16][16];
			ans = 0;
			
			dfs(startX, startY);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}
