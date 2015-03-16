package com.klq.typechecker.error;

import com.klq.ast.impl.Location;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class NotUniqueID extends AError{

    public NotUniqueID(String id, Location location) {
        super(1, true, String.format("The question identifier: \"%s\" is not unique", id), location);
    }



}
