package programmers.heap;

import java.util.*;

public class P_42626 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int res =s.solution(new int[]{0, 0, 1}, 0);
        System.out.println(res);
    }

    static class Solution {
        public int solution(int[] scoville, int K) {
            // 우선순위 큐에 스코빌지수가 낮은 순으로 넣는다.
            // 맨 처음 음식의 스코빌 지수가 k보다 크거나 같으면 종료
            // 아니면
            // 두개를 꺼낸다.
            // 두개의 스코빌 지수가 모두 0이고 k가 0이 아니면

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for(int s : scoville){
                queue.add(s);
            }

            int count = 0;

            while(queue.size() > 1){
                int first = queue.poll();
                int second = queue.poll();

                if(first >= K){
                    break;
                }

                int temp = first + second * 2;
                queue.add(temp);
                count++;
            }

            while (!queue.isEmpty()){
                int n = queue.poll();
                if(n < K){
                    count = -1;
                    break;
                }
            }
            return count;
        }
    }


}
