import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board();
        Player human = new Player("Human", board);
        Player bot = new Player("Bot", board);
        Scanner playerInput = new Scanner(System.in);

        while (true) {
          board.getBoard();
          System.out.println("Chose a move (0-8):");
            String move = playerInput.nextLine();
            if (move.equals("q")) {
                break;
            }
            while (!board.spacesAvailable(Integer.parseInt(move))) {
                System.out.println("Move not available!");
                System.out.println("Chose a move (0-8):");
                move = playerInput.nextLine();
            }
            human.play(Integer.parseInt(move), human);
            if (board.checkWinner(human)) {
                System.out.println("Humam was won!!!!");
                board.getBoard();
                Thread.sleep(4000);
                board.gameRestart();
                continue;
            }
                bot.play(bot);
                if (board.checkWinner(bot)) {
                    System.out.println("Bot was won!!!!");
                    board.getBoard();
                    Thread.sleep(4000);
                    board.gameRestart();
            }
        }
    }


}
