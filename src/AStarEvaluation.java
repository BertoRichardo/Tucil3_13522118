// Evaluation function for A*
public class AStarEvaluation extends EvaluationFunction {
    @Override
    public int evaluateNode(Node node, String target) {
        int cost = node != null ? node.getCost() : 0;
        return cost + Dictionary.getCharacterDiff(node.getWord(), target);
    }
}
