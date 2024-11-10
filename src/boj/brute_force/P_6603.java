package boj.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_6603 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            if(K == 0){
                break;
            }

            int[] S = new int[K];

            for(int i = 0; i < K; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(S);

            // 1 2 3 4 5 6 7
            for(int i = 0; i <= S.length - 6; i++){
                print(S, String.valueOf(S[i]), i, 1);
            }
            System.out.println();
        }
    }

    static void print(int[] arr, String str, int index, int len){
        if(len == 6){
            System.out.println(str);
            return;
        }
        for(int i = index+1; i < arr.length; i++){
            String temp = str + " " + arr[i];
            print(arr, temp, i, len+1);
        }
    }

}
