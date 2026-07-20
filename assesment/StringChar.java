package assesment;

import java.util.Scanner;
import java.util.Stack;

public class StringChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         String str = sc.nextLine();

        System.out.println(longestValidParenthesis(str));
    }

    public static int longestValidParenthesis(String str){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLen = 0;
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();

                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLen = Math.max(maxLen, i-stack.peek());
                }
            }
        }
        return maxLen;
    }
}
