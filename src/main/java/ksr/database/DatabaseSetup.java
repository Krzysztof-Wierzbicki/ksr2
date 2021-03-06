package ksr.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

    public static String CONNECTION_STRING = "jdbc:h2:./ksrdatabase";

    public static void init() throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        String setup = "create table if not exists FEMALES(" +
                "id integer primary key," +
                "race varchar(50)," +
                "age integer," +
                "maritalStatus varchar(50)," +
                "numberOfKids integer," +
                //"schoolType varchar(50)," +
                //"maxGrade integer," +
                //"completed boolean," +
                "yearsOfEducation integer," +
                "degree varchar(50)," +
                "pregnancyCount varchar(50)," +
                "marriageCount varchar(50)," +
                "religion varchar(50)," +
                "everWorked boolean," +
                "workType varchar(50)," +
                "weight varchar(50)," +
                "height varchar(50)," +
                "earnings varchar(50)" +
                ") as select " +
                "id,race,age,marital_status,kids_no,years_of_education,degree,pregnancy_count,marriage_count,religion,ever_worked,work_type,weight,height,earnings" +
                " from CSVREAD('./src/main/resources/data.csv');";
        Statement statement = connection.createStatement();
        statement.execute(setup);
        statement.close();
        connection.close();
    }
}
