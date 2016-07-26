import java.util.Random;

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
            // keeps validity aisdjasid
            if(a == 10) b = 4;
            if(b > 9) b = (b%9) + 1;
        }
    }

    public static void gen_rand(int check)
    {
        int s1, s2, max = 2, min = 0;
        Random r = new Random();

        for(int i = 0; i < 3; i++)
        {
            s1 = r.nextInt(max - min + 1) + min;

            // ensure different row/cols are selected to swap
            do {
                s2 = r.nextInt(max - min + 1) + min;
            } while(s1==s2);

            max += 3;
            min += 3;

            if(check == 1) swap_rows(s1,s2);
            else if(check == 0) swap_cols(s1,s2);
        }
    }

    // swap single lines between group sections
    public static void swap_rows(int row1, int row2)
    {
        int temp;

        for(int a = 0; a < 9; a++)
        {
            temp = board[row1][a];
            board[row1][a] = board[row2][a];
            board[row2][a] = temp;
        }
    }

    public static void swap_cols(int col1, int col2)
    {
        int temp;

        for(int a = 0; a < 9; a++)
        {
            temp = board[a][col1];
            board[a][col1] = board[a][col2];
            board[a][col2] = temp;
        }
    }

    // swap groups of 3
    public static void swap_row_group(int rows1, int rows2)
    {
        int temp;

        for(int j = 1; j <= 3; j++)
        {
            for(int k = 0; k < 9; k++)
            {
                temp = board[rows1][k];
                board[rows1][k] = board[rows2][k];
                board[rows2][k] = temp;
            }
            rows1++;
            rows2++;
        }
    }

    public static void swap_col_group(int cols1, int cols2)
    {
        int temp;

        for(int j = 1; j <= 3; j++)
        {
            for(int k = 0; k < 9; k++)
            {
                temp = board[k][cols1];
                board[k][cols1] = board[k][cols2];
                board[k][cols2] = temp;
            }
            cols1++;
            cols2++;
        }
    }

    public int[][] getBoard()
    {
        return board;
    }
}
