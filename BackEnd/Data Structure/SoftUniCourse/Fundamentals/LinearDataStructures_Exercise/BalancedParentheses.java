package implementations;

import interfaces.Deque;
import interfaces.Solvable;

import java.util.ArrayDeque;
import java.util.Stack;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        ArrayDeque<Character>stack = new ArrayDeque<>();
        for (int i = 0; i < parentheses.length(); i++) {
            if(parentheses.charAt(i) == '{' || parentheses.charAt(i) == '(' || parentheses.charAt(i) == '['){
                stack.push(parentheses.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                    char currentBracket = stack.pop();
                    switch (currentBracket){
                        case '{':
                            if(parentheses.charAt(i) != '}'){
                                return false;
                            }
                            break;
                        case '(':
                            if(parentheses.charAt(i) != ')'){
                                return false;
                            }
                            break;
                        case '[':
                            if(parentheses.charAt(i) != ']'){
                                return false;
                            }
                            break;
                    }
            }
        }
        return true;
    }
}
