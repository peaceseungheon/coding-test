package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        long M = Long.parseLong(nums[1]);

        String[] sTrees = br.readLine().split(" ");

        long[] trees = new long[N];

        long end = Long.MIN_VALUE;

        for(int i = 0; i < sTrees.length; i++){
            long h = Long.parseLong(sTrees[i]);
            end = Math.max(end, h);
            trees[i] = h;
        }

        long start = 0;
        long answer = 0;

        while(start <= end){
            long mid = (start + end) / 2;
            long sum = calc(trees, mid);

            if(sum >= M){
                answer = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(answer);
    }

    static long calc(long[] trees, long mid){
        long sum = 0;
        for(long h : trees){
            long m = h - mid;
            if(m > 0) sum += m;
        }
        return sum;
    }

}
