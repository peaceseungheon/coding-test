package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_14916 {

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int maxFive = N / 5;
        int ans = Integer.MAX_VALUE;

        while(maxFive >= 0){
            int result = calc(N, maxFive);
            if(result != -1){
                ans = Math.min(ans, result);
            }
            maxFive--;
        }

        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }

    static int calc(int money, int fCount){
        money = money - 5 * fCount;

        int tCount = money / 2;
        money = money % 2;

        if(money == 0){
            return fCount + tCount;
        }else{
            return -1;
        }
    }

}
