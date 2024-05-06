// Evaluation function for GBFS
public class GBFSEvaluation extends EvaluationFunction {
    @Override
    public int evaluateNode(Node node, String target) {
        return Dictionary.getCharacterDiff(node.getWord(), target);
    }
}
