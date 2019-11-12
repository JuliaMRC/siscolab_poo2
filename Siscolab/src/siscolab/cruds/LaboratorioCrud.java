/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.cruds;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import siscolab.modelos.Exame;
import siscolab.modelos.Laboratorio;

/**
 *
 * @author Lavinia
 */
public class LaboratorioCrud implements ICrud<String, String> {
    
    PostgresConnSingleton connSing = PostgresConnSingleton.getInstancia();
    Connection conexao = connSing.getConn();

    public LaboratorioCrud(){}

    @Override
    public void crudCriar(HasCrud classe) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Laboratorio cl = (Laboratorio) classe;
        Statement stmt;
        
        String sql = String.format("INSERT INTO USUARIO_LABORATORIO (cnpj, nome, email, senha) VALUES ('%s', '%s', '%s', '%s');\n", cl.getCnpj(), cl.getNomeFantasia(), cl.getEmail(), cl.getSenha());
        sql += String.format("INSERT INTO LABORATORIO (municipio, cnpj_fk) VALUES ('%s', '%s')", cl.getMunicipioAtendimento(), cl.getCnpj());
        
        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public HasCrud crudLer(String ch, String val) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Laboratorio cl = new Laboratorio();
        Statement stmt;
        
        String sql = String.format("SELECT * FROM LABORATORIO as l\n");
        sql += "INNER JOIN USUARIO_LABORATORIO as u on (l.cnpj_fk = u.cnpj)\n";
        sql += String.format("WHERE '%s' = '%s'", ch, val);
        
        stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
            
        while (rs.next()) {
            cl.setCnpj(rs.getString("cnpj_fk"));
            cl.setMunicipioAtendimento(rs.getString("municipio"));
            cl.setNomeFantasia(rs.getString("nome"));
            try {
                cl.setEmail(rs.getString("email"));
            } catch (Exception ex) {
                Logger.getLogger(LaboratorioCrud.class.getName()).log(Level.SEVERE, null, ex);
            }
            cl.setSenha(rs.getString("senha"));
        }
        
        return cl;
    }

    @Override
    public void crudAtualizar(HasCrud classe, String ch, String val) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        Laboratorio cl = (Laboratorio) classe;
        
        String sql = "";
        
        sql += String.format("UPDATE USUARIO_LABORATORIO set cnpj = '%s',\n", cl.getCnpj());
        sql += String.format("nome = '%s',\n", cl.getNomeFantasia());
        sql += String.format("email = '%s',\n", cl.getEmail());
        sql += String.format("senha = '%s'", cl.getSenha());
        
        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);
        
        sql = "";
        
        sql += String.format("UPDATE LABORATORIO set municipio = '%s',\n", cl.getMunicipioAtendimento());
        sql += String.format("cnpj_fk = '%s'\n", cl.getCnpj());
        
        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);
        
    }

    @Override
    public void crudRemover(String chave, String valor) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        
        String sql = String.format("DELETE FROM LABORATORIO\nWHERE '%s' = '%s'", chave, valor);
        
        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        connSing.fechar();
    }

    @Override
    public List crudListar() throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
