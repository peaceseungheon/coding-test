package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int maxFiveCount = N / 5;

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= maxFiveCount; i++){
            int res = calc(i, N);
            if(res != -1){
                ans = Math.min(ans, res);
            }
        }
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }

    static int calc(int i, int N){
        int ans = i;
        N -= 5 * i;

        ans += N / 3;
        N = N % 3;

        if(N == 0){
            return ans;
        }
        return -1;
    }

}
