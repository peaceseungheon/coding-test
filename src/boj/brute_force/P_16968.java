package boj.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_16968 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String type = br.readLine();
        // 출력: 가능한 차량 번호판의 개수
        // 로직: 1. 형식(dd, dc, cc, cd)에 따라 번호판의 개수를 구한다.
        // 2-1 : 나올 수 있는
        makeCarNumber(type.toCharArray(), 0, "");
        System.out.println(count);
    }

    static void makeCarNumber(char[] type, int typeIndex, String str){
        if(typeIndex == type.length){
            count++;
            return;
        }
        String last = null;
        if(!str.isEmpty()){
            last = str.substring(str.length()-1);
        }
        if(type[typeIndex] == 'c'){
            for(char c = 'a'; c <= 'z'; c++){
                if(String.valueOf(c).equals(last)) continue;
                makeCarNumber(type, typeIndex+1, str + c);
            }
        }else{
            for(int i = 0; i < 10; i++){
                if(String.valueOf(i).equals(last)) continue;
                makeCarNumber(type, typeIndex+1, str+i);
            }
        }
    }
}
