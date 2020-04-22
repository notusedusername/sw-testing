package pti.gyak;

public enum Operation {
    ADD("+"),
    SUBSTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    REMAINDER("%"),
    POWER("^"),
    SQRT("sqrt"),
    CLEAR("C");

    private String text;

    Operation(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
