// Evaluation function for UCS
public class UCSEvaluation extends EvaluationFunction {
    @Override
    public int evaluateNode(Node node, String target) {
        return node != null ? node.getCost() : 0;
    }
}
