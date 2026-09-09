import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	
	static int n,m;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = -1;
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					int a = arr[i] + arr[j];
					
					if(a <= m) {
						max = Math.max(max, a);
					}
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}

}
