package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P_1374 {

    public static void main(String[] args) throws IOException {
        // 입력: 첫째줄에 강의의 개수 N이 주어짐, 둘째줄부터 N개의 줄에 걸쳐 세 개의 정수(강의 번호, 시작시간, 종료시간)
        // 시간은 0 이상 10억 이하의 정수

        // 로직:
        // 한 강의실에서는 동시에 2개 이상의 강의 진행 불가. 한 강의의 종료시간과 다른 강의의 시작시간이 겹치는 것은 상관 X
        // 1. 종료 시간 순으로 오름차순 정렬
        // 2. 최소 종료 시간의 강의를 지정하고 반복문을 돌며
        // 2-1 i의 시작 시간이 최소 종료 시간보다 전이면 count ++
        // 2-2 i의 시작 시간이 최소 종료시간보다 같거타 크면 continue
        // 3. count 출력

        //출력: 필요한 최소 강의실 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String[] tokens = br.readLine().split(" ");
            lectures.add(new Lecture(Integer.parseInt(tokens[0]), Long.parseLong(tokens[1]), Long.parseLong(tokens[2])));
        }

        lectures.sort((o1, o2)-> {
            if(o1.startTime == o2.startTime){
                return Math.toIntExact(o1.endTime - o2.endTime);
            }
            return Math.toIntExact(o1.startTime - o2.startTime);
        });

        Queue<Lecture> queue = new PriorityQueue<>((o1, o2) -> Math.toIntExact(o1.endTime - o2.endTime));

        int count = 0;
        for(Lecture lecture: lectures){
            if(queue.isEmpty()){
                queue.add(lecture);
                count++;
                continue;
            }

            Lecture first = queue.peek();
            // 가장 일찍 끝나는 강의의 종료 시간이 현재 강의의 시작시간보다 크면 새로운 강의실 배정
            if(first.endTime > lecture.startTime){
                count++;
            }else{ // 아니면 기존 강의실로 배정
                queue.poll();
            }
            queue.add(lecture);
        }

        System.out.println(count);
    }

    static class Lecture {
        int no;
        long startTime;
        long endTime;

        Lecture(int no, long startTime, long endTime){
            this.no = no;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

}
