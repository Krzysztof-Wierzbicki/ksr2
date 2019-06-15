package ksr;

import ksr.database.DatabaseSetup;
import ksr.database.Loader;
import ksr.model.Entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainTerminal {

    public static void main(String[] args) throws SQLException {
        System.out.println("siema\n" +
                System.getProperty("user.dir"));
        DatabaseSetup.init();
        ArrayList<Entity> entities = Loader.loadDatabaseToModel();

        Set<Object> set = new TreeSet<>();
        for (Entity entity : entities) {
            set.add(entity.earnings);
        }
        System.out.println(set);
    }
}
