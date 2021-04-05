

public class DeleteCommand implements Command{
    Database db ;
    @Override
    public void execute() {
        db.delete();

    }
}
