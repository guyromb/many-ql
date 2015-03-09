/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class ANullTerm extends PTerm {

    public ANullTerm() {
        // Constructor
    }

    @Override
    public Object clone() {
        return new ANullTerm();
    }

    @Override
    public void apply(Switch sw) {
        ((Analysis) sw).caseANullTerm(this);
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child) {
        // Remove child
        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild) {
        // Replace child
        throw new RuntimeException("Not a child.");
    }
}
