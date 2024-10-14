package eoj;

import java.io.*;
import java.util.*;

public class P_3016 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        while(true){
            String[] tokens = br.readLine().split(" ");
            String order = tokens[0];

            if(order.equals("0")){
                break;
            }else if(order.equals("2")){
                if (!stack.isEmpty()) stack.pop();
            }else{
                if (stack.size() < N){
                    int donut = Integer.parseInt(tokens[1]);
                    stack.add(donut);
                }
            }
        }

        System.out.println(stack.size());

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

}
