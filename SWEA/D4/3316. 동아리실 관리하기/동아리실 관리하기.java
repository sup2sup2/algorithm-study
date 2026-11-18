import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
        	
        	String str = br.readLine();
        	
        	int N = str.length();
        	int[] reqList = new int[N+1];
        	for(int i = 0; i < N; i++) {
        		char c = str.charAt(i);
        		
        		switch(c) {
        		case 'A':
        			reqList[i+1] = 1;
        			break;
        		case 'B':
        			reqList[i+1] = 2;
        			break;
        		case 'C':
        			reqList[i+1] = 4;
        			break;
        		case 'D':
        			reqList[i+1] = 8;
        			break;
        		}
        	}
        	
        	
        	int[][] dp = new int[N+1][16];
        	dp[0][1] = 1;
        	
        	for(int day = 1; day <= N; day++) {
        		
        		for(int yester = 1; yester < 16; yester++) {
        			for(int today = 1; today < 16; today++) {
        				if((reqList[day] & today) == 0) continue;
        				if((yester & today) == 0) continue;
        				
        				dp[day][today] += dp[day-1][yester];
        				dp[day][today] %= MOD;
        			}
        		}
        		
        	}
        	long cnt = 0;
        	for(int i = 1; i < 16; i++) {
        		cnt += dp[N][i];
        	}
        	
        	cnt %= MOD;
        	
        	System.out.println("#" + t + " " + cnt);
        }
          
    }
}
