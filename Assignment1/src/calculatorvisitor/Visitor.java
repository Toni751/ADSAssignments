package calculatorvisitor;

import token.Operand;
import token.Operator;

public interface Visitor
{
    void visit(Operand operand);
    void visit(Operator operator);
}
