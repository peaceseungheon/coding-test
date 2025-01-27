package programmers;

public class P_12926 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String res = s.solution("F", 25);
        System.out.println(res);
    }

    static class Solution {

        public String solution(String str, int n) {
            // 문자열을 char로 변환한다.
            // n만큰 더한다.
            // z-a + 1 만큼 나머지 연산을 하여 char로 변환한다.
            // 변환한 값을 반환한다.

            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            for(char c : chars){
                int offset = Character.isLowerCase(c) ? 'a' : 'A';
                int position = c - offset;
                position = (position + n) % ('z' - 'a' + 1);
                sb.append((char) (position + offset));
            }
            return sb.toString();
        }
    }

}
