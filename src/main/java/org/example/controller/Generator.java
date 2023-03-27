package org.example.controller;

import org.example.model.Digit;
import org.example.model.Node;
import org.example.model.Operator;

public class Generator {

    public Node generate(String mathExpression) {
        if (mathExpression.startsWith("[")) {
            int nextSeparatorIndex = findNextSeparatorIndex(mathExpression.substring(3, mathExpression.length()-1)) + 3;
            return new Operator(mathExpression.substring(1, 2),
                    generate(mathExpression.substring(3, nextSeparatorIndex)),
                    generate(mathExpression.substring(nextSeparatorIndex + 1, mathExpression.length()-1)));
        }
        return new Digit(mathExpression);
    }

    private int findNextSeparatorIndex(String substring) {
        int symmetricHooksIndicator = 0;
        for (int i=0; i < substring.length(); i++) {
            if (substring.charAt(i) == '[') symmetricHooksIndicator++;
            if (substring.charAt(i) == ']') symmetricHooksIndicator--;
            if (substring.charAt(i) == ',' && symmetricHooksIndicator == 0) return i;
        }
        return 0;
    }
}
