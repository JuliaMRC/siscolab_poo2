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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import siscolab.cruds.MedicoCrud;
import siscolab.modelos.Especialidade;
import siscolab.modelos.Medico;

/**
 *
 * @author user
 */
public class MedicoCrudTest {
    
    MedicoCrud medCrud;
    Medico med1, med2;
    Especialidade esp1, esp2;
    ArrayList lista;
    int[] dat1, dat2;
    
    
    @Before
    public void setUp() throws Exception {
        dat1 = new int[3];
        dat1[0] = 22;
        dat1[1] = 8;
        dat1[2] = 1999;
        
        dat2 = new int[3];
        dat2[0] = 21;
        dat2[1] = 5;
        dat2[2] = 2020;
        
        
        esp1 = new Especialidade("Cardiologista");
        
        med1 = new Medico.Builder("87654351", esp1, "Serra").build();
        med1.setCpf("39589013015");
        med1.setRg("3452001");
        med1.setNome("Letícia");
        med1.setSobrenome("Teixeira");
        med1.setDataNascimento(dat1);
        med1.setEmail("leticia@gmail.com");
        med1.setSenha("87654321");
        /*med1.setCrm("87654321");
        med1.setEspecialidade(esp);
        med1.setMunicipioAtuacao("Serra");*/
        
        
        esp2 = new Especialidade("Pediatra");
                
        med2 = new Medico.Builder("12345678", esp2, "Serra").build();
        
        med2.setCpf("16815006042");
        med2.setRg("1235567");
        med2.setNome("Matheus");
        med2.setSobrenome("Garcias");
        med2.setDataNascimento(dat2);
        med2.setEmail("matheus@gmail.com");
        med2.setSenha("12345678");
        /*med2.setCrm("12345678");
        med2.setEspecialidade(esp);
        med2.setMunicipioAtuacao("Serra");*/
        
        lista = new ArrayList();
    }
    
    public MedicoCrudTest() {
        
    }

    @Test
    public void testCrudCriar() throws Exception {
        try {
            medCrud = new MedicoCrud("jdbc:postgresql://motty.db.elephantsql.com/bveutvuk", "bveutvuk", "Bjtrmmzo1AuDKY4EtdIBE_aAxlr_78he");
        } catch (Exception ex) {
            fail("Falha ao conectar ao banco de dados");
            Logger.getLogger(MedicoCrudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            medCrud.crudCriar(med1);
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao criar obj no banco de dados");
        }
    }
    
    @Test
    public void testCrudLer() throws Exception {
        try {
            medCrud = new MedicoCrud("jdbc:postgresql://motty.db.elephantsql.com/bveutvuk", "bveutvuk", "Bjtrmmzo1AuDKY4EtdIBE_aAxlr_78he");
        } catch (Exception ex) {
            fail("Falha ao conectar ao banco de dados");
            Logger.getLogger(MedicoCrudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            med2 = (Medico)medCrud.crudLer("nome","Letícia");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao ler obj do banco de dados");
        }
    }
    
    @Test
    public void testCrudAtualizar() throws Exception {
        try {
            medCrud = new MedicoCrud("jdbc:postgresql://motty.db.elephantsql.com/bveutvuk", "bveutvuk", "Bjtrmmzo1AuDKY4EtdIBE_aAxlr_78he");
        } catch (Exception ex) {
            fail("Falha ao conectar ao banco de dados");
            Logger.getLogger(MedicoCrudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            medCrud.crudAtualizar(med2,"nome","Júlia");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao atualizar obj no banco de dados");
        }
    }
    
    @Test
    public void testCrudRemover() throws Exception {
        try {
            medCrud = new MedicoCrud("jdbc:postgresql://motty.db.elephantsql.com/bveutvuk", "bveutvuk", "Bjtrmmzo1AuDKY4EtdIBE_aAxlr_78he");
        } catch (Exception ex) {
            fail("Falha ao conectar ao banco de dados");
            Logger.getLogger(MedicoCrudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            medCrud.crudRemover("cpf_fk","35092041072");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao remover obj do banco de dados");
        }
    }
    
    @Test
    public void testCrudListar() throws Exception {
        try {
            medCrud = new MedicoCrud("jdbc:postgresql://motty.db.elephantsql.com/bveutvuk", "bveutvuk", "Bjtrmmzo1AuDKY4EtdIBE_aAxlr_78he");
        } catch (Exception ex) {
            fail("Falha ao conectar ao banco de dados");
            Logger.getLogger(MedicoCrudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            lista = (ArrayList)medCrud.crudListar();
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao listar objs do banco de dados");
        }
    }
    
}
