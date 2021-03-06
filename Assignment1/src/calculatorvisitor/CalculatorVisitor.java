package calculatorvisitor;

import linkedstack.LinkedStack;
import token.Operand;
import token.Operation;
import token.Operator;
import token.Token;

public class CalculatorVisitor implements Calculator, Visitor{
    private LinkedStack<Token> tokenStack;

    public CalculatorVisitor() {
        tokenStack = new LinkedStack<>();
    }

    @Override
    public void visit(Operand operand) {
        tokenStack.push(operand);
    }

    @Override
    public void visit(Operator operator) {
        try {
            int rightOperand = 0;
            int leftOperand = 0;
            if (!tokenStack.isEmpty()) {
                rightOperand = ((Operand) tokenStack.pop()).getValue();
            }
            if (!tokenStack.isEmpty()) {
                leftOperand = ((Operand) tokenStack.pop()).getValue();
            }

            tokenStack.push(new Operand(performOperation(leftOperand, rightOperand, operator.getOperation())));
        }
        catch (Exception e) {
            System.out.println("Caught exception while visiting operator " + operator);
        }
    }

    @Override
    public int getResult() throws Exception {
        int result = 0;
        if (!tokenStack.isEmpty()) {
            result = ((Operand) tokenStack.pop()).getValue();
        }
        if(tokenStack.isEmpty())
            return result;

        throw new Exception("Stack not empty at the end?");
    }

    private int performOperation(int leftOperand, int rightOperand, Operation operation) throws Exception {
        switch (operation) {
            case ADD:
                return leftOperand + rightOperand;
            case SUBTRACT:
                return leftOperand - rightOperand;
            case MULTIPLY:
                return leftOperand * rightOperand;
            case DIVIDE:
                if(rightOperand == 0)
                    throw new Exception("Cannot divide by 0");
                return leftOperand / rightOperand;
            default:
                return 0;
        }
    }
}
