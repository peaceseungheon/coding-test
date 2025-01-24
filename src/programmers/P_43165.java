package programmers;

public class P_43165 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(ans);
    }

    static class Solution {

        static int count = 0;
        static int targetNum;
        public int solution(int[] numbers, int target) {

            targetNum = target;

            dfs(numbers, 0, 0);

            return count;
        }

        void dfs(int[] numbers, int result, int current){
            if(current == numbers.length){
                if(result == targetNum) count++;
                return;
            }

            dfs(numbers, result+numbers[current], current+1);
            dfs(numbers, result-numbers[current], current+1);
        }
    }


}
