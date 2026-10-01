import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static char[][] map1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			
			map1 = new char[n][n];
			
			for(int r = 0; r < n; r++) {
				String s = br.readLine();	
				for(int c = 0; c < n; c++) {
					char a = s.charAt(c);
					map1[r][c] = a;
				}
			}
			int cnt = 0;
			for(int a = 0; a < n; a++) {
				boolean check = true;
				for(int i = 0; i < n && check; i++) {
			        int r1 = i + a;
			        if(r1 >= n) r1 -= n;
					for(int j = i+1; j < n; j++) {
						
						 int r2 = j + a;
				            if(r2 >= n) r2 -= n;

				            if(map1[r1][j] != map1[r2][i]) {
				                check = false;
				                break;
						}
						
					}
				}
				if(check) cnt+=n;
			}
			 sb.append(cnt).append("\n");
			
			
		}
		
		System.out.println(sb);
		
		
	}

}
