/**
 * Created by scott on 2016-07-08.
 */
public class SudokuBoard
{
    public static int [][] board = new int[9][9];

    public static void generate()
    {
        int a, b = 1;
        for(int i = 0; i < 9; i++)
        {
            a = b;
            for(int j = 0; j < 9; j++)
            {
                if(a<=9)
                {
                    board[i][j] = a;
                    a++;
                }
                else
                {
                    a = 1;
                    board[i][j] = a;
                    a++;
                }
            } //fill row

            b = a + 3;
            // keeps validity
            if(a == 10) b = 4;
            if(b > 9) b = (b%9) + 1;
        }
    }

    public int[][] getBoard()
    {
        return board;
    }
}
