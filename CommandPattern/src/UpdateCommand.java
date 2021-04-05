public class UpdateCommand implements Command {
    Database db;

    public UpdateCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute() {
        db.upDate();

    }
}
