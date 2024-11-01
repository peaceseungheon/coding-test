package boj;

import java.util.Scanner;

public class Main_1377 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        boolean change;
        for(int i = 0; i < N; i++){
            change = false;
            for(int j = 0; j < N - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    change = true;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if(!change){
                System.out.println(i + 1);
                break;
            }
        }
    }
}
