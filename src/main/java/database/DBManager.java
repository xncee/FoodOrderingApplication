package database;

public class DBManager {
    private static DBManager instance;

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }

        return instance;
    }

    //+isConnected(): boolean
    //+getConnection(): Connection
}
