/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author samue
 */
public class DatabaseConnection {
   private static final String URL = "jdbc:mysql://localhost:3306/db_emprestimo_de_ferramentas";
    private static final String USER = "root";
    private static final String PASSWORD = "Unisul@1520";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
    


