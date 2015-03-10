package lang.qls.semantics;

import lang.ql.ast.type.Type;
import lang.qls.ast.rule.Rules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bore on 09/03/15.
 */
public class Style
{
    private Map<Type, Rules> typeToRules;

    public Style()
    {
        this.typeToRules = new HashMap<>();
    }

    public void addRules(Type t, Rules rs)
    {
        this.typeToRules.put(t, rs);
    }

    public Rules getRulesForType(Type t)
    {
        return this.typeToRules.get(t);
    }

    public Style addStyle(Style lowPr)
    {
        Style result = new Style();
        result.typeToRules.putAll(this.typeToRules);

        for (Type t : lowPr.typeToRules.keySet())
        {
            Rules rs = this.getRulesForStyle(t, lowPr);
            result.addRules(t, rs);
        }

        return result;
    }

    private Rules getRulesForStyle(Type t, Style s)
    {
        Rules rs = s.typeToRules.get(t);

        if (this.typeToRules.containsKey(t))
        {
            Rules h = this.typeToRules.get(t);
            return h.addRules(rs);
        }

        return rs;
    }
}
