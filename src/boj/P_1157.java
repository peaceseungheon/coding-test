package boj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class P_1157 {

    public static void main(String[] args) {
        // 1. 문자열을 char 배열로 전환하고
        // Map에 각 문자의 횟수를 기록한다.

        // 2. 가장 횟수가 많은 알파벳을 찾는다.
        // 이 때 여러 개 존재하면 ?를 출력한다.

        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        S = S.toUpperCase();

        Map<Character, Integer> map = new HashMap<>();

        char[] chars = S.toCharArray();

        for(char c : chars){
            Integer count = map.get(c);
            if (count == null){
                map.put(c, 0);
            }else{
                map.put(c, ++count);
            }
        }

        int maxCount = Integer.MIN_VALUE;
        char result = '0';

        for (Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (maxCount < count){
                result = entry.getKey();
                maxCount = count;
            }
        }

        int count = 0;
        for (char c: map.keySet()){
            if (maxCount == map.get(c)){
                count++;
            }
        }

        if (count > 1){
            System.out.println("?");
        }else{
            System.out.println(result);
        }

    }

}
