package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_11047 {

    public static void main(String[] args) throws IOException {
        /*
        * 아이디어
        * 1. 동전의 가치 중 K보다 작은 것을 찾는다
        * 2. K / 동전가치만큼 동전개수를 더한다.
        * 3. K를 K % 동전가치 의 값으로 갱신한다.
        * 4. 1~3 과정을 반복하고 K가 0이 되면 중지한다.
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] values = new int[N];

        for(int i = 0; i < N; i++){
            values[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int temp = K;

        for(int i = N-1; i >= 0; i--){
            if (values[i] <= temp){
                count += temp / values[i];
                temp = temp % values[i];
            }
            if (temp == 0) break;
        }

        System.out.println(count);
    }

}
