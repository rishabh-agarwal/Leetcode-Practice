package validParentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        if (s.isEmpty())
            return true;

        //String should contain no alphabet and no number
        if (s.contains("[a-zA-Z]+") || s.matches("[0-9]+"))
            return false;

        char[] arr = s.toCharArray();

        Stack<Character> validatorStack = new Stack<Character>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') //push operation
            {
                validatorStack.push(arr[i]);
            } else { //pop operation
                if (validatorStack.empty()) {
                    return false;
                } else if (arr[i] == ')' && validatorStack.peek().equals('(') ||
                        arr[i] == '}' && validatorStack.peek().equals('{') ||
                        arr[i] == ']' && validatorStack.peek().equals('['))
                    validatorStack.pop();
                else
                    return false;
            }
        }

        if (!validatorStack.empty())
            return false;

        return true;
    }
}