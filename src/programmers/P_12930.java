package programmers;

public class P_12930 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("try hello world"));
    }

    static class Solution {

        final int length = 'a'- 'A';

        public String solution(String s) {
            char[] chars = s.toCharArray();

            int index = 0;
            for(int i = 0; i < chars.length; i++){
                if(chars[i] == ' '){
                    index = 0;
                    continue;
                }
                if(index % 2 == 0){
                    if(Character.isLowerCase(chars[i])){
                        chars[i] = (char) (chars[i] - length);
                    }
                }else{
                    if(Character.isUpperCase(chars[i])){
                        chars[i] = (char) (chars[i] + length);
                    }
                }
                index++;
            }
            return new String(chars);
        }
    }

}
