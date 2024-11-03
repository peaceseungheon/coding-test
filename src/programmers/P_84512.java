package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_84512 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int index = solution.solution("AAAE");
        System.out.println(index);
    }

    static class Solution {

        static String[] arr = new String[]{"A", "E", "I", "O", "U"};

        public int solution(String word) {
            List<String> maps = new ArrayList<>();
            dfs(maps, "", 1);
            return maps.indexOf(word) + 1;

            /*
            * a aa aaa aaaa aaaaa
            * */
        }

        void dfs(List<String> maps, String str, int len){
            if(len > 5){
                return;
            }
            for (String s : arr) {
                String temp = str + s;
                maps.add(temp);
                dfs(maps, temp, len+1);
            }
        }
    }
}
