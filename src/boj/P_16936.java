package boj;

import java.io.*;
import java.util.*;

public class P_16936 {

    /*
    입력:
    첫째줄 N: 수열의 크기 (2 <= N <= 10)
    둘쨰줄 B: 수열

    * 문제 풀이
    * 1. 수열 중 하나를 시작 숫자로 정한다.
    * 2. 연산 결과와 일치하는 숫자가 있으면 배열에 추가한다.
    * 3. 연산 결과와 일치하는 숫자가 있으면 중단하고 다음 수열의 숫자를 탐색한다
    *
    * */

    static long[] arr;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        long[] ans = null;
        for (int i = 0; i < arr.length; i++) {
            long[] answer = new long[N];
            answer[0] = arr[i];
            find(arr[i], 1, answer);
            boolean isMatch = true;
            StringBuilder sb = new StringBuilder();
            for (long n : answer) {
                if (n == 0){
                    isMatch = false;
                    break;
                }else{
                    sb.append(n).append(" ");
                }
            }
            if(isMatch){
                System.out.println(sb);
                break;
            }
        }


    }

    static void find(long start, int index, long[] answer){
        if(index == N) {
            return;
        }
        long res = cal1(start);
        if(res != -1){
            boolean isFind = search(res);
            if(isFind) {
                answer[index] = res;
                find(res, index+1, answer);
            }
        }
        res = cal2(start);
        boolean isFind = search(res);
        if(isFind){
            answer[index] = res;
            find(res, index+1, answer);
        }
    }

    static boolean search(long num){
        boolean isFind = false;
        for (long a : arr) {
            if(a == num){
                isFind = true;
                break;
            }
        }
        return isFind;
    }

    static long cal1(long num){
        if(num % 3 != 0){
            return -1;
        }
        return num / 3;
    }

    static long cal2(long num){
        return num * 2;
    }

}
