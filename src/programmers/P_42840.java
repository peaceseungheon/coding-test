package programmers;
import java.util.*;

public class P_42840 {

    public static void main(String[] args) {

    }

    class Solution {
        public int[] solution(int[] answers) {
            // 1번 수포자: 12345 12345 -> i % 5로 인덱스 반복
            // 2번      : 21232425 21232425 ... i % 8로 인덱스 반복
            // 3번      : 3311224455 3311 ... i % 10로 인덱스 반복

            // 입력: 1번부터 마지막 문제까지의 정답 배열

            // 로직: 1. answers를 반복분을 돌며 i에 대해 수포자들의 찍는 배열을 조회하여 비교
            //      2. map으로 관리되는 수포자로 맞힌 문제를 카운트, 최대 정답 수를 갱신
            //      3. 최대 정답 수에 해당하는 수포자들을 배열에 담은 후 오름차순 정렬


            // 출력: 가장 많은 문제를 맞힌 사람, 사암이 여럿인 경우 오름차순
            int[] first = new int[]{1,2,3,4,5};
            int[] sec = new int[]{2,1,2,3,2,4,2,5};
            int[] third = new int[]{3,3,1,1,2,2,4,4,5,5};

            Map<Integer, Integer> map = new HashMap<>();
            map.put(1, 0);
            map.put(2, 0);
            map.put(3, 0);

            int maxCount = Integer.MIN_VALUE;

            for(int i = 0; i < answers.length; i++){
                if(first[i % 5] == answers[i]){
                    int temp = map.get(1);
                    temp++;
                    map.put(1, temp);
                    maxCount = Math.max(maxCount, temp);
                }
                if(sec[i % 8] == answers[i]){
                    int temp = map.get(2);
                    temp++;
                    map.put(2, temp);
                    maxCount = Math.max(maxCount, temp);
                }
                if(sec[i % 10] == answers[i]){
                    int temp = map.get(3);
                    temp++;
                    map.put(3, temp);
                    maxCount = Math.max(maxCount, temp);
                }
            }

            List<Integer> result = new ArrayList<>();
            for(int key : map.keySet()){
                int count = map.get(key);
                if(count == maxCount){
                    result.add(key);
                }
            }
            if(result.size() > 1){
                Collections.sort(result);
            }

            int[] answer = new int[result.size()];

            for(int i = 0; i < answer.length; i++){
                answer[i] = result.get(i);
            }
            return answer;
        }

    }

}
