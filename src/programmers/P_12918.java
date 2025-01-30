package programmers;

public class P_12918 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("1234a"));
    }

    static class Solution {
        public boolean solution(String s) {
            return validateLength(s) && isLowercase(s);
        }

        boolean validateLength(String s){
            int length = s.length();
            if(length == 4 || length == 6){
                return true;
            }
            return false;
        }

        boolean isLowercase(String s){
            return s.matches("[0-9]*");
        }
    }
}
