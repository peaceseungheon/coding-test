package softeer;
import java.io.*;
import java.util.*;

public class P_CPTI {

    public static void main(String[] args) throws IOException {
        // 로직: 2중 반복문을 수행하며 두 사람을 비교한다.
        // 비교는 두 사람의 CPTI를 and 연산 했을 때 0이 2개보다 많으면 성격이 다른 유형이 2개보다 많다는 의미이다.

        // 첫째줄 사람수: N, CPIT의 길이: M
        // N개의 줄에 대해 CPTI가 주어진다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine(), 2);
        }

        int count = 0;
        for(int j = 0; j < N; j++){
            int a = arr[j];
            for(int i = j+1; i < N; i++){
                int b = arr[i];
                int diff = Integer.bitCount(a ^ b);
                if(diff <= 2){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static boolean isFriendly(int a, int b){
        String temp = Integer.toBinaryString(a ^ b);
        char[] chars = temp.toCharArray();
        int oneCount = 0;
        boolean res = true;
        for(int i = 0; i < chars.length; i++){
            if(oneCount > 2){
                res = false;
                break;
            }
            if(chars[i] == '1'){
                oneCount++;
            }
        }
        return res;
    }

}
