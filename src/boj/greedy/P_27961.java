package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_27961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long now = 0;
        int count = 0;
        while (now != N){
            if(now == 0 || now == 1){
                now++;
                count++;
            }else{
                if(now * 2 > N){
                    now = now + (N - now);
                    count++;
                }else{
                    now = now * 2;
                    count++;
                }
            }

        }
        System.out.println(count);
    }
}

