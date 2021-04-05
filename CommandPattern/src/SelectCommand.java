public class SelectCommand  implements Command{
 Database db;

    public SelectCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute() {
        db.select();
    }
}
