package boj.dp;

import java.util.*;
import java.io.*;

public class P_1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] memo = new int[n+1];
            int[][] ans = new int[n+1][2];
            Arrays.fill(memo, -1);
            dp(n, memo, ans);
            System.out.printf("%d %d%n", ans[n][0], ans[n][1]);
        }
    }

    static int dp(int n, int[] memo, int[][] ans){
        if(n == 0){
            memo[n] = 0;
            ans[n][0] = 1;
            return 0;
        }
        if(n == 1){
            memo[n] = 1;
            ans[n][1] = 1;
            return 1;
        }
        int a = memo[n-1] == -1 ? dp(n-1, memo, ans) : memo[n-1];
        int b = memo[n-2] == -1 ? dp(n-2, memo, ans) : memo[n-2];
        int res = a + b;
        memo[n] = res;
        ans[n][0] = ans[n-1][0] + ans[n-2][0];
        ans[n][1] = ans[n-1][1] + ans[n-2][1];
        return res;
    }

}
