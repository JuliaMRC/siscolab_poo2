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
import java.util.logging.Level;
import java.util.logging.Logger;
import siscolab.modelos.Medico;
import siscolab.modelos.Especialidade;

/**
 *
 * @author PHANTOM
 */
public class MedicoCrud implements ICrud<String, String> {
    
    PostgresConnSingleton connSing = PostgresConnSingleton.getInstancia();
    Connection conexao = connSing.getConn();
    
    public MedicoCrud(){} 
    

    @Override
    public void crudCriar(HasCrud classe) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        Medico cl = (Medico) classe;
        
        String data = utils.converteData(cl.getDataNascimento());
        
        String sql = String.format("INSERT INTO USUARIO_FISICO (cpf, rg, nome, sobrenome, nascimento, email, senha) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');\n", cl.getCpf(), cl.getRg(), cl.getNome(), cl.getSobrenome(), data, cl.getEmail(), cl.getSenha());
        sql += String.format("INSERT INTO MEDICO (crm, especialidade_fk, municipio, cpf_fk) VALUES ('%s', '%s', '%s', '%s')", cl.getCrm(), cl.getEspecialidade().getEspecialidade(), cl.getMunicipioAtuacao(), cl.getCpf());
    
        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public HasCrud crudLer(String chave, String valor) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        Medico cl = new Medico();
        EspecialidadeCrud ec = new EspecialidadeCrud();
        
        String sql = "SELECT *, cpf_fk FROM MEDICO as m\n";
        sql += String.format("INNER JOIN USUARIO_FISICO as u on (m.cpf_fk = u.cpf)\n");
        sql += String.format("WHERE %s = '%s'", chave, valor);
        
        stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        
        while (rs.next()) {
            Especialidade esp = (Especialidade) ec.crudLer("especialidade", rs.getString("especialidade_fk"));
            cl.setCpf(rs.getString("cpf_fk"));
            cl.setCrm(rs.getString("crm"));
            cl.setEspecialidade(esp);
            cl.setMunicipioAtuacao(rs.getString("municipio"));
            cl.setRg(rs.getString("rg"));
            cl.setNome(rs.getString("nome"));
            cl.setSobrenome(rs.getString("sobrenome"));
            try {
                cl.setEmail(rs.getString("email"));
            } catch (Exception ex) {
                Logger.getLogger(MedicoCrud.class.getName()).log(Level.SEVERE, null, ex);
            }
            cl.setSenha(rs.getString("senha"));
            //String date = convertToDateString(rs.getDate("validade"));
            //cl.setData(date);
        }

        
        return cl;
    }

    @Override
    public void crudAtualizar(HasCrud classe, String chave, String valor) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        Medico cl = (Medico) classe;
        
        String sql = "";
        
        sql += String.format("UPDATE USUARIO_FISICO set cpf = '%s',\n", cl.getCpf());
        sql += String.format("rg = '%s',\n", cl.getRg());
        sql += String.format("nome = '%s',\n", cl.getNome());
        sql += String.format("sobrenome = '%s',\n", cl.getSobrenome());
        sql += String.format("email = '%s',\n", cl.getEmail());
        sql += String.format("senha = '%s';", cl.getSenha());
        
        sql += String.format("UPDATE MEDICO set crm = '%s',\n", cl.getCrm());
        sql += String.format("municipio = '%s',\n", cl.getMunicipioAtuacao());
        sql += String.format("especialidade_fk = '%s',\n", cl.getEspecialidade().getEspecialidade());
        sql += String.format("cpf_fk = '%s'", cl.getCpf());
        
        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public void crudRemover(String chave, String valor) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        
        String sql = String.format("DELETE FROM MEDICO\nWHERE '%s' = '%s'", chave, valor);

        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);
 
    }

    @Override
    public List crudListar() throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        ArrayList<Medico> lst = new ArrayList();
        Statement stmt;
        EspecialidadeCrud ec = new EspecialidadeCrud();

        String sql = "SELECT * FROM MEDICO as m\n";
        sql += "INNER JOIN USUARIO_FISICO as p on (m.cpf_fk = p.cpf)";
        
        stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
            Especialidade esp = (Especialidade) ec.crudLer("especialidade", rs.getString("especialidade_fk"));
            Medico cl = new Medico();
            cl.setCpf(rs.getString("cpf"));
            cl.setCrm(rs.getString("crm"));
            cl.setEspecialidade(esp);
            cl.setMunicipioAtuacao(rs.getString("municipio"));
            cl.setRg(rs.getString("rg"));
            cl.setNome(rs.getString("nome"));
            cl.setSobrenome(rs.getString("sobrenome"));
            try {
                cl.setEmail(rs.getString("email"));
            } catch (Exception ex) {
                Logger.getLogger(MedicoCrud.class.getName()).log(Level.SEVERE, null, ex);
            }
            cl.setSenha(rs.getString("senha"));
            //String date = convertToDateString(rs.getDate("validade"));
            //cl.setData(date);
            lst.add(cl);
        }
        
        stmt.close();
        connSing.fechar();
        
        return lst;
    }
}
