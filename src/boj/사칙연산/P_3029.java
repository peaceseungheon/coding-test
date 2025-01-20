package boj.사칙연산;

import java.io.*;
import java.util.*;

public class P_3029 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        if(A.equals(B)){
            System.out.println("24:00:00");
            return;
        }

        String[] now = A.split(":");
        String[] throwTime = B.split(":");

        int temp = 0;

        List<String> list = new ArrayList<>();

        for(int i = 2; i > -1; i--){
            int x = Integer.parseInt(now[i]);
            int y = Integer.parseInt(throwTime[i]);

            y -= temp;

            int result = calc(x, y, i);

            if(y - x < 0){
                temp = 1;
            }else{
                temp = 0;
            }

            list.add(format(result, i));
        }
        Collections.reverse(list);
        System.out.println(String.join(":", list));
    }

    static int calc(int x, int y, int index){
        int entire;

        if(index == 0){
            entire = 24;
        }else{
            entire = 60;
        }

        if(y >= x){
            return y - x;
        }else{
            int temp = entire - x;
            return y + temp;
        }
    }

    static String format(int time, int index){
        String s;
        if(time < 0){
            if(index == 0){
                s = String.valueOf(24 + time);
            }else{
                s = String.valueOf(60 + time);
            }
        }else{
            s = String.valueOf(time);
        }

        if(s.length() == 1){
            return "0" + s;
        }
        return s;
    }
}
