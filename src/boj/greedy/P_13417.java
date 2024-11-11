package boj.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class P_13417 {

    public static void main(String[] args) throws IOException {
        /**/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            String[] strs = br.readLine().split(" ");
            Deque<String> deque = new ArrayDeque<>();
            deque.add(strs[0]);
            pick(deque, strs);
            bw.write(print(deque) + "\n");
        }
        bw.flush();
    }

    static void pick(Deque<String> deque, String[] strs){
        for(int i = 1; i < strs.length; i++){
            String word = strs[i];
            String first = deque.peek();
            if(word.compareTo(first) > 0){
                deque.add(word);
            }else{
                deque.addFirst(word);
            }
        }
    }

    static String print(Deque<String> dq){
        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()){
            sb.append(dq.poll());
        }
        return sb.toString();
    }

}
