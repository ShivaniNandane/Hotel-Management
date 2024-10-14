package Main;

import Db.DatabaseConnection;
import Views.LandingPage;

public class Hotelbooking{
    public static void main(String[] args) {
        DatabaseConnection.createdDatabase();
        DatabaseConnection.getConnection();
        DatabaseConnection.createUsersTable();
        DatabaseConnection.createHotelsTable();
        new LandingPage();
    }
}