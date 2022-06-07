import java.security.SecureRandom;
import java.util.Scanner;

public class GameGrid {
    public void run() {
        int[][] iGrid = new int[10][10];
        int iWallChance = 30;
        int x, y;
        SecureRandom random = new SecureRandom();
        for (x = 0; x < iGrid.length; x++) {
            for (y = 0; y < iGrid[0].length; y++) {
                int iChance = random.nextInt(100);
                if (x == 0 && y == 0) {
                    iGrid[0][0] = 0;
                } else if (iChance < iWallChance) {
                    iGrid[x][y] = 1;
                } else {
                    iGrid[x][y] = 0;
                }
            }
        }

        int iUserRow = 0;
        int iUserCol = 0;
        boolean exit = true;

        LinkedList oLinkedList = new LinkedList();

        while (exit) {
            System.out.println("Move down or to the right? (Press 1 for moving down, " +
                    "2 for moving to the right)");
            Scanner input = new Scanner(System.in);
            int answer = input.nextInt();
            if (answer == 1) {
                iUserRow = iUserRow + 1;
            } else if (answer == 2) {
                iUserCol = iUserCol + 1;
            }

            oLinkedList.addHeadNode(iUserRow, iUserCol);

            if (iGrid[iUserRow][iUserCol] == 1) {
                System.out.println("You failed.");
                exit = false;
            }
            if (iUserCol == 9 || iUserRow == 9) {
                System.out.println("You won!");
                exit = false;
            }
        }

        int numOfMoves = 0;
        Node node1;
        while (true) {
            node1 = oLinkedList.removeHeadNode();
            iGrid[node1.xPosition][node1.yPosition] = 8;
            numOfMoves = numOfMoves + 1;
            if (oLinkedList.getHeadNode() == null)
                break;
            }


        for(x = 0; x < iGrid.length; x++) {
            for (y = 0; y < iGrid[0].length; y++) {
                if (x == iUserRow && y == iUserCol) {
                    System.out.print("X" + " ");
                }
                else {
                    System.out.print(iGrid[x][y] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("You moved " + numOfMoves + " time(s)");
    }
}

