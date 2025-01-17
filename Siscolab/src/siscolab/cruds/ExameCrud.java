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
import siscolab.modelos.Exame;
import siscolab.modelos.Medico;
import siscolab.modelos.Paciente;
import static siscolab.modelos.Validacao.convertToDateString;
import static siscolab.modelos.Validacao.splitDate;

/**
 *
 * @author Lavinia
 */
public class ExameCrud implements ICrud<String, String> {
    
    PostgresConnSingleton connSing = PostgresConnSingleton.getInstancia();
    Connection conexao = connSing.getConn();

    public ExameCrud(){}

    @Override
    public void crudCriar(HasCrud classe) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        Exame cl = (Exame) classe;
        
        String dPrazo = utils.converteData(cl.getDataPrazo());        
        String dReq = utils.converteData(cl.getDataRequerimento());
        String dExec = utils.converteData(cl.getDataExecucao());
        String dResult = utils.converteData(cl.getDataResultado());
        
    
        String sql = String.format("INSERT INTO EXAME (tipo, data_prazo, materia, paciente_fk, medico_fk, reagente, resultado, data_requerimento, data_execucao, data_resultado, estado) "
                + "                 VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
                                    cl.getTipoExame(), dPrazo, cl.getMateria(), cl.getPaciente().getCpf(), cl.getMedico().getCpf(), cl.getReagente(), cl.getResultado(), dReq, dExec, dResult, cl.getEstado());
           
        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public HasCrud crudLer(String chave, String valor) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        Exame cl = new Exame();
        PacienteCrud pc = new PacienteCrud();
        MedicoCrud mc = new MedicoCrud();
        
        String sql = "SELECT * FROM MEDICO\n";
        sql += "WHERE '%s' = '%s'";
        
        sql = String.format(sql, chave, valor);
        
        stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        //String tipoExame, int[] dataPrazo, String materia, Paciente paciente, Medico medico, String reagente, String resultado, int[] dataRequerimento, int[] dataExecucao, int[] dataResultado, String estado
        while (rs.next()) {
            Medico m = (Medico)mc.crudLer("cpf_fk", rs.getString("medico_fk"));
            Paciente p = (Paciente)pc.crudLer("cpf_fk", rs.getString("paciente_fk"));
            cl.setTipoExame(rs.getString("tipo"));
            cl.setMateria(rs.getString("materia"));
            cl.setMedico(m);
            cl.setPaciente(p);
            cl.setReagente(rs.getString("reagente"));
            cl.setResultado(rs.getString("resultado"));
            cl.setEstado(rs.getString("resultado"));
            
            String dPrazo,dReq,dExec,dResult;
            dPrazo = convertToDateString(rs.getDate("data_prazo"));
            dReq = convertToDateString(rs.getDate("data_requerimento"));
            dExec = convertToDateString(rs.getDate("data_execucao"));
            dResult = convertToDateString(rs.getDate("data_resultado"));
            int[] dP = splitDate(dPrazo);
            int[] dRq = splitDate(dReq);
            int[] dE = splitDate(dExec);
            int[] dRe = splitDate(dResult);
            
            cl.setDataExecucao(dE);
            cl.setDataPrazo(dP);
            cl.setDataRequerimento(dRq);
            cl.setDataResultado(dRe);
        }
        
        return cl;
    }

    @Override
    public void crudAtualizar(HasCrud classe, String ch, String val) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        Exame cl = (Exame) classe;
        
        String sql = "";
        //String tipoExame, int[] dataPrazo, String materia, Paciente paciente, Medico medico, String reagente, String resultado, Laboratorio laboratorio, int[] dataRequerimento, int[] dataExecucao, int[] dataResultado, String estado
        sql += "UPDATE EXAME set tipo = '%s',\n";
        sql += "materia = '%s',\n";
        sql += "reagente = '%s',\n";
        sql += "resultado = '%s',\n";
        sql += "estado = '%s'\n";
        sql += "WHERE '%s' = '%s'";
        
        sql = String.format(sql, cl.getTipoExame(), cl.getMateria(), cl.getReagente(), cl.getResultado(), cl.getEstado(), ch, val);
        
        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public void crudRemover(String chave, String valor) throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        Statement stmt;
        
        String sql = String.format("DELETE FROM EXAME\nWHERE '%s' = '%s'", chave, valor);

        stmt = conexao.createStatement();
        stmt.executeUpdate(sql);

    }

    @Override
    public List crudListar() throws UnsupportedOperationException, SQLException, ClassNotFoundException {
        ArrayList<Exame> lst = new ArrayList();
        Statement stmt;
        
        PacienteCrud pc = new PacienteCrud();
        MedicoCrud mc = new MedicoCrud();

        String sql = "SELECT * FROM MEDICO\n";
        

        stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()) {
            Exame cl = new Exame();
            Medico m = (Medico)mc.crudLer("cpf_fk", rs.getString("cpf_fk"));
            Paciente p = (Paciente)pc.crudLer("cpf_fk", rs.getString("cpf_fk"));
            cl.setTipoExame(rs.getString("tipo"));
            cl.setMateria(rs.getString("materia"));
            cl.setMedico(m);
            cl.setPaciente(p);
            cl.setReagente(rs.getString("reagente"));
            cl.setResultado(rs.getString("resultado"));
            cl.setEstado(rs.getString("resultado"));
            
            String dPrazo,dReq,dExec,dResult;
            dPrazo = convertToDateString(rs.getDate("data_prazo"));
            dReq = convertToDateString(rs.getDate("data_requerimento"));
            dExec = convertToDateString(rs.getDate("data_execucao"));
            dResult = convertToDateString(rs.getDate("data_resultado"));
            int[] dP = splitDate(dPrazo);
            int[] dRq = splitDate(dReq);
            int[] dE = splitDate(dExec);
            int[] dRe = splitDate(dResult);
            
            cl.setDataExecucao(dE);
            cl.setDataPrazo(dP);
            cl.setDataRequerimento(dRq);
            cl.setDataResultado(dRe);
            
            lst.add(cl);
        }
        
        stmt.close();
        connSing.fechar();
        
        return lst;
    }
       
}
