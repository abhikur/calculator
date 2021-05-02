package evaluators;

import java.util.ArrayList;
import java.util.List;

public class Evaluators {

    public static List<Evaluator> bodmasEvaluators() {
        List<Evaluator> evaluators = new ArrayList<>();
        Divider divider = new Divider();
        Multiplier multiplier = new Multiplier();
        Adder adder = new Adder();
        Subtractor subtractor = new Subtractor();

        evaluators.add(divider);
        evaluators.add(multiplier);
        evaluators.add(adder);
        evaluators.add(subtractor);
        return evaluators;
    }
}
