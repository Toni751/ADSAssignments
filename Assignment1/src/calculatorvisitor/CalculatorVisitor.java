package calculatorvisitor;

import customexceptions.EmptyStackException;
import customexceptions.MalformedExpressionException;
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
        pushOperand(operand);
    }

    @Override
    public void visit(Operator operator) {
        try {
            performOperation(operator);
        }
        catch (Exception e) {
            System.out.println("Caught exception while visiting operator " + operator);
        }
    }

    @Override
    public int getResult() throws MalformedExpressionException {
        int result;
        try{
            result = ((Operand) tokenStack.pop()).getValue();
        }
        catch (Exception e) {
            throw new MalformedExpressionException("Could not pop out of an empty stack");
        }

        // idk about the case where there are 2 or more operands left on the stack at the end
        if(tokenStack.isEmpty())
            return result;

        throw new MalformedExpressionException("Stack not empty after popping the result");
    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }

    private void performOperation(Operator operator) throws MalformedExpressionException {
        try {
            int rightOperand = ((Operand) tokenStack.pop()).getValue();
            int leftOperand = ((Operand) tokenStack.pop()).getValue();
            Operand operand;

            switch (operator.getOperation()) {
                case ADD:
                    operand = new Operand(leftOperand + rightOperand);
                    break;
                case SUBTRACT:
                    operand = new Operand(leftOperand - rightOperand);
                    break;
                case MULTIPLY:
                    operand = new Operand(leftOperand * rightOperand);
                    break;
                case DIVIDE:
                    if(rightOperand == 0)
                        throw new MalformedExpressionException("Cannot divide by 0");
                    operand = new Operand(leftOperand / rightOperand);
                    break;
                default:
                    throw new MalformedExpressionException("Invalid operation");
            }
            pushOperand(operand);
        } catch (EmptyStackException e) {
            throw new MalformedExpressionException(e.getMessage());
        }
    }
}
