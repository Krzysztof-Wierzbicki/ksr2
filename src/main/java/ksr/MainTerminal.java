package ksr;

import ksr.database.DatabaseSetup;
import ksr.database.Loader;
import ksr.model.Entity;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainTerminal {

    public static void main(String[] args) throws SQLException {
        System.out.println("siema\n" +
                System.getProperty("user.dir"));
        DatabaseSetup.init();
        ArrayList<Entity> entities = Loader.loadDatabaseToModel();
        System.out.println(entities.get(0));
    }
}
