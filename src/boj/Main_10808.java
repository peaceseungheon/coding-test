package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_10808 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Map<Character, Integer> map = new HashMap<>();

        for(char i = 'a'; i <= 'z'; i++){
            map.put(i, 0);
        }

        for(char c: str.toCharArray()){
            Integer count = map.get(c);
            map.put(c, count+1);
        }

        StringBuilder sb = new StringBuilder();

        for (Integer c : map.values()) {
            sb.append(c).append(" ");
        }

        System.out.println(sb);
    }

}
