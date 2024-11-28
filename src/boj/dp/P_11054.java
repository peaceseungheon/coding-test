package boj.dp;

import java.io.*;
import java.util.*;

public class P_11054 {

    public static void main(String[] args) throws IOException {
        // 출력: 부분수열 중 바이토닉 수열이면서 가장 긴 수열의 길이

        // 로직:
        // 1. 증가하는 가장 긴 수열과 감소하는 가장 긴 수열의 길이를 구한다.
        // 2. 두 수열을 더하고 1을 빼준다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] tokens = br.readLine().split(" ");
        int[] nums = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(tokens[i]);
        }

        int[] lis = new int[N];
        int[] lds = new int[N];

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++){
                // lis 구하기
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            int[] copyNums = Arrays.copyOfRange(nums, i, N);
            reverse(copyNums);
            int temp = lds(copyNums);
            lds[i] = temp;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, lis[i] + lds[i] - 1);
        }

        System.out.println(max);
    }

    static int lds(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }

    static void reverse(int[] nums){
        int mid = nums.length / 2;
        for(int i = 0; i < mid; i++){
            int temp = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = nums[i];
            nums[i] = temp;
        }
    }

}
