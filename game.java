// GITHUB LINK-->> https://github.com/Sarfinaa/2048-game.git
import java.util.*;
//Made pair class to store whether the user won the game or lost the game 
class pair {
    boolean won = false;
    boolean lost = false;

    pair(boolean won, boolean lost) {
        this.won = won;
        this.lost = lost;
    }

    pair() {

    }
}

public class game {

    public static boolean up(int[][] board) {
        boolean moved = false;
        int si, ei;
        for (int j = 0; j < 4; j++) {
            si = 0;
            ei = j;
            for (int i = 1; i < 4; i++) {
                if (board[i][j] != 0) {
                    if (board[i - 1][j] == 0 || board[i - 1][j] == board[i][j]) {
                        if (board[si][ei] == board[i][j]) {
                            board[si][ei] *= 2;
                            board[i][j] = 0;
                            si++;
                        } else {
                            if (board[si][ei] == 0) {
                                board[si][ei] = board[i][j];
                                board[i][j] = 0;
                            } else {
                                board[++si][ei] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                        moved = true;
                    } else
                        si++;
                }
            }
        }
        return moved;
    }

    public static boolean down(int[][] board) {
        boolean moved = false;
        int si, ei;
        for (int j = 0; j < 4; j++) {
            si = 3;
            ei = j;
            for (int i = 2; i >= 0; i--) {
                if (board[i][j] != 0) {
                    if (board[i + 1][j] == 0 || board[i + 1][j] == board[i][j]) {
                        if (board[si][ei] == board[i][j]) {
                            board[si][ei] *= 2;
                            board[i][j] = 0;
                            si--;
                        } else {
                            if (board[si][ei] == 0) {
                                board[si][ei] = board[i][j];
                                board[i][j] = 0;
                            } else {
                                board[--si][ei] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                        moved = true;
                    } else
                        si--;
                }
            }
        }
        return moved;
    }

    public static boolean left(int[][] board) {
        boolean moved = false;
        int si, ei;
        for (int i = 0; i < 4; i++) {
            si = i;
            ei = 0;
            for (int j = 1; j < 4; j++) {
                if (board[i][j] != 0) {
                    if (board[i][j - 1] == 0 || board[i][j - 1] == board[i][j]) {
                        if (board[si][ei] == board[i][j]) {
                            board[si][ei] *= 2;
                            board[i][j] = 0;
                            ei++;
                        } else {
                            if (board[si][ei] == 0) {
                                board[si][ei] = board[i][j];
                                board[i][j] = 0;
                            } else {
                                board[si][++ei] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                        moved = true;
                    } else
                        ei++;
                }
            }
        }
        return moved;
    }

    public static boolean right(int[][] board) {
        boolean moved = false;
        int si, ei;
        for (int i = 0; i < 4; i++) {
            si = i;
            ei = 3;
            for (int j = 2; j >= 0; j--) {
                if (board[i][j] != 0) {
                    if (board[i][j + 1] == 0 || board[i][j + 1] == board[i][j]) {
                        if (board[si][ei] == board[i][j]) {
                            board[si][ei] *= 2;
                            board[i][j] = 0;
                            ei--;
                        } else {
                            if (board[si][ei] == 0) {
                                board[si][ei] = board[i][j];
                                board[i][j] = 0;
                            } else {
                                board[si][--ei] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                        moved = true;
                    } else
                        ei--;
                }
            }
        }
        return moved;
    }

    public static void addNewCell(int[][] a) {
        int li, ri;
        while (true) {
            li = (int) (Math.random() * 4);
            ri = (int) (Math.random() * 4);
            if (a[li][ri] == 0) {
                a[li][ri] = (int) Math.pow(2, (int) (Math.random() * 2) + 1);
                break;
            }
        }

    }

    public static pair gameCompleteOrNot(int[][] a) {
        pair p = new pair();
        boolean fl = false, gl = false;
        int i, j;
        for (i = 0; i < 4; i++)
            for (j = 0; j < 4; j++) {
                if (a[i][j] == 0)
                    fl = true;
                else if (a[i][j] == 2048)
                    p.won = true;

            }
        if (!p.won) {
            for (i = 0; i < 3; i++)
                for (j = 0; j < 3; j++)
                    if (a[i + 1][j] == a[i][j] || a[i][j + 1] == a[i][j]) {
                        gl = true;
                        break;
                    }
        }

        if (fl || gl)
            p.lost = true;
        return p;

    }

    public static void display(int[][] board) {

        System.out.println("   Press: 1->left,2->right,3->up,4->down,n->new game,q->quit");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0)
                    System.out.print(board[i][j] + " ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }

    }

    public static void newGame() {
        //Initalizing board
        board = new int[4][4];
        // As we know at the start we have to fill 2 cells with either 2 or 4 
        int r1, c1, r2, c2;
        //Getting random values for first cell
        r1 = (int) (Math.random() * 4);
        c1 = (int) (Math.random() * 4);
        while (true) {
        //Getting random values for second cell
            r2 = (int) (Math.random() * 4);
            c2 = (int) (Math.random() * 4);
            //If both the cells are different then we break out of the loop else we find different cell
            if (r2 != r1 && c2 != c1)
                break;
        }
        //placing 2 or 4 on the 2 cells that we get from above
        //(int) Math.pow(2, (int) (Math.random() * 2) + 1) -> it basically generating 2 or 4 randomly
        board[r1][c1] = (int) Math.pow(2, (int) (Math.random() * 2) + 1);
        board[r2][c2] = (int) Math.pow(2, (int) (Math.random() * 2) + 1);

    }
    // Declared board
    public static int[][] board;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("                            2048 game");
        //Creating game 
        newGame();
        display(board);
        char ch;
        while (true) {
            String str=s.next();
            //if input length is greater than 1 then it's a invalid argument 
            ch=str.length()==1?str.charAt(0):'#';
            boolean moved = false;
            if (ch - '0' == 1)
                moved = left(board);
            else if (ch - '0' == 2)
                moved = right(board);
            else if (ch - '0' == 3)
                moved = up(board);
            else if (ch - '0' == 4)
                moved = down(board);
            else if (ch == 'n') {
                System.out.println("                   New Game Started");
                newGame();
            }

            else if (ch == 'q'){
                System.out.println("                  Game Ended");
                break;
            }
                
            else
                System.out.println("        Enter Valid Arguments as mentioned below!!!");
       // If any of the above operation is performed then we add new cell to the board
            if (moved)
                addNewCell(board);
            //finding whether game is complete or not 
            pair p = gameCompleteOrNot(board);
            if (p.won) {
                System.out.println("              Congratulations you won the game!!!!");
                System.out.println("Wanna Play Again(y/n)???");
                if (s.next().charAt(0) == 'y') {
                    System.out.println("                   New Game Started");
                    newGame();
                }

                else
                    break;
            }
            if (!p.lost) {
                System.out.println("                    GAME OVER");
                System.out.println("  Wanna Play Again(y/n)???");
                if (s.next().charAt(0) == 'y') {
                    System.out.println("                   New Game Started");
                    newGame();
                } else
                    break;
            }
            display(board);

        }
        s.close();
        return;
    }
}