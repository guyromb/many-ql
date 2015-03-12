/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.qlqls.generated.node;

import org.uva.student.calinwouter.qlqls.generated.analysis.*;

@SuppressWarnings("nls")
public final class AListElement extends PElement
{
    private PIdentList _identList_;

    public AListElement()
    {
        // Constructor
    }

    public AListElement(
        @SuppressWarnings("hiding") PIdentList _identList_)
    {
        // Constructor
        setIdentList(_identList_);

    }

    @Override
    public Object clone()
    {
        return new AListElement(
            cloneNode(this._identList_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListElement(this);
    }

    public PIdentList getIdentList()
    {
        return this._identList_;
    }

    public void setIdentList(PIdentList node)
    {
        if(this._identList_ != null)
        {
            this._identList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identList_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identList_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identList_ == child)
        {
            this._identList_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identList_ == oldChild)
        {
            setIdentList((PIdentList) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
