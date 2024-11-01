package eoj;

import java.util.*;
import java.io.*;

public class P_1004 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;

        for (int i = 1; i <= N; i++){
            if (i % 2 == 0){
                sum -= i * i;
            }else {
                sum += i * i;
            }
        }

        System.out.println(sum);
    }
}
