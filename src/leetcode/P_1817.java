package leetcode;

import java.util.*;

public class P_1817 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] logs = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        System.out.println(Arrays.toString(s.findingUsersActiveMinutes(logs, 5)));
    }

    static class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            // log[i][0] : 유저 ID, log[i][1] : 활동 시간대
            // for문을 돌며 유저의 활동 시간대를 기록, 다만 같은 시간대는 무시하므로 SET으로 처리
            // i: 1 ~ k까지 반복문을 돌며 set의 갯수가 i인 유저의 수를 ans[i] 에 할당

            Map<Integer, Set<Integer>> map = new HashMap<>();
            for(int i = 0; i < logs.length; i++){
                Set<Integer> times = map.get(logs[i][0]);
                if(times == null){
                    times = new HashSet<>();
                    times.add(logs[i][1]);
                    map.put(logs[i][0], times);
                }else{
                    times.add(logs[i][1]);
                }
            }
            Set<Integer> keys = map.keySet();

            int[] ans = new int[k];
            for(int key : keys){
                Set<Integer> times = map.get(key);
                ans[times.size()-1]++;
            }
            return ans;
        }
    }

}
