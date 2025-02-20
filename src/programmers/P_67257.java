package programmers;
import java.util.*;
public class P_67257 {



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("100-200*300-500+20"));
    }

    static class Solution {

        private static String[][] precedences = new String[][]{
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*+-".split(""),
            "*-+".split("")
        };

        public long solution(String expression) {
        /*
        1. 숫자와 연산자를 리스트에 담고 연산자를 또 하나의 리스트에 담는다.
        2. 연산자의 조합을 구한다.
        3. 해당 조합대로 연산을 수행하여 절대 값의 최대를 구한다.
        */
            StringTokenizer st = new StringTokenizer(expression, "+-*", true);
            List<String> list = new LinkedList<>();
            while (st.hasMoreTokens()){
                list.add(st.nextToken());
            }
            int ans = 0;
            for(String[] operators : precedences){
                LinkedList<String> temp = new LinkedList<>(list);
                for(String op : operators){
                    calculate(temp, op);
                }
                ans = Math.max(ans, Math.abs(Integer.parseInt(temp.get(0))));
            }

            return ans;
        }

        void calculate(List<String> tokens, String op){
            for(int i = 0; i < tokens.size(); i++){
                String s = tokens.get(i);
                if(op.equals(s)){
                    int left = Integer.parseInt(tokens.get(i-1));
                    int right = Integer.parseInt(tokens.get(i+1));
                    int res = calculate(left, right, s);
                    this.pull(tokens, i-1);
                    tokens.add(i-1, String.valueOf(res));
                    i-=2;
                }
            }
        }

        int calculate(int left, int right, String operator){
            switch (operator){
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                default:
                    return 0;
            }
        }

        void pull(List<String> tokens, int index){
            tokens.remove(index);
            tokens.remove(index);
            tokens.remove(index);
        }

    }

}
