/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.database;

/**
 *
 * @author Usuario
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = System.getenv("DB_PASSWORD");
 
    
    public static Connection conectar(){
      try{
       return
               DriverManager.getConnection(URL, USER, PASSWORD);
      }catch (Exception e){
          System.out.println("Erro na conexâo "+ e.getMessage());
          return null;
          
      }
    }
}
