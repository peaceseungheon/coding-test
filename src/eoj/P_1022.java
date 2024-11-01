package eoj;

import java.io.*;
import java.util.*;

public class P_1022 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st =  new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sortAsc(arr, 0, N - 1);
        printArray(arr);
        sortDesc(arr, 0, N-1);
        printArray(arr);
    }

    static void sortAsc(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int tempLeft = left;
        int tempRight = right;

        int pivotIndex = left;
        int pivot = arr[left];
        while(left < right){
            // pivot 오른쪽 값이 pivot보다 작은 값을 발견할 때까지 right ++
            while (arr[right] > pivot && left < right){
                right--;
            }

            // pivot의 왼쪽 값이 pivot보다 작거나 같다? left++
            while (arr[left] <= pivot && left < right){
                left++;
            }

            swap(arr, left, right);
        }
        swap(arr, pivotIndex, left);
        sortAsc(arr, tempLeft, left - 1);
        sortAsc(arr, left+1, tempRight);
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static void sortDesc(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int tempLeft = left;
        int tempRight = right;

        int pivotIndex = right;
        int pivot = arr[right];
        while(left < right){

            // pivot의 왼쪽 값이 pivot 크거나 같다? left++
            while (arr[left] > pivot && left < right){
                left++;
            }

            // pivot 오른쪽 값이 pivot보다 작다? right --
            while (arr[right] <= pivot && left < right){
                right--;
            }
            swap(arr, left, right);
        }
        swap(arr, pivotIndex, left);
        sortDesc(arr, tempLeft, left - 1);
        sortDesc(arr, left+1, tempRight);
    }

    static void printArray(int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int a : arr){
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}
