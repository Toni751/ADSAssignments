package token;

import calculatorvisitor.CalculatorVisitor;

public class Operand extends Token {
    //I don't think the reference to the visitor is necessary
    private CalculatorVisitor visitor;
    private int value;

    public Operand(int value) {
        this.value = value;
    }

    @Override
    public void accept(CalculatorVisitor visitor) {
        visitor.visit(this);
    }

    public int getValue() {
        return value;
    }
}
