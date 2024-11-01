package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1920 {

    static long[] arr;
    static long[] nums;

    public static void main(String[] args) throws IOException {
        /*
        * 아이디어
        * 1. N개의 정수 배열을 정렬한다.
        * 2. 이진탐색을 통해 숫자가 존재하는지 확인한다.
        * 3. 존재하면 1을 존재하지 않으면 0을 반환한다.
        *
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new long[M];

        for(int i = 0; i<M; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            boolean isExist = search(0, N - 1, nums[i]);
            if (isExist){
                sb.append("1").append("\n");
            }else{
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean search(int start, int end, long target){
        boolean isExist = false;
        while(start < end){
            int mid = (start + end) / 2;

            if (arr[mid] == target){
                isExist = true;
                break;
            }

            if(arr[mid] < target){
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }
        if(start == end){
            return arr[start] == target;
        }
        return isExist;
    }
}
