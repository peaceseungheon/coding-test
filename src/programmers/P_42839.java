package programmers;

import java.util.*;

public class P_42839 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("17"));
    }

    static class Solution {

        Set<Integer> numSet = new HashSet<>();
        static int size;
        static String[] nums;

        public int solution(String numbers) {
            // 1. 재귀를 통해 조합 가능한 모든 숫자를 배열에 담는다.
            // 2. 배열을 순회하며 소수인지 확인하고 소수이면 count를 증가시킨다.
            // 3. count를 반환한다.
            nums = numbers.split("");
            size = nums.length;

            for(int i = 0; i < size; i++){
                int[] visited = new int[size];
                visited[i] = 1;
                recursive(nums[i], visited, 0);
            }

            int count = 0;
            for (int n : numSet) {
                if (isSosu(n)) {
                    count++;
                }
            }
            return count;
        }

        void recursive(String num, int[] visited, int now) {
            if (now == size) {
                return;
            }

            int temp = Integer.parseInt(num);
            if (temp > 1) {
                numSet.add(temp);
            }

            for (int i = 0; i < nums.length; i++) {
                if(visited[i] == 1) continue;
                visited[i] = 1;
                recursive(num + nums[i], visited,now + 1);
                visited[i] = 0;
            }
        }

        boolean isSosu(int n) {
            boolean isSosu = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    isSosu = false;
                    break;
                }
            }
            return isSosu;
        }
    }
}
