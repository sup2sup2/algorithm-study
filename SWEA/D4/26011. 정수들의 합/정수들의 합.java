import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
 
public class Solution {
	static int n, k;
    
	static long countPair(int sum) {
		if(sum < 2 || sum > 2*n) {
			return 0;
		}
		
		if(sum <= n+1) {
			return sum-1;
		} else{
			return 2L*n+1 - sum;
		}
	}
	
	
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int t = 1; t <= T; t++) {
    		st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		k = Integer.parseInt(st.nextToken());
    	
    		long ans = 0;
    		
    		for(int sumAB = 2; sumAB <= 2*n; sumAB++) {
    			int sumCD = sumAB-k;
    			
    			long abCount = countPair(sumAB);
    			long cdCount = countPair(sumCD);
    			
    			ans += abCount*cdCount;
    		}
    		
    		sb.append(ans).append("\n");
    		
    		
    	}
    	System.out.println(sb);
    	
    }
}