package programmers;

import java.util.*;

public class P_42746 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3, 30, 34, 5, 9}));
    }

    static class Solution {
        public String solution(int[] numbers) {
            List<String> nums = new ArrayList<>();

            for(int num : numbers){
                nums.add(String.valueOf(num));
            }

            nums.sort((s1, s2)-> {
                int x = Integer.parseInt(s1 + s2);
                int y = Integer.parseInt(s2 + s1);
                if(x < y){
                    return 1;
                }else if(x > y){
                    return -1;
                }else{
                    return 0;
                }
            });

            if(nums.get(0).equals("0")){
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            for(String n : nums){
                sb.append(n);
            }

            return sb.toString();
        }

    }

}
