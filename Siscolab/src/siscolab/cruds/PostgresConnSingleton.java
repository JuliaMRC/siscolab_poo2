/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.cruds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julia
 */
public class PostgresConnSingleton {
    
    private Connection conn = null;
    private String connString = "jdbc:postgresql://motty.db.elephantsql.com/bveutvuk";
    private String user = "bveutvuk";
    private String pass = "Bjtrmmzo1AuDKY4EtdIBE_aAxlr_78he";
    private static PostgresConnSingleton instancia;
    
    private PostgresConnSingleton() throws SQLException{
        if(this.conn != null && !this.conn.isClosed()){
            return;
        }
        this.conn = this.conn = DriverManager.getConnection(this.connString, this.user, this.pass);    
    }

    public static PostgresConnSingleton getInstancia(){
        if (instancia == null){
            try {
                instancia = new PostgresConnSingleton();
            } catch (SQLException ex) {
                Logger.getLogger(PostgresConnSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instancia;
    }

    public Connection getConn() {
        return conn;
    }
    
    public void fechar() throws SQLException {
        this.conn.close();
    }
}
