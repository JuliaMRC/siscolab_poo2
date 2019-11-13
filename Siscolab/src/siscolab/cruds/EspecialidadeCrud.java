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
import java.util.ArrayList;
import java.util.List;
import siscolab.modelos.Especialidade;
/**
 *
 * @author phantom
 */
public class EspecialidadeCrud implements ICrud<String, String> {
    
    PostgresConnSingleton connSing = PostgresConnSingleton.getInstancia();
    Connection conexao = connSing.getConn();
    
    public EspecialidadeCrud(){} 

    @Override
    public void crudCriar(HasCrud classe) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        Especialidade cl = (Especialidade) classe;
        
        String sql = String.format("INSERT INTO ESPECIALIDADE (especialidade) VALUES ('%s')", cl.getEspecialidade());

        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public HasCrud crudLer(String chave, String valor) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        Especialidade cl;
        
        String sql = String.format("SELECT * FROM ESPECIALIDADE\nWHERE %s = '%s'", chave, valor);

        stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        cl = new Especialidade();
        
        while(rs.next()) {
            cl.setEspecialidade(rs.getString("especialidade"));
        }
        
        return cl;
    }

    @Override
    public void crudAtualizar(HasCrud classe, String chave, String valor) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        Especialidade cl = (Especialidade) classe;
        
        String sql = String.format("UPDATE ESPECIALIDADE set especialidade = '%s'\nWHERE %s = '%s'", cl.getEspecialidade(), chave, valor);

        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public void crudRemover(String chave, String valor) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        
        String sql = String.format("DELETE FROM ESPECIALIDADE\nWHERE %s = '%s'", chave, valor);

        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);

    }

    @Override
    public List crudListar() throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        ArrayList<Especialidade> lst = new ArrayList();
        Statement stmt;
        
        String sql = "SELECT * FROM ESPECIALIDADE";

        stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
            Especialidade cl = new Especialidade();
            cl.setEspecialidade(rs.getString("especialidade"));
            lst.add(cl);
        }
        
        stmt.close();
        connSing.fechar();
        
        return lst;
    }
}
