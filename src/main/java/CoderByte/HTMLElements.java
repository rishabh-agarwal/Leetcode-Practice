package CoderByte;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class HTMLElements {

    public static void main(String[] args){
        System.out.println(validateDOMS("<div><b><p>hello world</p></b></div>"));
    }
    public static boolean validateDOMS(String s){
        Stack<String> validatorStack = new Stack();

        Map<String, String> lhs = new HashMap();
        lhs.put("div", "/div");
        lhs.put("b", "/b");
        lhs.put("p", "/p");

        Map<String, String> rhs = new HashMap();
        rhs.put("/div", "div");
        rhs.put("/b", "b");
        rhs.put("/p", "p");

        s = s.replaceAll("<",",");
        s = s.replaceAll(">",",");

        String[] splitDOMS = s.split(",");

        for(String i: splitDOMS){
            if(lhs.containsKey(i)) {
                validatorStack.push(i);
            }

            if(rhs.containsKey(i)) {
                if(validatorStack.peek().equalsIgnoreCase(rhs.get(i))){
                    validatorStack.pop();
                }
            }
        }

        if(validatorStack.isEmpty())
            return true;
        else
            return false;
    }
}
