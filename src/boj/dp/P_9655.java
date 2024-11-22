package boj.dp;

import java.io.*;
import java.util.*;

public class P_9655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        int res = dp(dp, N);
        if(res % 2 == 0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }

    static int dp(int[] dp, int n){
        if(dp[n] != 0){
            return dp[n];
        }
        int min = Math.min(dp(dp, n - 1) + 1, dp(dp, n - 3) + 1);
        dp[n] = min;
        return min;
    }
}
