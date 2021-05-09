package nQueensProblem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Queen
{
    static ArrayList<ArrayList<Integer>> result;
    static int[] row;
    static int q = 0;

    static boolean put(int row, int column)
    {
        for (int previous = 0; previous < column; previous++)
            if (Queen.row[previous] == row || (int) Math.abs(Queen.row[previous] - row) == (int) Math.abs(previous - column))
                return false;
        return true;
    }

    static void backtracking(int column, int n)
    {
        if (n == 1 || n == 2 || n == 3)
            return;
        if (column == n)
        {

            ArrayList<Integer> v = new ArrayList<>();

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
                backtracking(column + 1, n);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> nQueenList(int n)
    {
        row = new int[n];
        result = new ArrayList<ArrayList<Integer>>();
        backtracking(0, n);
        return result;
    }

    public static int numberOfResults()
    {
        return result.size();
    }

    public static void printNicely(ArrayList<ArrayList<Integer>> solutions)
    {
        for (int a = 0; a < solutions.size(); a++)
        {

            System.out.println("\n" + "Solution " + a);
            ArrayList<Integer> sol = solutions.get(a);
            for (int i = 0; i < sol.size(); i++)
            {

                for (int j = 0; j < sol.size(); j++)
                {
                    if (sol.get(j) - 1 == i)
                    {
                        System.out.print(" X ");
                    } else System.out.print(" O ");
                }
                System.out.print("\n");
            }
        }

    }
}
