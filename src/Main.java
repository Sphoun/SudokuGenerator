/**
 * Created by scott on 2016-07-08.
 */
public class Main
{
    public static void main(String [] args)
    {
        SudokuBoard board = new SudokuBoard();
        board.generate();
        int[][] myBoard = board.getBoard();

        for(int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                System.out.print(myBoard[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
