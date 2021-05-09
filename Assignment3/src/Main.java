import nQueensProblem.Queen;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> ints = Queen.nQueenList(5);
        Queen.printNicely(ints);

    }
}