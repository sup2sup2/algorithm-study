

import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] map;
	static boolean[][] visited;
 
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = 10;
    	
    	for(int t = 1; t <= T; t++) {
    		int testNum = Integer.parseInt(br.readLine());
    		map = new int[100][100];
    		visited = new boolean[100][100];
    		
    		int startX = -1;
    		int startY = -1;
    		for(int i = 0; i < 100; i++) {
    			String s = br.readLine();
    			
    			for(int j = 0; j < 100; j++) {
    				int a = s.charAt(j) - '0';
    				
    				map[i][j] = a;
    				
    				if(a == 2) {
    					startX = i;
    					startY = j;
    				}
    			}
    		}
    		
    		Queue<int[]> q = new ArrayDeque<>();
    		
    		q.offer(new int[] {startX, startY});
    		visited[startX][startY] = true;
    		
    		boolean check = false;
    		
    		while(!q.isEmpty()) {
    			
    			int[] cur = q.poll();
    			
    			int curX = cur[0];
    			int curY = cur[1];
    			
    			if(map[curX][curY] == 3) {
    				check = true;
    				break;
    			}
    			
    			for(int i = 0; i < 4; i++) {
    				int fx = curX + dx[i];
    				int fy = curY + dy[i];
    				
    				if(fx < 0 || fx >= 100 || fy < 0 || fy >= 100) continue;
    				if(map[fx][fy] == 1 || visited[fx][fy]) continue;
    				
    				q.offer(new int[] {fx, fy});
    				visited[fx][fy] = true;
    			}
    			
    		}
    		sb.append("#").append(t).append(" ");
    		if(check) {
    			sb.append(1);
    		}else {
    			sb.append(0);
    		}
    		
    		sb.append("\n");
    			
    	}
    	

        System.out.println(sb);
    }
}