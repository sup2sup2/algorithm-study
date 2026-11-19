import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static int start;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = 10;
        
        for(int t = 1; t <= T; t++) {
        	
        	st = new StringTokenizer(br.readLine());
        	
        	n = Integer.parseInt(st.nextToken());
        	
        	start = Integer.parseInt(st.nextToken());
        	
        	List<Integer>[] map = new ArrayList[101];
        	boolean[] visited = new boolean[101];
        	
        	for(int i = 0; i < 101; i++) {
        		map[i] = new ArrayList<>();
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i < n/2; i++) {
        		int fst = Integer.parseInt(st.nextToken());
        		int sec = Integer.parseInt(st.nextToken());
        		
        		map[fst].add(sec);
        	}
        	
        	Queue<int[]> q = new ArrayDeque<>();
        	
        	q.offer(new int[] {start, 0});
        	visited[start] = true;
        	int max = 0;
        	int ans = 0;
        	while(!q.isEmpty()) {
        		int[] arr = q.poll();
        		int cur = arr[0];
        		int num = arr[1];
        		if(max < num) {
        			max = num;
        			ans = cur;
        		}
        		if(max == num) {
        			if(ans < cur) {
        				ans = cur;
        			}
        		}
        		for(int i = 0; i < map[cur].size(); i++) {
        			
        			if(visited[map[cur].get(i)]) continue;
        			
        			q.offer(new int[] {map[cur].get(i), num+1});
        			visited[map[cur].get(i)] = true;
        			
        		}
        	}
        	
        	sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        
        System.out.println(sb);  
    }
}

