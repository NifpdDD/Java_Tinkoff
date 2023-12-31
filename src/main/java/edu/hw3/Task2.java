package edu.hw3;

import java.util.ArrayList;
import java.util.Stack;

public class Task2 {
    private static void checkStack(boolean stack) {
        if (stack) {
            throw new IllegalArgumentException("Invalid bracket sequence");
        }
    }

    private static void checkChar(char bracket) {
        if (bracket != '(' && bracket != ')') {
            throw new IllegalArgumentException("Invalid symbol");
        }
    }

    public String[] groupBrackets(char[] str) {
        Stack<Character> stack = new Stack<>();
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (var bracket : str) {
            checkChar(bracket);
            if (bracket == '(') {
                stack.push(bracket);
            } else {
                checkStack(stack.empty());
                stack.pop();
            }
            sb.append(bracket);
            if (stack.empty()) {
                arrayList.add(String.valueOf(sb));
                sb = new StringBuilder();
            }
        }
        checkStack(!stack.empty());
        return arrayList.toArray(new String[0]);
    }
}
