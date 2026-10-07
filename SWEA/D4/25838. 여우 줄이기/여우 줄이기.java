

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;




public class Solution {
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			String word = br.readLine();
			char[] stack = new char[n];
			int top = 0;
			for(int i = 0; i < n; i++) {
				char c = word.charAt(i);
				stack[top++] = c;

                // 마지막 3글자가 "fox"인지 확인
                if (top >= 3 &&
                    stack[top - 3] == 'f' &&
                    stack[top - 2] == 'o' &&
                    stack[top - 1] == 'x') {
                    top -= 3; // fox 제거 (그냥 포인터만 뒤로 이동)
                }
			}
			System.out.println(top);
			
		}
			
	}

}
