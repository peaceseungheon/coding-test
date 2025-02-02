package programmers;
import java.util.*;
public class P_12946 {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(4);
    }

    static class Solution {

        static List<List<Integer>> list = new ArrayList<>();

        public int[][] solution(int n) {
            // (n, from, to)

            recur(n, 1, 3);
            int[][] ans = new int[list.size()][2];
            for(int i = 0; i < ans.length; i++){
                ans[i][0] = list.get(i).get(0);
                ans[i][1] = list.get(i).get(1);
            }
            return ans;
        }

        void recur(int n, int from, int to){
            System.out.printf("n: %d, from: %d, to: %d \n", n, from, to);
            if(n == 1){
                List<Integer> temp = new ArrayList<>();
                temp.add(from);
                temp.add(to);
                list.add(temp);
                return;
            }
            int empty = 6 - from - to;
            recur(n-1, from, empty);
            recur(1, from, to);
            recur(n-1, empty, to);
        }
    }
}
