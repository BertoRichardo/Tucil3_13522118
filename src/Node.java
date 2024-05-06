import java.util.ArrayList;

public class Node implements Comparable<Node> {
    private String word;
    private Node parent;
    private int cost;
    private int evaluation = 0;

    // Constructor
    public Node(String addedWord, Node parent, int cost) {
        this.word = addedWord;
        this.parent = parent;
        this.cost = cost;
    }

    // Setter for evaluation 
    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    // *NODE GETTER */
    public String getWord() {
        return word;
    }

    public Node getParent() {
        return parent;
    }

    public int getCost() {
        return cost;
    }

    public int getEvaluation() {
        return evaluation;
    }

    // Node is compared based on the evaluation function
    public int compareTo(Node other) {
        return this.evaluation - other.evaluation;
    }

    public ArrayList<String> getPath() {
        Node currNode = this;
        ArrayList<String> res = new ArrayList<>();
        while (currNode != null) {
            res.add(0, currNode.getWord());
            currNode = currNode.getParent();
        }
        return res;
    }
}