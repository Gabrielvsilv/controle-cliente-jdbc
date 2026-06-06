package factory;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionFactory {

    public static Connection getConnection(){

        String url = "jdbc:postgresql://localhost:5432/controle_cliente";
        String user = "SEU_USUARIO";
        String password = "SUA_SENHA";


        try { 
            return DriverManager.getConnection(url, user, password);
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }

        }
    }


    

