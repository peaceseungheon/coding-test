package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums =  br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int K = Integer.parseInt(nums[1]);

        int[] arr = new int[N];
        nums = br.readLine().split(" ");
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(nums[i]);
        }

        int sum = 0;
        for(int i = 0; i < K; i++){
            sum += arr[i];
        }

        int max = sum;

        int left = 1;
        int right = K;
        while (right < N){
            sum = sum - arr[left-1] + arr[right];
            max = Math.max(max, sum);
            left++;
            right++;
        }
        System.out.println(max);
    }

}
