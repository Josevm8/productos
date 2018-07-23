package parainfo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaDb {

  private String database;

    public Connection getConnection() {
        Connection cn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database,
                    "root", "56789");
        } catch (SQLException e) {
        } catch (Exception e) {
        }

        return cn;
    }

    public ConectaDb() {
        this.database = "prod";
    }

    public ConectaDb(String database) {
        this.database = database;
    }
}

    
/*
    private static ConectaDb conectaDb;
    public Connection cn;
    private ConectaDb(){
    }

    public static ConectaDb getConectaDb() {
        if (conectaDb == null) {
            conectaDb = new ConectaDb();
            System.out.println("1era vez..");
        }
        System.out.println("despues de la 1era vez..");
        return conectaDb;
    }
    
    public Connection getConnection() {
        try {
            if (cn == null) {
                String driver = "com.mysql.jdbc.Driver"; //el driver varia segun la DB que usemos
                String url = "jdbc:mysql://localhost/prod";
                String pwd = "56789";
                String usr = "root";
                Class.forName(driver);
                cn = DriverManager.getConnection(url, usr, pwd);
                System.out.println("Conectionesfull");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    }
*/
    

