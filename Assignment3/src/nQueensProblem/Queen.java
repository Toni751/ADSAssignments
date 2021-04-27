package nQueensProblem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Queen
{
    static ArrayList<ArrayList<Integer>> result;
    static int[] row = new int[10];
    static int q = 0;

    static boolean put(int row, int column)
    {
        for (int prev = 0; prev < column; prev++)
            if (Queen.row[prev] == row || (int) Math.abs(Queen.row[prev] - row) == (int) Math.abs(prev - column))
                return false;
        return true;
    }

    static void bt(int column, int n)
    {
        if (n == 2 || n == 3)
            return;
        if (column == n)
        {

            ArrayList<Integer> v = new ArrayList<Integer>();

            for (int i = 0; i < n; i++)
                v.add(row[i] + 1);
            result.add(v);
            q++;
        }

        for (int i = 0; i < n; i++)
        {
            if (put(i, column))
            {
                row[column] = i;
                bt(column + 1, n);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> nQueenList(int n)
    {
        result = new ArrayList<ArrayList<Integer>>();
        bt(0, n);
        return result;
    }
    static void printNicely(ArrayList<ArrayList<Integer>> solutions){
        Array[][] arrays = new Array[solutions.get(0).size()][solutions.get(0).size()];
        for(int i=0;i<solutions.get(0).size();i++){

        }
    }
}
