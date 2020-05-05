/*
 * Copyright (c) 2010 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.heuristics.relaxation;

import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.Fluent;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.State;

import java.util.List;

/**
 * This abstract class implements the basic methods of all heuristics.
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 */
public abstract class AbstractHeuristic implements RelaxationHeuristic {

    /**
     * The goal to reached.
     */
    private State goal;

    /**
     * The list of facts of the relaxed problem.
     */
    private List<Fluent> facts;

    /**
     * The lists of operators of the relaxed problem.
     */
    private List<Action> operators;

    /**
     * The boolean flag used to indicate if the heuristic is admissible.
     */
    private boolean isAdmissible;

    /**
     * Create a new heuristic for a specified planning problem. By default the heuristic is
     * considered as admissible.
     *
     * @param problem the problem to solve.
     */
    protected AbstractHeuristic(final Problem problem) {
        if (problem == null) {
            throw new NullPointerException("problem == null");
        }
        this.facts = problem.getRelevantFluents();
        this.goal = problem.getGoal();
        this.operators = problem.getActions();
        this.isAdmissible = true;
    }

    /**
     * Returns <code>true</code> if this heuristic is admissible.
     *
     * @return <code>true</code> if this heuristic is admissible.
     */
    @Override
    public boolean isAdmissible() {
        return this.isAdmissible;
    }

    /**
     * Marks the heuristic as admissible or not.
     *
     * @param isAdmissible the admissible flag.
     */
    protected final void setAdmissible(boolean isAdmissible) {
        this.isAdmissible = isAdmissible;
    }

    /**
     * Returns the goal of the relaxed problem to solve in order to compute the heuristic.
     *
     * @return the goal.
     */
    protected final State getGoal() {
        return this.goal;
    }

    /**
     * Set the goal of the the relaxed problem to solve in order to compute the heuristic.
     *
     * @param goal the goal.
     */
    protected void setGoal(final State goal) {
        if (!goal.equals(this.goal)) {
            this.goal = goal;
        }
    }

    /**
     * Returns the relevant facts of the relaxed problem to solve in order to compute the heuristic.
     *
     * @return the relevant facts.
     */
    protected final List<Fluent> getRevelantFacts() {
        return this.facts;
    }

    /**
     * Returns the operators of the relaxed problem to solve in order to compute the heuristic.
     *
     * @return the operators.
     */
    protected final List<Action> getOperators() {
        return this.operators;
    }

}
