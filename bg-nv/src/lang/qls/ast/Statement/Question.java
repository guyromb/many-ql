package lang.qls.ast.Statement;

/**
 * Created by bore on 02/03/15.
 */
public class Question extends Statement
{
    private String id;

    public Question(String id, int lineNumber)
    {
        super(lineNumber);
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
