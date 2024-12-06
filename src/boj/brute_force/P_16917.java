package boj.brute_force;

import java.io.*;
import java.util.*;

public class P_16917 {

    static int A;
    static int B;
    static int C;
    static int X;
    static int Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] token = br.readLine().split(" ");

        A = Integer.parseInt(token[0]);
        B = Integer.parseInt(token[1]);
        C = Integer.parseInt(token[2]);

        X = Integer.parseInt(token[3]);
        Y = Integer.parseInt(token[4]);

        int ans = Math.min(oneByOne(), firstHalf());
        ans = Math.min(ans, onlyHalf());

        System.out.println(ans);
    }

    static int oneByOne(){
        int tempX = X * A;
        int tempY = Y * B;
        return tempX + tempY;
    }

    static int firstHalf(){
        if(X > Y){
            int temp = C * (2 * Y);
            int tempX = A * (X - Y);
            return temp + tempX;
        }else{
            int temp = C * (2 * X);
            int tempY = B * (Y - X);
            return temp + tempY;
        }
    }

    static int onlyHalf(){
        if (X > Y){
            return C * (2 * X);
        }else{
            return C * (2 * Y);
        }
    }


}
