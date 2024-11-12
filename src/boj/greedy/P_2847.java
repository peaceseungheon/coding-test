package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2847 {

    public static void main(String[] args) throws IOException {
        /*
        * 아이디어
        * 1. 배열의 마지막부터 두번째까지 순회한다.
        * 2. n번째 요소에 대해 n-1번째 요소 값이 크거나 같으면 arr[n - 1] - arr[n] - 1 만큼 count를 증가시키고 arr[n-1]을 해당 값을 뺀 값으로 갱신한다.
        * 3. 순회가 끝나면 count를 반환한다.
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;

        for(int i = arr.length - 1; i > 0; i--){
            if(arr[i-1] >= arr[i]){
                int count = arr[i-1] - arr[i] + 1;
                answer += count;
                arr[i-1] -= count;
            }
        }

        System.out.println(answer);
    }

}
