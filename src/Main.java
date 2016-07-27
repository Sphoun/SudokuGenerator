import java.util.Random;

/**
 * Created by scott on 2016-07-08.
 */
public class Main
{
    public static void main(String [] args)
    {
        int k1, k2, counter = 1;
        SudokuBoard board = new SudokuBoard();
        board.generate();
        int[][] myBoard = board.getBoard();

        System.out.println("Original board: \n");
        for(int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                System.out.print(myBoard[i][j] + "\t");
            }
            System.out.println();
        }

        // swap singles
        board.gen_rand(1); // rows
        board.gen_rand(0); // cols

        // swap groups
        Random rand=new Random();
        int n[] = { 0, 3, 6 };
        for(int i = 0; i < 2; i++)
        {
            k1 = n[rand.nextInt(n.length)];

            do{
                k2 = n[rand.nextInt(n.length)];
            }while(k1 == k2);

            if(counter == 1) board.swap_row_group(k1, k2);
            else board.swap_col_group(k1, k2);

            counter++;
        }

        // Post swaps
        System.out.println("\n Swapped board: \n");
        myBoard = board.getBoard();
        for(int x = 0; x < 9; x++)
        {
            for(int y = 0; y < 9; y++)
            {
                System.out.print(myBoard[x][y] + "\t");
            }
            System.out.println();
        }

        //Striking out
        for(k1 = 0; k1 < 9; k1++)
        {
            for(k2 = 0; k2 < 9; k2++) board.strike_out(k1,k2);
        }

        // View board
        System.out.println("\n Final Board: \n");

        for(int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if(j == 2 || j == 5) System.out.print(myBoard[i][j] + "\t|\t");
                else System.out.print(myBoard[i][j] + "\t");
            }
            if(i == 2 || i == 5) System.out.println("\n-----------------------------------------");
            System.out.println();
        }

    }
}
