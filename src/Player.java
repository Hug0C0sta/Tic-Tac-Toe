import java.util.Random;

public class Player {
    String icon;
    Board board;
    String name;

    Player(String name, Board board) {
        this.name = name;
        this.board = board;
        if (name.equals("Human")) this.icon = "o";
        else this.icon = "x";
    }

    public void play(int pos, Player player) {
        board.playInBoard(pos, icon);
    }

    public void play(Player player) {
        if (board.numberOfPlays >= 8) {
            return;
        }
        Random botMove = new Random();
        while (true) {
            int pos = botMove.nextInt(0, 9);
            if (board.spacesAvailable(pos)) {
                board.playInBoard(pos, icon);
                board.checkWinner(player);
                return;
            }
        }
    }


}
