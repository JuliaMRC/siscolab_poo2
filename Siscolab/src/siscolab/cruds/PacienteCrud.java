/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.cruds;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import siscolab.modelos.Paciente;
import siscolab.modelos.PlanoSaude;
import static siscolab.modelos.Validacao.convertToDateString;

/**
 *
 * @author jumrcampos
 */
public class PacienteCrud extends PostgresConn implements ICrud<String, String> {

    public PacienteCrud(String connString, String user, String pass) throws SQLException {
        super(connString, user, pass);
    } 
    
    @Override
    public void crudCriar(HasCrud classe) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Paciente cl = (Paciente) classe;
        Statement stmt;
        String data;
        
        if(cl.getDataNascimento()[1]<10){
            data = String.format("%d-0%d-", cl.getDataNascimento()[2], cl.getDataNascimento()[1]);
        }
        else{
            data = String.format("%d-%d-", cl.getDataNascimento()[2], cl.getDataNascimento()[1]);
        }
        
        if(cl.getDataNascimento()[1]<10){
            data += String.format("0%d", cl.getDataNascimento()[0]);
        }
        else{
            data += String.format("%d", cl.getDataNascimento()[0]);
        } 
        
        String sql = String.format("INSERT INTO USUARIO_FISICO (cpf, rg, nome, sobrenome, nascimento, email, senha) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');\n", cl.getCpf(), cl.getRg(), cl.getNome(), cl.getSobrenome(), data, cl.getEmail(), cl.getSenha());
        
        
        this.conectar();
        stmt = this.getConn().createStatement();
        stmt.executeUpdate(sql);
        
        sql = String.format("INSERT INTO PACIENTE (plano_saude_fk, municipio, cpf_fk) VALUES (%d, '%s', '%s')", cl.getPlanoSaude().getNumero(), cl.getMunicipioResidencia(), cl.getCpf());
        System.out.println(sql);
        
        stmt.executeUpdate(sql);
        stmt.close();
        this.fechar();
    }

    @Override
    public HasCrud crudLer(String ch, String val) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Paciente cl = new Paciente();
        PlanoSaudeCrud c = new PlanoSaudeCrud(this.getConnString(), this.getUser(), this.getPass());
        Statement stmt;
        
        String sql = String.format("SELECT * FROM PACIENTE\n");        
        sql += String.format("WHERE '%s' = '%s'", ch, val);
        
        this.conectar();
        stmt = this.getConn().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        
        while (rs.next()) {
            PlanoSaude a = (PlanoSaude) c.crudLer("numero", Integer.toString(rs.getInt("plano_saude_fk")));
            cl.setCpf(rs.getString("cpf_fk"));
            cl.setMunicipioResidencia(rs.getString("municipio"));
            cl.setRg(rs.getString("rg"));
            cl.setNome(rs.getString("nome"));
            cl.setSobrenome(rs.getString("sobrenome"));
            try {
                cl.setEmail(rs.getString("email"));
            } catch (Exception ex) {
                Logger.getLogger(PacienteCrud.class.getName()).log(Level.SEVERE, null, ex);
            }
            cl.setSenha(rs.getString("senha"));
            cl.setPlanoSaude(a);
            //String date = convertToDateString(rs.getDate("validade"));
            //cl.setData(date);
        }
        
        stmt.close();
        this.fechar();
        
        return cl;
    }

    @Override
    public void crudAtualizar(HasCrud classe, String ch, String val) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        Paciente cl = (Paciente) classe;
        
        String sql = "";
        
        sql += String.format("UPDATE USUARIO_FISICO set cpf = %s,\n", cl.getCpf());
        sql += String.format("rg = '%s',\n", cl.getRg());
        sql += String.format("nome = '%s',\n", cl.getNome());
        sql += String.format("sobrenome = '%s',\n", cl.getSobrenome());
        sql += String.format("email = '%s',\n", cl.getEmail());
        sql += String.format("senha = '%s';", cl.getSenha());
        
        sql += String.format("UPDATE PACIENTE set plano_saude_fk = '%d',\n", cl.getPlanoSaude().getNumero());
        sql += String.format("municipio = '%s',\n", cl.getMunicipioResidencia());
        sql += String.format("cpf_fk = '%s'", cl.getCpf());
        
        this.conectar();
        stmt = this.getConn().createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        this.fechar();
    }

    @Override
    public void crudRemover(String chave, String valor) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        
        String sql = String.format("DELETE FROM PACIENTE\nWHERE '%s' = '%s'", chave, valor);
        
        this.conectar();
        stmt = this.getConn().createStatement();
        stmt.executeUpdate(sql);
 
        stmt.close();
        this.fechar();
    }

    @Override
    public List crudListar() throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        ArrayList<Paciente> lst = new ArrayList();
        Statement stmt;
        PlanoSaudeCrud ec = new PlanoSaudeCrud(this.getConnString(), this.getUser(), this.getPass());

        String sql = "SELECT * FROM PACIENTE as m\n";
        sql += "INNER JOIN USUARIO_FISICO as p on (m.cpf_fk = p.cpf)";
        
        this.conectar();
        stmt = this.getConn().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()) {
            PlanoSaude pl = (PlanoSaude) ec.crudLer("numero", Integer.toString(rs.getInt("plano_saude_fk")));
            Paciente cl = new Paciente();
            cl.setCpf(rs.getString("cpf_fk"));
            cl.setPlanoSaude(pl);
            cl.setMunicipioResidencia(rs.getString("municipio"));
            cl.setRg(rs.getString("rg"));
            cl.setNome(rs.getString("nome"));
            cl.setSobrenome(rs.getString("sobrenome"));
            try {
                cl.setEmail(rs.getString("email"));
            } catch (Exception ex) {
                Logger.getLogger(PacienteCrud.class.getName()).log(Level.SEVERE, null, ex);
            }
            cl.setSenha(rs.getString("senha"));
            //String date = convertToDateString(rs.getDate("validade"));
            //cl.setData(date);
        }
        
        stmt.close();
        this.fechar();
        
        return lst;
    }
    
}
