package programmers;
import java.util.*;
public class P_70129 {

    class Solution {
        public int[] solution(String s) {
            int[] ans = new int[2];
            int count = 1;
            while(true){
                // s의 모든 0을 제거한다.
                char[] chars = s.toCharArray();
                int zeroCount = 0;
                for(int i = 0; i < chars.length; i++){
                    if(chars[i] == '0'){
                        zeroCount++;
                    }
                }
                ans[1] += zeroCount;

                s = s.replace("0", "");
                // s를 s의 길이를 이진법으로 표현한 문자열로 바꾼다.
                int n = s.length();
                s = Integer.toString(n, 2);
                ans[0] = count++;
                if(s.equals("1")){
                    break;
                }
            }
            return ans;
        }
    }
}
