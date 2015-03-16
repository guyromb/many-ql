package com.klq.typechecker;

import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.ast.impl.Type;
import com.klq.typechecker.error.AError;
import com.klq.typechecker.error.NotUniqueID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Juriaan on 28-2-2015.
 */
public class QuestionTable {
    private Map<String, QuestionNode> table;
    private ArrayList<AError> errors;

    public QuestionTable(ArrayList<AError> errors) {
        this.errors = errors;
        table = new HashMap<String, QuestionNode>();
    }

    public void add(String questionId, QuestionNode node){
        if(table.containsKey(questionId)){
            errors.add(new NotUniqueID(node.getID(), node.getLocation()));
        }
        else{
            table.put(questionId, node);
        }
    }

    public QuestionNode get(String questionId){
        return table.get(questionId);
    }

    public boolean has(String questionId){
        return table.containsKey(questionId);
    }

    public Type getQuestionType(String questionId){
        return table.get(questionId).getType();
    }
}
