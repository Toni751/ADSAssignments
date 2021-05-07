import nQueensProblem.Queen;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>>  ints= Queen.nQueenList(4);
        System.out.println(ints);

    }
}