import java.util.Arrays;
import java.util.Objects;

public class Board {

    String[] position = new String[9];

    int numberOfPlays;

    Board() {
        Arrays.fill(position, " ");
        numberOfPlays = 0;
    }

    public void getBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + position[0] + " | "
                + position[1] + " | " + position[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + position[3] + " | "
                + position[4] + " | " + position[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + position[6] + " | "
                + position[7] + " | " + position[8]
                + " |");
        System.out.println("|---|---|---|");
    }


    public boolean spacesAvailable(int pos) {
        return Objects.equals(position[pos], " ");
    }

    public void playInBoard(int pos, String c) {
        position[pos] = c;
        numberOfPlays++;
    }

    public boolean checkWinner(Player player) {
        String icon = player.icon;

        if (position[0].equals(icon) && position[4].equals(icon) && position[8].equals(icon) ||
                position[3].equals(icon) && position[5].equals(icon) && position[7].equals(icon)) return true;

        if (position[0].equals(icon) && position[1].equals(icon) && position[2].equals(icon) ||
                position[3].equals(icon) && position[4].equals(icon) && position[5].equals(icon) ||
                position[6].equals(icon) && position[7].equals(icon) && position[8].equals(icon)) return true;

        if (position[0].equals(icon) && position[3].equals(icon) && position[6].equals(icon) ||
                position[1].equals(icon) && position[4].equals(icon) && position[7].equals(icon) ||
                position[2].equals(icon) && position[5].equals(icon) && position[8].equals(icon)) return true;



        return false;
    }

    public void gameRestart() {
        Arrays.fill(position, " ");
        numberOfPlays = 0;
        System.out.println("|---|---|---| New Game |---|---|---|");
    }


}
