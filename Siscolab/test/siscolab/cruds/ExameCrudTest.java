/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.cruds;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import siscolab.cruds.ExameCrud;
import siscolab.modelos.Especialidade;
import siscolab.modelos.Exame;
import siscolab.modelos.Medico;
import siscolab.modelos.Paciente;
import siscolab.modelos.PlanoSaude;

/**
 *
 * @author user
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExameCrudTest {
    
    ExameCrud exCrud = new ExameCrud(); 
    PlanoSaudeCrud pCrud = new PlanoSaudeCrud();
    EspecialidadeCrud espCrud = new EspecialidadeCrud();
    MedicoCrud medCrud = new MedicoCrud();
    PacienteCrud pacCrud = new PacienteCrud();
    Exame ex1, ex2, ex3;
    ArrayList lista;
    int[] dat1, dat2, dat3;
    Medico med;
    Paciente pac;
    PlanoSaude plano;
    Especialidade esp;
    

    
    
    @Before
    public void setUp() throws Exception {
        
        //ex1.addObserver(med);
        //ex1.addObserver(pac);
        
        dat1 = new int[3];
        dat1[0] = 21;
        dat1[1] = 5;
        dat1[2] = 2020;
        
        dat2 = new int[3];
        dat2[0] = 21;
        dat2[1] = 5;
        dat2[2] = 2021;
        
        dat3 = new int[3];
        dat3[0] = 21;
        dat3[1] = 5;
        dat3[2] = 1998;
        
        esp = new Especialidade("Ginecologista");
        
        med = new Medico();
        med.setCpf("68009328090");
        med.setRg("1234569");
        med.setNome("Matheus");
        med.setSobrenome("Garcias");
        med.setDataNascimento(dat3);
        med.setEmail("matheus@gmail.com");
        med.setSenha("12345678");
        med.setCrm("12345678");
        med.setEspecialidade(esp);
        med.setMunicipioAtuacao("Serra");
        
        plano = new PlanoSaude(3, dat2, "Unimed");
        
        pac = new Paciente();
        pac.setCpf("45792425051");
        pac.setRg("3452001");
        pac.setNome("Letícia");
        pac.setSobrenome("Teixeira");
        pac.setDataNascimento(dat3);
        pac.setEmail("leticia@gmail.com");
        pac.setSenha("87654321");
        pac.setPlanoSaude(plano);
        pac.setMunicipioResidencia("Serra");
        
        ex1 = new Exame();
        
        ex1.addObserver(med);
        ex1.addObserver(pac);
        
        ex1.setDataExecucao(dat1);
        ex1.setDataPrazo(dat1);
        ex1.setDataRequerimento(dat1);
        ex1.setDataResultado(dat1);
        ex1.setEstado("Em andamento");
        ex1.setMateria("N sei");
        ex1.setMedico(med);
        ex1.setPaciente(pac);
        ex1.setReagente("reag1");
        ex1.setResultado("None");
        ex1.setTipoExame("Sangue");
        
        
        ex2 = new Exame();
        
        ex3 = new Exame();
        ex3.setDataExecucao(dat2);
        ex3.setDataPrazo(dat2);
        ex3.setDataRequerimento(dat2);
        ex3.setDataResultado(dat2);
        ex3.setEstado("Em andamento");
        ex3.setMateria("N sei");
        ex3.setMedico(med);
        ex3.setPaciente(pac);
        ex3.setReagente("reag1");
        ex3.setResultado("None");
        ex3.setTipoExame("Sangue");
        
        lista = new ArrayList();
    }
    
    public ExameCrudTest() {
        
    }

    @Test
    public void test1CrudCriar() throws Exception {
        try {
            pCrud.crudCriar(plano);
            espCrud.crudCriar(esp);
            medCrud.crudCriar(med);
            pacCrud.crudCriar(pac);
            exCrud.crudCriar(ex1);
            
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExameCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao criar obj no banco de dados");
        }
    }
    
    @Test
    public void test2CrudLer() throws Exception {
        try {
            ex2 = (Exame)exCrud.crudLer("nome","Letícia");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExameCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao ler obj do banco de dados");
        }
    }
    
    @Test
    public void test3CrudAtualizar() throws Exception {
        try {
            exCrud.crudAtualizar(ex3,"estado","Pronto");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExameCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao atualizar obj no banco de dados");
        }
    }
    
    @Test
    public void test4CrudRemover() throws Exception {
        try {
            exCrud.crudRemover("cpf_fk","16951782709");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExameCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao remover obj do banco de dados");
        }
    }
    
    @Test
    public void test5CrudListar() throws Exception {
        try {
            lista = (ArrayList)exCrud.crudListar();
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExameCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao listar objs do banco de dados");
        }
    }
}
