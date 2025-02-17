package boj.dp;

import java.util.*;
import java.io.*;

public class P_9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
    }

    static int dp(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        return dp(n-1) + dp(n-2) + dp(n-3);
    }
}
