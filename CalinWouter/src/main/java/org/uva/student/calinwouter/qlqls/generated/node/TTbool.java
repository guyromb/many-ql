/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.qlqls.generated.node;

import org.uva.student.calinwouter.qlqls.generated.analysis.*;

@SuppressWarnings("nls")
public final class TTbool extends Token
{
    public TTbool()
    {
        super.setText("boolean");
    }

    public TTbool(int line, int pos)
    {
        super.setText("boolean");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTbool(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTbool(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTbool text.");
    }
}
