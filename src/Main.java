import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Dictionary dictionary = new Dictionary("dictionary.txt");

            if (args.length != 3) {
                throw new IllegalArgumentException(
                        "Invalid Argument size. Valid Argument: <executable name> <algorithm (ucs/greedy/astar)> <start> <target>");
            }

            EvaluationFunction evaluator;
            switch (args[0].toLowerCase()) {
                case "ucs":
                    evaluator = new UCSEvaluation();
                    break;
                case "gbfs":
                    evaluator = new GBFSEvaluation();
                    break;
                case "astar":
                    evaluator = new AStarEvaluation();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid search method");
            }

            if (args[1].length() != args[2].length()) {
                throw new IllegalArgumentException("The start word and target word must the same size");
            }

            if (!dictionary.isWordValid(args[1].toLowerCase())) {
                throw new IllegalArgumentException("Start word is not on the word list");
            }

            if (!dictionary.isWordValid(args[2].toLowerCase())) {
                throw new IllegalArgumentException("Target word is not on the word list");
            }

            long timeStart = System.currentTimeMillis();
            WordLadderSearch engine = new WordLadderSearch();

            ArrayList<String> searchResult = engine.search(args[1].toLowerCase(), args[2].toLowerCase(), dictionary,
                    evaluator);
            if (searchResult.isEmpty()) {
                System.out.println("No solution found");
            } else {
                System.out.println("path: " + searchResult);
            }

            System.out.println("node visited: " + engine.getNumOfVisited());
            long timeEnd = System.currentTimeMillis();

            System.out.println("time elapsed : " + (timeEnd - timeStart) + "ms");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}