/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.ql.generated.node;

import org.uva.student.calinwouter.ql.generated.analysis.*;

@SuppressWarnings("nls")
public final class TTstring extends Token
{
    public TTstring()
    {
        super.setText("string");
    }

    public TTstring(int line, int pos)
    {
        super.setText("string");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTstring(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTstring(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTstring text.");
    }
}
