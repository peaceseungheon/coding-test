package barkingdog.ch_0x03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {

    public static void main(String[] args) {
        int[] arr = new int[]{10,20,30,40,50,60};
        arr = insert(3, 45, arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] insert(int idx, int num, int[] arr, int len){
        if(idx > len){
            throw new ArrayIndexOutOfBoundsException();
        }

        int[] temp = new int[len+1];

        System.arraycopy(arr, 0, temp, 0, idx);
        temp[idx] = num;
        System.arraycopy(arr, idx, temp, idx+1, len - idx);
        return temp;
    }

}
