package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.Method;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class contains the methods used after the bit encoding of a planning problem. In particular, the class contains
 * methods to compute the revolvers for each tasks of a planning domain.
 *
 * @author D. Pellier
 * @version 1.0 - 16.04.2020
 */
public final class PostEncoding implements Serializable {

    /**
     * Creates the table of relevant operators for each task.
     */
    static void createTableOfRelevantOperators() {
        Encoder.tableOfRelevantOperators = new ArrayList<>(Encoder.tableOfRelevantTasks.size());
        for (int ti = 0; ti < Encoder.tableOfRelevantTasks.size(); ti++) {
            final IntExpression task = Encoder.tableOfRelevantTasks.get(ti);
            final List<Integer> operators = new ArrayList<>();
            if (task.isPrimtive()) {
                for (int ai = 0; ai < Encoder.actions.size(); ai++) {
                    final Action action = Encoder.actions.get(ai);
                    if (action.getName().equals(Encoder.tableOfTasks.get(task.getPredicate()))
                            && Arrays.equals(action.getInstantiations(), task.getArguments())) {
                        operators.add(ai);
                    }
                }
            } else {
                for (int mi = 0; mi < Encoder.methods.size(); mi++) {
                    final Method method = Encoder.methods.get(mi);
                    if (method.getTask() == ti) {
                        operators.add(mi);
                    }
                }
            }
            Encoder.tableOfRelevantOperators.add(operators);
        }

    }

}
