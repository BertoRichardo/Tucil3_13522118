import java.util.HashSet;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class WordLadderSearch {
    private int numOfVisited;

    // constructor
    public WordLadderSearch() {
        numOfVisited = 0;
    }

    // getter
    public int getNumOfVisited() {
        return numOfVisited;
    }

    // Implementation of search function, evaluator is evaluation function used for
    // the search
    public ArrayList<String> search(
            String start,
            String target,
            Dictionary dictionary,
            EvaluationFunction evaluator) {

        // Since visiting visited node won't lead into optimal function, don't expand it
        // again
        HashSet<String> visited = new HashSet<>();
        // pq for nodes based on the evaluation function, the comparator is implemented
        // in Node class
        PriorityQueue<Node> nodesPQ = new PriorityQueue<>();

        // start node
        Node startNode = new Node(start, null, 0);
        startNode.setEvaluation(evaluator.evaluateNode(startNode, target));
        nodesPQ.add(startNode);

        // Iterate until pq is not empty
        while (!nodesPQ.isEmpty()) {
            Node currNode = nodesPQ.poll();
            String currWord = currNode.getWord();
            numOfVisited++;

            // Don't expand visited node
            if (visited.contains(currWord)) {
                continue;
            }

            visited.add(currWord);

            // immidiately return when found the solution
            if (currWord.equals(target)) {
                return currNode.getPath();
            }

            // Expand the current Node
            for (int i = 0; i < currWord.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    StringBuilder temp = new StringBuilder(currWord);
                    temp.setCharAt(i, (char) ('a' + j));
                    String check = new String(temp);
                    // don't include visited node into pq
                    if (dictionary.isWordValid(check) && !visited.contains(check)) {
                        Node newNode = new Node(check, currNode, currNode.getCost() + 1);
                        newNode.setEvaluation(evaluator.evaluateNode(currNode, target));
                        nodesPQ.add(newNode);
                    }
                }
            }
        }

        // No solution found
        return new ArrayList<>();
    }
}
