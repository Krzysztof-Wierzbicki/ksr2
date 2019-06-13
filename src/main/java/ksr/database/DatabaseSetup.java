package ksr.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSetup {
    public static void init() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./h2test");
        var setup = "create table if not exists FEMALES(" +
                "id integer primary key," +
                "race varchar(50)," +
                "age integer," +
                "maritalStatus varchar(50)," +
                "numberOfKids integer," +
                "schoolType varchar(50)," +
                "maxGrade integer," +
                "completed boolean," +
                "degree varchar(50)," +
                "pregnancyCount integer," +
                "marriageCount integer," +
                "religion varchar(50)," +
                "everWorked boolean," +
                "workType varchar(50)," +
                "weight integer," +
                "height integer" +
                "earnings integer" +
                ") as select" +
                "id,race,age,marital status,kids no,school type,maxgrade,comleted,degree,pregnancy count,marriage count,religion,ever worked,work type,weight (kg),height (cm),earnings ($)" +
                "from CSVREAD('data.csv');";
        var controller = connection.createStatement();
        controller.execute(setup);
        controller.close();
        connection.close();
    }
}
