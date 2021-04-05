public class InsertCommand  implements Command{
    Database db;

    public InsertCommand(Database db) {
        this.db = db;
    }

    public void execute(){
        db.insert();
    }
}
