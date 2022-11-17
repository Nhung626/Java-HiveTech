package org.example;

import java.sql.*;
import java.util.ArrayList;

public class Classicmodel {
    private static Connection conn;
    private static String DB_Url = "jdbc:mariadb://localhost:3306/classicmodels";
    private static String userName = "root";
    private static String password = "10101234";

//    private static ArrayList<Order> Orders = new ArrayList<Order>();

    public static void main(String[] args) throws SQLException {
        try {
            oppenDatabaseConnection(DB_Url, userName, password);
//          no 2 liệt kê offices có country là USA
            ArrayList<Office> rs = checkCountry();
            System.out.println("No2 Offices có country là USA: ");
            for (int i = 0; i < rs.size(); i++) {
                System.out.println(rs.get(i).toString());
            }
//          no 3 liệt kê tất cả employess, thêm cột alias fullName, bằng firstname + lastname
            ArrayList<Employee> employees = getEmployees();
            System.out.println("No3 Employees: ");
            for (int i = 0; i < employees.size(); i++) {
                System.out.println(employees.get(i).toString());
            }
//          no 6 đến số lượng employees
            countEmployees();
//          no 11 tìm tất cả orders trong tháng 11/2003
            ArrayList<Order> Orders = ordersInMonth();
//          no 12 thêm 2 employee

//          no 13 thêm 2 office
            addOffice("10", "Bac Ninh", "+84 0373695999", "Dong Nguyen", null, "BN", "VietNam", "12345", "VietNam");
//          no 14 sửa addressLine2 = '31 street Red'  co officeCOde =1
//          no 15 update tất cả customer có addressLine là Null bằng addressLine1
//          no 22 thêm 3 products
        } finally {
            closeDatabaseConnection();
        }
    }


    //    no 2 liệt kê offices có country là USA
    private static ArrayList<Office> checkCountry() throws SQLException {
        ArrayList<Office> Offices = new ArrayList<Office>();
        try (PreparedStatement statement = conn.prepareStatement("""
                SELECT *
                FROM offices o
                WHERE o.country = 'USA'
                """)) {
            int i = 0;
            try (ResultSet rs = statement.executeQuery()) {
                boolean empty = true;
                while (rs.next()) {
                    empty = false;
                    Offices.add(new Office(rs.getString("officeCode"),
                            rs.getString("city"),
                            rs.getString("phone"),
                            rs.getString("addressLine1"),
                            rs.getString("addressLine2"),
                            rs.getString("state"),
                            rs.getString("country"),
                            rs.getString("postalCode"),
                            rs.getString("territory")));
                }
                if (empty) {
                    System.out.println("\t no data");
                }
            }
        }
        return Offices;
    }

    //    no 3 liệt kê tất cả employess, thêm cột alias fullName, bằng firstname + lastname
    public static ArrayList<Employee> getEmployees() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try (PreparedStatement statement = conn.prepareStatement("""
                select e.* ,concat(firstname, ' ', lastname) as fullname
                from employees e""")) {
            int i = 0;
            try (ResultSet rs = statement.executeQuery()) {
                boolean empty = true;
                while (rs.next()) {
                    empty = false;
                    employees.add(new Employee(rs.getInt("employeeNumber"),
                            rs.getString("lastName"),
                            rs.getString("firstName"),
                            rs.getString("extension"),
                            rs.getString("email"),
                            rs.getString("officeCode"),
                            rs.getInt("reportsTo"),
                            rs.getString("jobTitle"))
                    );
                }
                if (empty) {
                    System.out.println("\t no data");
                }
            }
        }
        return employees;
    }

    //    no 6 đến số lượng employees
    private static void countEmployees() throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement("""
                select count(*)
                from employees e ;
                """)) {

        }
    }

    //    no 11 tìm tất cả orders trong tháng 11/2003
    private static ArrayList<Order> ordersInMonth() throws SQLException {
        ArrayList<Order> Orders = new ArrayList<Order>();
        try (PreparedStatement statement = conn.prepareStatement("""
                SELECT * FROM orders
                WHERE orders.orderDate BETWEEN "2003-11-01" and"2003-11-30";
                """)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                boolean empty = true;
                while (resultSet.next()) {
                    empty = false;
                    Order order = new Order(
                            resultSet.getInt(1),
                            resultSet.getDate(2).toLocalDate(),
                            resultSet.getDate(3).toLocalDate(),
                            resultSet.getDate(4).toLocalDate(),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7));
                    Orders.add(order);
                }
                if (empty) {
                    System.out.println("No Data");
                }
            }
        }
        return Orders;
    }

    //    no 12 thêm 2 employee
    private static void addEmployee(int employeeNumber, String lastName, String firstName, String extension,
                                    String email, String officeCode, int reportsTo, String jobTitle) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement("""
                INSERT INTO employees(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """)) {
            statement.setInt(1, employeeNumber);
            statement.setString(2, lastName);
            statement.setString(3, firstName);
            statement.setString(4, extension);
            statement.setString(5, email);
            statement.setString(6, officeCode);
            statement.setInt(7, reportsTo);
            statement.setString(8, jobTitle);
            int rowInserted = statement.executeUpdate();
            System.out.println("Row inserted: " + rowInserted);
        }
    }

    //    no 13 thêm 2 office
    private static void addOffice(String officeCode, String city, String phone, String addressLine1, String addressLine2,
                                  String state, String country, String postalCode, String rerritory) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement("""
                INSERT INTO Offices(officeCode, city, phone, addressLine1, addressLine2,
                state, country, postalCode, rerritory)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """)) {
            statement.setString(1, officeCode);
            statement.setString(2, city);
            statement.setString(3, phone);
            statement.setString(4, addressLine1);
            statement.setString(5, addressLine2);
            statement.setString(6, state);
            statement.setString(7, country);
            statement.setString(8, postalCode);
            statement.setString(9, rerritory);
            int rowInserted = statement.executeUpdate();
            System.out.println("Row inserted: " + rowInserted);
        }
    }


    //    no 14 sửa addressLine2 = '31 street Red'  co officeCOde =1
    private static void updateOffice(String officeCode, String address) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement("""
                    UPDATE offices
                    SET addressLine2 = ?
                    WHERE officeCode = ?;
                """)) {
            statement.setString(1, address);
            statement.setString(2, officeCode);
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
    }

    //    no 15 update tất cả customer có addressLine là Null bằng addressLine1
    private static void updateAllCustomer() throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement("""
                UPDATE customers
                SET addressLine2 = addressLine1
                WHERE addressLine2 IS NULL;
                """)) {
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
    }

    //    no 22 thêm 3 products
    public static void addProducts(String productCode, String productName, String productLine, String productScale,
                                   String productVendor, String productDescription, int quantityStock, int buyPrice, int MSRP) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement("""
                INSERT INTO products(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """)) {

            statement.setString(1, productCode);
            statement.setString(2, productName);
            statement.setString(3, productLine);
            statement.setString(4, productScale);
            statement.setString(5, productVendor);
            statement.setString(6, productDescription);
            statement.setInt(7, quantityStock);
            statement.setDouble(8, buyPrice);
            statement.setDouble(9, MSRP);
            int rowInserted = statement.executeUpdate();
            System.out.println("Row inserted: " + rowInserted);

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
