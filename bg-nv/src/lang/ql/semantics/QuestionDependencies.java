package lang.ql.semantics;

import lang.ql.ast.statement.Question;

import java.util.*;

/**
 * Created by bore on 17/02/15.
 */
public class QuestionDependencies
{
    private final Map<String, Set<String>> dependencies;
    private Identifiers cyclicIds;

    public QuestionDependencies()
    {
        this.dependencies = new HashMap<>();
    }

    public void addQuestion(Question q)
    {
        String id = q.getId();
        if (!(this.dependencies.containsKey(id)))
        {
            this.dependencies.put(id, new HashSet<>());
        }
    }

    public void addDependency(Question q, Question dep)
    {
        String id = q.getId();

        assert this.dependencies.containsKey(id);

        this.dependencies.get(id).add(dep.getId());
    }

    public Identifiers getCycleIds()
    {
        return this.cyclicIds;
    }

    public boolean containsCycle()
    {
        return this.findCycles();
    }

    private boolean findCycles()
    {
        this.cyclicIds = new Identifiers();

        for (String id : this.dependencies.keySet())
        {
            Stack<String> path = new Stack<>();
            path.add(id);
            if (this.searchNeighboursForCycles(path))
            {
                return true;
            }
        }

        return false;
    }

    private boolean searchNeighboursForCycles(Stack<String> path)
    {
        String lastElement = path.lastElement();
        Set<String> neighbours = this.dependencies.get(lastElement);

        for (String n : neighbours)
        {
            if (this.isNeighbourFormingCycle(path, n))
            {
                return true;
            }

            path.push(n);
            if (this.searchNeighboursForCycles(path))
            {
                return true;
            }
            path.pop();
        }

        return false;
    }

    private boolean isNeighbourFormingCycle(Stack<String> path, String n)
    {
        String firstElement = path.firstElement();
        if (firstElement.equals(n))
        {
            this.cyclicIds.addAll(path);
            return true;
        }

        return false;
    }
}