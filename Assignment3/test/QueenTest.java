import nQueensProblem.Queen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class QueenTest
{
    private ArrayList<ArrayList<Integer>> result;

    @BeforeEach
    public void setUp()
    {
        result = new ArrayList<>();
    }

    @Test
    public void impossible3()
    {
        result = Queen.nQueenList(3);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void min4()
    {
        result = Queen.nQueenList(4);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void many10()
    {
        result = Queen.nQueenList(10);
        Assertions.assertEquals(724, result.size());
    }
}

