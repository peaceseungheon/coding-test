package boj;

import java.util.Scanner;

public class Main_2750 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++){
            int last = N - i - 1;
            int index = 0;
            while(index < last){
                int x = arr[index];
                int temp = arr[index+1];
                if(x > temp){
                    arr[index] = temp;
                    arr[index+1] = x;
                }
                index++;
            }
        }

        for(int i : arr){
            System.out.println(i);
        }
    }
}
