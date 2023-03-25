import java.util.Scanner;

public class Puzzle {

    private final String name;
    private final String question;
    private final String solution;
    private boolean solved;
    private final int startingTries;
    private int currentTries;



    public Puzzle(String name, String question, String solution, int startingTries) {
        this.name = name;
        this.question = question;
        this.solution = solution;
        this.startingTries = startingTries;
        this.solved = false;
        this.currentTries = startingTries;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("You have encountered a Puzzle!");
        while(true) {
            System.out.println();
            System.out.println("---------------------------------------------");
            if (this.currentTries <= 0) {
                System.out.println("Sorry, you have run out of tries!");
                System.out.println("You can always come back and try again!");
                System.out.println("---------------------------------------------");
                System.out.println();
                break;
            } else {
                System.out.println("You have " + this.currentTries + " tries left");
                System.out.println(this.question);

                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase(solution)) {
                    solvePuzzle();
                    break;
                } else {
                    System.out.println("Sorry that is not the correct answer");
                    decrementTries();
                }
            }
        }
    }

    public void decrementTries() {
        this.currentTries--;
    }

    public void resetPuzzle() {
        this.currentTries = this.startingTries;
    }

    public void solvePuzzle() {
        System.out.println(" ");
        System.out.println("Congratulations! You Solved the Puzzle Correctly!");
        System.out.println();
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
        return currentTries;
    }
}
