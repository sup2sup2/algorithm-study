import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;


public class Solution {
    static int n;
    static int[] check;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            
            int ans = 1;

            for (int i = 0; i < n; i++) {
            	char c = str.charAt(i);
            	
                if(c == '[' || c == '{' || c == '(' || c == '<') {
                	stack.push(c);
          
                } else  {
                	char top = stack.pop();
                	if(c == ']') {
                		if(top != '[') {
                		ans = 0;
                		break;
                		}
                	}
                	if(c == '}') {
                		if(top != '{') {
                		ans = 0;
                		break;
                		}
                	}
                	if(c == ')') {
                		if(top != '(') {
                		ans = 0;
                		break;
                		}
                	}
                	if(c == '>') {
                		if(top != '<') {
                		ans = 0;
                		break;
                		}
                	}
            	}
                  
            }
            if(!stack.isEmpty()) {
            	ans = 0;
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}

