package src;

import java.util.*;

public class Main {

    char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    char turn = 'X';

    List<Integer> indexList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);


    public Character checkWinner() {

        StringBuilder text = new StringBuilder();

        text.append(String.valueOf(turn).repeat(board.length));

        for (char[] chars : board) {


            for (int j = 0; j < board.length; j++) {

                if (Arrays.toString(chars).equals(text.toString())) {

                    return turn;
                } else if (getColumn(j).equals(text.toString())) {

                    return turn;
                } else if (getFirstDiagonal().equals(text.toString())) {

                    return turn;
                } else if (getSecondDiagonal().equals(text.toString())) {

                    return turn;
                }

            }

        }

        for (int a = 0; a < board.length * board.length; a++) {
            if (indexList.get(a) == a) {

                break;
            } else if (a == 8) {
                return '=';
            }
        }

        //System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    }


    public void printBoard() {

        String horizontalLine = "_______________";
        String verticalLine = " | ";
        //String cell = "" ;

        for (char[] chars : board) {

            System.out.println(horizontalLine);

            for (int j = 0; j < board.length; j++) {

                System.out.print(verticalLine + chars[j]);
            }
            System.out.println(verticalLine);
        }


        System.out.println(horizontalLine);



    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {

        Scanner in = new Scanner(System.in);
        Character winner = null;


        System.out.println("Welcome to 3x3 Tic Tac Toe.");

        printBoard();


        System.out.println("X will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int numInput;

            try {
                numInput = in.nextInt();
                if (!(numInput >= 0 && numInput < 9)) {

                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            } catch (InputMismatchException e) {

                System.out.println("Invalid input; re-enter slot number:");
                continue;
            }


            if (indexList.contains(numInput)) {

                board[numInput / board.length][numInput % board.length] = turn;

                winner = checkWinner() ;
                if (turn == 'X') {
                    turn = '0';
                } else {
                    turn = 'X';
                }

                printBoard();

            } else {
                System.out.println("Slot already taken; re-enter slot number:");
            }
        }


        if (winner == '=') {
            System.out.println("It's a draw! Thanks for playing.");
        } else {

            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
        in.close();


    }

    public String getColumn (int column ) {

        StringBuilder text = new StringBuilder();

        if (column < 0 || column >= board.length) {

            return null ;
        }

        for (char[] chars : board) {


            text.append(chars[column]);

        }

        return text.toString();
    }

    public String getFirstDiagonal () {

        StringBuilder text = new StringBuilder();
        for (int i = 0 ; i< board.length ; i++) {

            text.append(board[i][i]);
        }

        return text.toString();
    }

    public String getSecondDiagonal () {

        StringBuilder text = new StringBuilder();
        for (int i = 0 ; i< board.length ; i++) {

            for (int j = 0 ; j< board.length ; j++) {

                if (i+j == board.length - 1) {

                    text.append(board[i][j]);
                }
            }
        }

        return text.toString();
    }


}
