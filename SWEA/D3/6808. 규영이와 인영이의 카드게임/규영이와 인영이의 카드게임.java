import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] gyu;
	static int[] in;
	
	static int win;
	static int lose;
	
	static void dfs(int depth, int mask, int gyuScore, int inScore) {
		
		if(depth == 9) {
			
			if(gyuScore > inScore) {
				win++;
			} else {
				lose++;
			}
			
			return;
		}
		
		
		for(int i = 0; i < 9; i++) {
			
			if((mask & (1 << i)) != 0) {
				continue;
			}
			
			int sum = gyu[depth] + in[i];
			
			if(gyu[depth] > in[i]) {
				
				dfs(depth+1, mask | (1 << i), gyuScore + sum, inScore);
			} else {
				
				dfs(depth+1, mask | (1 << i), gyuScore, inScore+sum);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			gyu = new int[9];
			in = new int[9];
			
			boolean[] used = new boolean[19];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				used[gyu[i]] = true;

			}
			
			int index = 0;
			
			for(int i = 1; i <= 18; i++) {
				if(!used[i]) {
					in[index++] = i;
				}
			}
			
			win = 0;
			lose = 0;
			
			dfs(0,0,0,0);
			
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

}
