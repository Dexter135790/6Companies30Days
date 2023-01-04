package Microsoft;

import java.util.Stack;


class Solution{

    //cheking if the element is operator
    public static boolean isOperator(String operator){
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    //Performing the operations
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

    //Functions for evaluating RPN
    public static int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens){      //Iterating over each element of string
            if(isOperator(s)){
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();      //Getting the top two element to perform operations on
                int result = operations(leftOperand, rightOperand, s);  //Performing suitable operation
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(s));    //Putting the numeric value into stack by converting it to integer
            }
        }
        return stack.pop();     //Returning the result
    }
    public static void main(String[] args) {
        String[] tolens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tolens));
    }
}