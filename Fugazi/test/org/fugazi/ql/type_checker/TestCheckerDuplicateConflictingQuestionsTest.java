package org.fugazi.ql.type_checker;


import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCheckerDuplicateConflictingQuestionsTest extends TypeCheckerBaseTest {

    @Before
    public void setUp() {
        this.fileName = "duplicateConflictingQuestions.ql";
        super.setUp();
    }

    @Test
    public void testFormCorrect() throws Exception {
        boolean formCorrect = checker.isFormCorrect();
        assertFalse(formCorrect);
    }

    @Test
    public void testErrorCount() throws Exception {
        List<ASTNodeIssue> errors = checker.getErrors();

        assertFalse(errors.isEmpty());
        assertEquals(1, errors.size());
    }

    @Test
    public void testErrorTypes() throws Exception {
        List<ASTNodeIssue> errors = checker.getErrors();

        List<ASTNodeIssueType> expectedTypes = new ArrayList<>();
        List<ASTNodeIssueType> receivedTypes = new ArrayList<>();
        expectedTypes.add(ASTNodeIssueType.ERROR.DUPLICATE);

        for (ASTNodeIssue error: errors) {
            receivedTypes.add(error.getErrorType());
        }
        // no custom arrayEquals method
        assertEquals(expectedTypes.size(), receivedTypes.size());
        for (ASTNodeIssueType expected : expectedTypes) {
            assertTrue(receivedTypes.contains(expected));
        }
    }

    @Test
    public void testNoWarnings() throws Exception {
        List<ASTNodeIssue> warnings = checker.getWarnings();
        assertTrue(warnings.isEmpty());
    }
}
