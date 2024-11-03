package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1072 {

    public static void main(String[] args) throws IOException {
        /*아이디어
         * 1. 현재 승률을 구한다.
         * 2. 현재 승률 + 1이 되는 판 수를 구한다.
         * 3. 승률은 Y / X * 100
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        int X = Integer.parseInt(nums[0]);
        int Y = Integer.parseInt(nums[1]);
        int Z = getZ(X, Y);

        int start = 0;
        int end = 1000000000;

        int ans = -1;
        while (start <= end){
            int mid = (start + end) / 2;
            int tempZ = getZ(X + mid, Y + mid);

            if(tempZ != Z){
                ans = mid;
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static int getZ(int X, int Y){
        long temp = (long) Y * 100 / X;
        return (int) temp;
    }
}
