package boj.dp;

import java.util.*;
import java.io.*;

public class P_1965 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] boxs = new int[N];

        String[] tokens = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            boxs[i] = Integer.parseInt(tokens[i]);
        }
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(boxs[i] > boxs[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i : dp){
            max = Math.max(max, i);
        }
        System.out.println(max);
    }

}
