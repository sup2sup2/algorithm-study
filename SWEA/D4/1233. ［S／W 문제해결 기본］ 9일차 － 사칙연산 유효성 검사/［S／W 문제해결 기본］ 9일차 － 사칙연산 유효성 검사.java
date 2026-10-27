

import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	public class Node{
		char node;
		char left;
		char right;
		
		public Node(char node, char left, char right) {
			this.node = node;
			this.left = left;
			this.right = right;
		}
	}
 
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = 10;
    	
    	for(int t = 1; t <= T; t++) {
    		n = Integer.parseInt(br.readLine());
    		sb.append("#").append(t).append(" ");
    		
    		boolean check = true;
    		for(int i = 0; i < n; i++) {
    			st = new StringTokenizer(br.readLine());
    			
    			String index = st.nextToken();
    			
    			String a = st.nextToken();
    			
    			if(a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/") ){
    				try {
    					String b = st.nextToken();
    					String c = st.nextToken();
    				} catch (Exception e) {
    					check = false;
    				}
    			} else {
    				try {
    					String b = st.nextToken();
    					String c = st.nextToken();
    					check = false;
    				} catch (Exception e) {
    					
    				}
    			}
    		}
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