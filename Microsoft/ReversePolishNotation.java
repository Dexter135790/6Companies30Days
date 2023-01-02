package Microsoft;

import java.util.Stack;


class Solution{

    public static boolean isOperator(String operator){
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    public static int operations(int leftOperand, int rightOperand, String operation){
        if(operation.equals("+")){
            return leftOperand+rightOperand;
        }else if(operation.equals("-")){
            return leftOperand-rightOperand;
        }else if(operation.equals("*")){
            return leftOperand*rightOperand;
        }else if(operation.equals("/")){
            return leftOperand/rightOperand;
        }else{
            throw new NumberFormatException();
        }
    }

    public static int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens){
            if(isOperator(s)){
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                int result = operations(leftOperand, rightOperand, s);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String[] tolens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tolens));
    }
}