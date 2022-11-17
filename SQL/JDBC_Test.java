package org.example;

import java.sql.*;

public class JDBC_Test {
    private static Connection conn;
    private static String DB_Url = "jdbc:mariadb://localhost:3306/jdbc_demo";
    private static String userName = "root";
    private static String password = "10101234";

    public static void main(String[] args) throws SQLException {
        try {
            oppenDatabaseConnection(DB_Url, userName, password);
            readData();
            deleteData("%");
            readData();
            creatData("Java", 10);
            creatData("JavaScrip", 9);
            creatData("C++", 8);
            readData();
            updateData("C++", 7);
            readData();
            deleteData("C++");
            readData();
        } finally {
            closeDatabaseConnection();
        }
    }

    private static void updateData(String name, int newRating) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement("""
                UPDATE programming_language
                SET rating = ?
                WHERE name =?
                """)) {
            statement.setInt(1, newRating);
            statement.setString(2, name);
            int rowUpdate = statement.executeUpdate();
            System.out.println("Row update: " + rowUpdate);
        }

    }

    private static void deleteData(String nameDel) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement("""
                    DELETE FROM programming_language
                    WHERE name LIKE ?
                """)) {
            statement.setString(1, nameDel);
            int rowDelete = statement.executeUpdate();
            System.out.println("Row deleted: " + rowDelete);
        }
    }

    private static void creatData(String name, int rating) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement("""
                INSERT INTO programming_language(name, rating)
                VALUES (?, ?)
                """)) {
            statement.setString(1, name);
            statement.setInt(2, rating);
            int rowInsert = statement.executeUpdate();
            System.out.println("Row inserted: " + rowInsert);
        }
    }


    private static void readData() throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement("""
                SELECT name, rating
                FROM programming_language
                ORDER BY rating DESC 
                """)) {
            try (ResultSet rs = statement.executeQuery()) {
                boolean empty = true;
                while (rs.next()) {
                    empty = false;
                    String name = rs.getString("name");
                    int rating = rs.getInt("rating");
                    System.out.println("\t " + name + ": " + rating);
                }
                if (empty) {
                    System.out.println("\t no data");
                }
            }
        }
    }

    private static void oppenDatabaseConnection(String db_url, String userName, String password) throws SQLException {
        System.out.println("Connecting to the database ...");
        conn = DriverManager.getConnection(DB_Url, userName, password);
        System.out.println("Connection valid: " + conn.isValid(5));
    }

    private static void closeDatabaseConnection() throws SQLException {
        System.out.println("Closing database connection...");
        conn.close();
        System.out.println("Connection valid: " + conn.isValid(5));
    }
}
