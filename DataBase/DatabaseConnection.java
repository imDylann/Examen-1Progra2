/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
 //jdbc (tecnologia) mysql () //127.0.0.1 (direccion) 3306 (puerto) vehiclerentalsystem (nombre BdD)
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/TallerCapacitacion";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
