package calculatorvisitor;

import customexceptions.MalformedExpressionException;

public interface Calculator
{
    int getResult() throws MalformedExpressionException;
}
