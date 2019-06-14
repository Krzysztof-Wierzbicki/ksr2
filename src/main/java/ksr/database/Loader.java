package ksr.database;

import ksr.model.Entity;
import ksr.model.EntityDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    public static ArrayList<Entity> loadDatabaseToModel() throws SQLException {
        return loadDbModelToModel(loadDatabaseToDbModel());
    }

    public static ArrayList<EntityDB> loadDatabaseToDbModel() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./ksrdatabase");
        String sql = "select * from FEMALES";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<EntityDB> entityDBs = new ArrayList<>();
        while (resultSet.next()) {
            EntityDB entityDB = new EntityDB(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getInt(7),
                    resultSet.getBoolean(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11),
                    resultSet.getString(12),
                    resultSet.getBoolean(13),
                    resultSet.getString(14),
                    resultSet.getString(15),
                    resultSet.getString(16),
                    resultSet.getString(17)
            );
            entityDBs.add(entityDB);
        }

        return entityDBs;
    }

    public static ArrayList<Entity> loadDbModelToModel(List<EntityDB> entityDBs) {
        ArrayList<Entity> entities = new ArrayList<>();

        for (EntityDB e : entityDBs) {
            entities.add(new Entity(e));
        }

        return entities;
    }
}
