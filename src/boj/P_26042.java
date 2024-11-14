package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P_26042 {

    public static void main(String[] args) throws IOException {
        /*
        * 입력: 첫줄에 n이 주어짐, n개의 줄에 걸쳐 하나의 정보가 주어짐
        * 정보는 1이면 대기열에 a를 추가, 2이면 대기열 앞 줄에 있는 학생이 식사
        *
        * 출력: 대기하는 학생 수가 최대인 경우와 맨 뒤에 대기 중인 학생의 번호
        * 단, 최대인 경우가 여러 번이면 맨 뒤 학생의 번호가 가장 작은 경우 출력      *
        *
        * 변수:
        * 1. 대기열 Queue
        * 2. 최대 학생 수 int
        * 3. 최소 학생 번호 int
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        int maxCount = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++){
            String[] tokens = br.readLine().split(" ");

            if(tokens[0].equals("1")){
                int studentNo = Integer.parseInt(tokens[1]);
                deque.add(studentNo);

                if(maxCount <= deque.size()){
                    maxCount = deque.size();
                    if(map.get(maxCount)==null){
                        List<Integer> list = new ArrayList<>();
                        list.add(deque.getLast());
                        map.put(maxCount, list);
                    }else{
                        map.get(maxCount).add(deque.getLast());
                    }
                }
            }else{
                deque.poll();
            }
        }


        List<Integer> studentNos = map.get(maxCount);
        Collections.sort(studentNos);

        System.out.printf("%d %d", maxCount, studentNos.get(0));
    }

}
