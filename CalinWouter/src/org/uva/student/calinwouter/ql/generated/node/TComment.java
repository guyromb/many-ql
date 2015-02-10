/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.ql.generated.node;

import org.uva.student.calinwouter.ql.generated.analysis.*;

@SuppressWarnings("nls")
public final class TComment extends Token
{
    public TComment(String text)
    {
        setText(text);
    }

    public TComment(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TComment(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTComment(this);
    }
}