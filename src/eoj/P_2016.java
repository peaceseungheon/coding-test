package eoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2016 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int temp = N;
        int sum = N;
        while (temp >= K){
            int a = temp / K;

            sum += a;

            int b = temp % K;
            temp = a + b;
        }
        System.out.println(sum);
    }

}
