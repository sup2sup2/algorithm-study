import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static ArrayList<Integer>[] lists;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			
			lists = new ArrayList[100];
			for(int i = 0; i < 100; i++) {
				lists[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			int tNo = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				
				lists[num].add(next);
			}
			
			Queue<ArrayList<Integer>> q = new ArrayDeque<>();
			
			q.offer(lists[0]);
			
			boolean check = false;
			
			while(!q.isEmpty()) {
				ArrayList<Integer> curList = q.poll();
				
				for(int i = 0; i < curList.size(); i++) {
					int a = curList.get(i);
					
					if(a == 99) {
						check = true;
						break;
					}
					
					q.offer(lists[a]);
				}
				if(check) break;
			}
			sb.append("#").append(t).append(" ");
			if(check) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);

	}

}
