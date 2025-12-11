import java.util.*;

public class TicTacToe {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {

        initializeBoard();
        char currentPlayer = 'X';

        while (true) {
            printBoard();
            playerMove(currentPlayer);

            if (checkWinner(currentPlayer)) {
                printBoard();
                System.out.println(currentPlayer + " wins!");
                break;
            }

            if (isDraw()) {
                printBoard();
                System.out.println("Game is a Draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
                System.out.print(board[i][j] + " ");
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static void playerMove(char player) {
        Scanner sc = new Scanner(System.in);
        int r, c;

        while (true) {
            System.out.println("Player " + player + ", enter row and column (0-2): ");
            r = sc.nextInt();
            c = sc.nextInt();

            if (r >= 0 && r < 3 && c >= 0 && c < 3 && board[r][c] == ' ') {
                board[r][c] = player;
                break;
            } else {
                System.out.println("Invalid move, try again!");
            }
        }
    }

    static boolean checkWinner(char p) {
       
        for (int i = 0; i < 3; i++)
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p)
                return true;


        for (int j = 0; j < 3; j++)
            if (board[0][j] == p && board[1][j] == p && board[2][j] == p)
                return true;


        if (board[0][0] == p && board[1][1] == p && board[2][2] == p)
            return true;

        if (board[0][2] == p && board[1][1] == p && board[2][0] == p)
            return true;

        return false;
    }

    static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }
}

