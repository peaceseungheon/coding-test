package boj;

import java.util.Scanner;

public class Main_1427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.next().split("");

        int[] arr = new int[tokens.length];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(tokens[i]);
        }

        System.out.println(solution(arr));
    }

    private static String solution(int[] arr) {
        int cnt = 0;
        while (cnt < arr.length) {
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int i = cnt; i < arr.length; i++) {
                if(max < arr[i]){
                    max = arr[i];
                    maxIndex = i;
                }
            }
            int temp = arr[cnt];
            arr[cnt] = max;
            arr[maxIndex] = temp;
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }
}
