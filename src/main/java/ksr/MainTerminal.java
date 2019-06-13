package ksr;

import ksr.database.DatabaseSetup;

import java.sql.SQLException;

public class MainTerminal {

    public static void main(String[] args) throws SQLException {
        System.out.println("witam");
        DatabaseSetup.init();
    }
}
