package toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NiceNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Map<String, Integer> map = new HashMap<>();
        int size = 3;
        int sLength = S.length();
        int max = Integer.MIN_VALUE;
        String ans = "";
        for (int i = 3; i < sLength; i++){
            String substring = S.substring(i - size, i);
            int sum = 0;
            for(String token : substring.split("")){
                sum += Integer.parseInt(token);
            }
            if(max < sum){
                max = sum;
                ans = substring;
            }
        }
        System.out.println(ans);
    }

}
