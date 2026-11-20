import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static char[][] map;
	static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
	static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
        	
        	n = Integer.parseInt(br.readLine());
        	
        	map = new char[n][n];
        	
        	for(int i = 0; i < n; i++) {
        		String s = br.readLine();
        		for(int j = 0; j < n; j++) {
        			map[i][j] = s.charAt(j);
        		}
        	}
        	
        	boolean[][] visited = new boolean[n][n];
        	int ans = 0;
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			
        			
        			
        			if(map[i][j] == '*' || visited[i][j]) continue;
        			
	    			boolean check = false;
					for(int k = 0; k < 8; k++) {
						 int fx = i + dx[k];
						 int fy = j + dy[k];
						 if(fx < 0 || fx >= n || fy < 0 || fy >= n) continue;
						 if(map[fx][fy] == '*') {
							 check = true;
							 break;
						 }
					}
					if(check) continue;
    				 
        			
        			Queue<int[]> q = new ArrayDeque<>();
        			
        			q.offer(new int[] {i, j});
        			visited[i][j] = true;
        			
        			ans++;
        			
        			while(!q.isEmpty()) {
        				 int[] arr = q.poll();
        				 
        				 int x = arr[0];
        				 int y = arr[1];
        				 
        				boolean bomb = false;
     					for(int m = 0; m < 8; m++) {
     						 int fx = x + dx[m];
     						 int fy = y + dy[m];
     						 if(fx < 0 || fx >= n || fy < 0 || fy >= n) continue;
     						 if(map[fx][fy] == '*') {
     							 bomb = true;
     							 break;
     						 }
     					}
     					
     					if(bomb) continue;
        				
        				 for(int m = 0; m < 8; m++) {
        					 int fx = x + dx[m];
        					 int fy = y + dy[m];
        					 
        					 if(fx < 0 || fx >= n || fy < 0 || fy >= n) continue;
        					 
        					 
        					 
        					 if(visited[fx][fy]) continue;
        					 
        					 q.offer(new int[] {fx, fy});
        					 visited[fx][fy] = true;
        					 
        				 }
        				 
        
        			}
        			
        			
        		}

        	}
        	
        	for (int i = 0; i < n; i++) {
        	    for (int j = 0; j < n; j++) {
        	        if (map[i][j] == '.' && !visited[i][j]) {
        	            ans++;
        	        }
        	    }
        	}
        	
        	sb.append("#").append(t).append(" ").append(ans).append("\n");
        
        }
        
        System.out.println(sb);  
    }
}
