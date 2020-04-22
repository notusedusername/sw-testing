package pti.gyak;

import java.util.Collections;
import java.util.List;

public class Calculator {
    private static String separator = " ";

    private Number result = 0;
    private String expression = "";
    private List<String> history = Collections.emptyList();

    private Operation lastOperation;

    public Calculator enter(Operation operation) {
        if (operation != null) {
            if (operation == Operation.ADD || operation == Operation.SUBSTRACT || operation == Operation.MULTIPLY
                    || operation == Operation.DIVIDE || operation == Operation.REMAINDER || operation == Operation.POWER) {
                lastOperation = operation;
            } else if (operation == Operation.SQRT) {
                result = Math.sqrt(result.doubleValue());
                expression = operation + "(" + expression + ")";
                lastOperation = null;
            } else if (operation == Operation.CLEAR) {
                result = 0;
                expression = "";
                lastOperation = null;
            }
            return this;
        }
        return this;
    }

    public Calculator enter(Number number) {
        if (number != null) {
            processEnter(number);
        }
        return this;
    }

    private void processEnter(Number number) {
        if (lastOperation != null) {
            processOperation(number);
        } else {
            addExpressionToHistory(number);
        }
    }

    private void processOperation(Number number) {
        if (lastOperation.equals(Operation.ADD)) {
            result = result.doubleValue() + number.doubleValue();
        } else if (lastOperation.equals(Operation.SUBSTRACT)) {
            result = result.doubleValue() - number.doubleValue();
        } else if (lastOperation.equals(Operation.MULTIPLY)) {
            result = result.doubleValue() * number.doubleValue();
        } else if (lastOperation.equals(Operation.DIVIDE)) {
            if (number.doubleValue() != 0) {
                result = result.doubleValue() / number.doubleValue();
            } else {
                if (result.doubleValue() > 0) {
                    result = Double.POSITIVE_INFINITY;
                } else {
                    result = Double.NEGATIVE_INFINITY;
                }
            }
        } else if (lastOperation.equals(Operation.REMAINDER)) {
            result = result.doubleValue() % number.doubleValue();
        } else if (lastOperation.equals(Operation.POWER)) {
            result = Math.pow(result.doubleValue(), number.doubleValue());
        }
        expression = expression + separator + lastOperation + separator + number;
        lastOperation = null;
    }

    private void addExpressionToHistory(Number number) {
        if (!this.expression.isEmpty()) {
            history.add(this.expression + " = " + resultString());
        }
        result = number;
        this.expression = "" + number;
    }

    public Number getResult() {
        return result;
    }

    public String getExpression() {
        return expression;
    }

    public String getHistory() {
        StringBuilder historyAsString = new StringBuilder();
        for (String h: history) {
            historyAsString.append(h)
                    .append("\n");
        }
        historyAsString.append(expression)
                .append(" = ")
                .append(resultString());
        return historyAsString.toString();
    }

    private String resultString() {
        return result.doubleValue() % 1 == 0 ? "" + result.intValue() : result.toString();
    }
}