package programmers;

public class P_72410 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ans = solution.solution(".....a....");
        System.out.println(ans);
    }

    static class Solution {
        public String solution(String new_id) {
            ValidateService utils = new ValidateService(new_id);
            utils.toLowerCase()
                .remove()
                .removeEndPointDuplicate()
                .removeEndPoint()
                .addA()
                .validateLength()
                .removeEndPoint()
                .makeMinimum();

            return utils.value;
        }

        class ValidateService {
            String value;

            ValidateService(String str){
                this.value = str;
            }

            ValidateService toLowerCase(){
                value = value.toLowerCase();
                return this;
            }

            ValidateService remove(){
                this.value = value.replaceAll("[^a-z0-9.\\-_]+", "");
                return this;
            }

            ValidateService removeEndPointDuplicate(){
                String temp = value;
                while (temp.contains("..")){
                    temp = temp.replace("..", ".");
                }
                this.value = temp;
                return this;
            }

            ValidateService removeEndPoint(){
                String temp = value;
                if(value.startsWith(".")){
                    temp = value.substring(1);
                }
                if(value.endsWith(".")){
                    temp = temp.substring(0, value.length()-1);
                }
                this.value = temp;
                return this;
            }

            ValidateService addA(){
                if(value.isEmpty()){
                    this.value =  "a";
                }
                return this;
            }

            ValidateService validateLength(){
                if(value.length() < 16){
                    return this;
                }
                value = value.substring(0, 15);
                return this;
            }

            ValidateService makeMinimum(){
                if(value.length() > 2){
                    return this;
                }

                StringBuilder sb = new StringBuilder(value);
                char c = value.charAt(value.length()-1);
                int len = value.length();
                while (len < 3){
                    sb.append(c);
                    len++;
                }
                this.value = sb.toString();
                return this;
            }
        }


    }
}
