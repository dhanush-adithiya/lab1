import java.util.Scanner;
public class AlphabetWar {
    public String input;
    public String left;
    public String right;

    public AlphabetWar(String input) {
        this.input = input;
        this.checkWinner(this.input);
    }

    public AlphabetWar(String left, String right) {
       this.left = left.replaceAll("[mqdz]","");
       this.right = right.replaceAll("[wpbs]","");
       this.checkWinner(this.left ,this.right);
    }

    public void checkWinner(String input)  {
        String leftString = input.replaceAll("[mqdz]","");
        String rightString = input.replaceAll("[wpbs]","");

        this.checkWinner(leftString, rightString);
    }

    public void checkWinner(String left, String right)  {
        int leftScore = this.countScore(left);
        int rightScore = this.countScore(right);

        this.announceWinner(leftScore, rightScore);
    }

    public void announceWinner(int leftScore, int rightScore) {
        if (leftScore > rightScore) {
           System.out.println("Left Side Wins");
        } else if (leftScore < rightScore) {
            System.out.println("Right Side Wins");
        } else {
            System.out.println("It Is A Draw");
        }
    }

    public int countScore(String input) {

        if (input == null) {
           return 0;
        }
        int score = 0;

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case 'w', 'm' -> score += 4;
                case 'p', 'q' -> score += 3;
                case 'b', 'd' -> score += 2;
                case 's', 'z' -> score += 1;
                default -> score += 0;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        AlphabetWar inp1 = new AlphabetWar("z");
        AlphabetWar inp2 = new AlphabetWar("qq","z");

    }
}
