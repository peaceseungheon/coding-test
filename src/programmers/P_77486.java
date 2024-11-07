package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_77486 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] enroll = new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = new String[]{"young", "john", "tod", "emily", "mary"};
        int[] amount = new int[]{12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(s.solution(enroll, referral, seller, amount)));
    }

    static class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            Tree tree = new Tree();

            Map<String, Person> persons = new HashMap<>();

            for(String name : enroll){
                persons.put(name, new Person(name));
            }

            for (int i = 0; i < enroll.length; i++) {
                if(referral[i].equals("-")){
                    Person person = persons.get(enroll[i]);
                    person.setRecommender(tree.root);
                    tree.root.children.add(person);
                }else{
                    Person recommender = persons.get(referral[i]);
                    Person person = persons.get(enroll[i]);
                    person.setRecommender(recommender);
                    recommender.children.add(person);
                }
            }

            /*
            * 1. seller를 순회한다.
            * 2. seller의 추천인을 찾아서 수익의 10%를 준다.
            * 2-1 만약 수익의 10%가 1원 미만이면 seller가 가진다.
            * 3. 추천인이 null일 때까지 위 계산을 반복
            *
            * */
            for(int s = 0; s < seller.length; s++){
                Person sell = persons.get(seller[s]);
                int money = amount[s] * 100;
                sell.earn(money);
            }

            int[] answers = new int[enroll.length];

            for(int i = 0; i < answers.length; i++){
                answers[i] = persons.get(enroll[i]).income;
            }
            return answers;
        }
    }

    static class Tree {
        Person root;

        Tree(){
            this.root = new Person("center");
        }
    }

    static class Person {
        String name;
        int income;
        Person recommender;

        List<Person> children;

        Person(String name){
            this.name = name;
            this.income = 0;
            children = new ArrayList<>();
            recommender = null;
        }

        public void setRecommender(Person recommender) {
            this.recommender = recommender;
        }

        void earn(int income){
            if(income * 10 < 100){
                this.income += income;
            }else{
                if(recommender == null){
                    return;
                }
                int temp = income * 10 / 100;
                int myMoney = income - temp;
                this.income += myMoney;
                recommender.earn(temp);
            }
        }
    }

}
