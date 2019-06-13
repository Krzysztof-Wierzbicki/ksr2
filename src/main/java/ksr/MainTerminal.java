package ksr;

import ksr.database.DatabaseSetup;

import java.sql.SQLException;

public class MainTerminal {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("siema\n" +
                System.getProperty("user.dir") +
                "doing stuff");
        DatabaseSetup.init();
    }
}
