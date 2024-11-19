package programmers;

import java.util.*;

public class P_87946 {

    public static void main(String[] args) {
        int[][] dungeons = new int[][]{{78, 18}, {70, 11}, {67, 9}, {60, 8}, {59, 2}, {57, 54}};

        Solution s = new Solution();
        int res = s.solution(78, dungeons);
        System.out.println(res);
    }

    static class Solution {

        static int maxCount = 0;

        public int solution(int k, int[][] dungeons) {

            int[] visited = new int[dungeons.length];
            backTracking(k, dungeons, visited,  0, 0);

            return maxCount;
        }

        void backTracking(int nowK, int[][] dungeons, int[] visited, int index, int count){
            if(index == dungeons.length){
                maxCount = Math.max(maxCount, count);
                return;
            }
            for(int i = 0; i < dungeons.length; i++){
                if(visited[i] == 1) continue;

                int tempK = nowK;
                int tempCount = count;
                if(nowK >= dungeons[i][0]){
                    tempK -= dungeons[i][1];
                    tempCount++;
                }
                visited[i] = 1;
                backTracking(tempK, dungeons, visited, index+1, tempCount);
                visited[i] = 0;
            }

        }
    }
}
