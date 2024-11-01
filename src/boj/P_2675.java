package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2675 {

    public static void main(String[] args) throws IOException {

        // 1.테스트 케이스 숫자 N을 받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 2. 반복 횟수와 문자열을 분리한다.
        for (int i = 0; i < T; i++) {
            String[] tokens = br.readLine().split(" ");
            int N = Integer.parseInt(tokens[0]);
            String S = tokens[1];

            char[] arr = S.toCharArray();

            StringBuilder sb = new StringBuilder();

            for (char c : arr) {
                for (int j = 0; j < N; j++) {
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
    }

}
