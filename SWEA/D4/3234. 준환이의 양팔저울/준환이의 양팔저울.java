import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[] weight;
    static boolean[] visited;
    static int max;
    static long cnt;
    static long[] fact;
    static long[] pow2;

    static void dfs(int current, int depth, int right, int left) {
        visited[current] = true;

        if (right + left == max) {
            cnt++;
            visited[current] = false;
            return;
        }

        int remainCount = n - depth;
        int remainSum = max - right - left;


        if (right + remainSum <= left) {
            cnt += fact[remainCount] * pow2[remainCount];
            visited[current] = false;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (right + weight[i] <= left) {
                    dfs(i, depth + 1, right + weight[i], left);
                }
                dfs(i, depth + 1, right, left + weight[i]);
            }
        }

        visited[current] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int MAXN = 15; // n 최댓값에 맞게 조정
        fact = new long[MAXN + 1];
        pow2 = new long[MAXN + 1];
        fact[0] = 1;
        pow2[0] = 1;
        for (int i = 1; i <= MAXN; i++) {
            fact[i] = fact[i - 1] * i;
            pow2[i] = pow2[i - 1] * 2;
        }

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            weight = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            max = 0;
            cnt = 0;
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
                max += weight[i];
            }

            for (int i = 0; i < n; i++) {
                dfs(i, 1, 0, weight[i]);
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}