import java.util.Scanner;

public class Puzzle {

    private final String name;
    private final String question;
    private final String solution;
    private boolean solved;
    private int tries;



    public Puzzle(String name, String question, String solution, int tries) {
        this.name = name;
        this.question = question;
        this.solution = solution;
        this.tries = tries;
        this.solved = false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("---------------------------------------------");
            if (this.tries <= 0) {
                System.out.println("Sorry, you have run out of tries!");
                System.out.println("You can always come back and try again!");

                break;
            } else {
                System.out.println("You have " + this.tries + " tries left");
                System.out.println(this.question);

                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase(solution)) {
                    solvePuzzle();
                    System.out.println("-----------------------------");
                    break;
                } else {
                    System.out.println("Sorry that is not the correct answer");
                    decrementTries();
                }
            }
        }
    }

    public void decrementTries() {
        this.tries--;
    }

    public void solvePuzzle() {
        System.out.println(" ");
        System.out.println("Congratulations! You Solved the Puzzle Correctly!");
        this.solved = true;
    }

    public String getName() {
        return name;
    }

    public String getQuestion() {
        return question;
    }

    public String getSolution() {
        return solution;
    }

    public boolean isSolved() {
        return solved;
    }

    public int getTries() {
        return tries;
    }
}
