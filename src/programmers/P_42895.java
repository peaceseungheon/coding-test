package programmers;

import java.util.*;

public class P_42895 {
    // N으로 표현 (동적계획법)
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(5, 31168);
        System.out.println(result);
    }

    static class Solution {
        public int solution(int N, int number) {
            List<Set<Integer>> dp = new ArrayList<>();

            for(int i = 0; i <= 8; i++){
                dp.add(new HashSet<>());
            }

            int repeatedNumber = 0;

            for(int i = 1; i <= 8; i++){
                repeatedNumber = repeatedNumber * 10 + N;
                dp.get(i).add(repeatedNumber);
            }

            // DP로 N을 i번 사용해서 만들 수 있는 모든 수를 계산
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j < i; j++) {
                    for (int a : dp.get(j)) {
                        for (int b : dp.get(i - j)) {
                            dp.get(i).add(a + b); // 덧셈
                            dp.get(i).add(a - b); // 뺄셈
                            dp.get(i).add(a * b); // 곱셈
                            if (b != 0) {
                                dp.get(i).add(a / b); // 나눗셈 (0으로 나누는 경우 제외)
                            }
                        }
                    }
                }

                // 목표 숫자가 dp[i]에 있으면, i가 최소 사용 횟수
                if (dp.get(i).contains(number)) {
                    return i;
                }
            }

            // 8번까지 탐색했지만 찾지 못한 경우 -1 반환
            return -1;
        }

    }
}
