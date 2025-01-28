package programmers;
import java.util.*;
public class P_60057 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aabbaacc"));
    }

    static class Solution {
        public int solution(String s) {

            int sLength = s.length();

            int window = 1;
            int min = Integer.MAX_VALUE;
            // aabbaccc
            while(window <= sLength){
                List<String> list = split(s, window);
                String result = makeString(list);
                min = Math.min(min, result.length());
                window++;
            }
            return min;
        }

        List<String> split(String source, int length){
            List<String> list = new ArrayList<>();
            int sLength = source.length();
            for(int i = 0; i <= sLength; i += length){
                int endIndex = i + length;
                if(endIndex > sLength){
                    endIndex = sLength;
                }
                String token = source.substring(i, endIndex);
                list.add(token);
            }
            return list;
        }

        String makeString(List<String> list){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int i = 1; i < list.size(); i++){
                String prev = list.get(i-1);
                String now = list.get(i);

                if(prev.equals(now)){
                    count++;
                }else{
                    if(count == 1) sb.append(prev);
                    else sb.append(count).append(prev);
                    count = 1;
                }
                if(i == list.size()-1){
                    if(count == 1) sb.append(now);
                    else sb.append(count).append(now);
                }
            }
            return sb.toString();
        }
    }

}
