package edu.hw3;

import java.util.ArrayList;
import java.util.Stack;
import org.jetbrains.annotations.NotNull;

public class Task2 {
    public String[] groupBrackets(char @NotNull [] str) {
        Stack<Character> stack = new Stack<>();
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (var bracket : str) {
            checkChar(bracket);
            toStack(bracket, stack);
            sb = getNewStringBuilder(bracket, sb, stack, arrayList);
        }
        checkStack(!stack.empty());
        return arrayList.toArray(new String[0]);
    }

    private static void toStack(char bracket, Stack<Character> stack) {
        if (bracket == '(') {
            stack.push(bracket);
        } else {
            checkStack(stack.empty());
            stack.pop();
        }
    }

    @NotNull private static StringBuilder getNewStringBuilder(
        char bracket,
        StringBuilder sb,
        Stack<Character> stack,
        ArrayList<String> arrayList
    ) {
        sb.append(bracket);
        if (stack.empty()) {
            arrayList.add(String.valueOf(sb));
            sb = new StringBuilder();
        }
        return sb;
    }

    private static void checkStack(boolean stack) {
        if (stack) {
            throw new IllegalArgumentException("Invalid bracket sequence");
        }
    }

    private static void checkChar(char bracket) {
        if (bracket !='(' && bracket !=')')
            throw new IllegalArgumentException("Invalid symbol");
    }
}
