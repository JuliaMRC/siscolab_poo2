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
import siscolab.modelos.Paciente;
import siscolab.modelos.PlanoSaude;

/**
 *
 * @author user
 */
public class PacienteCrudTest {
    PacienteCrud pacCrud;
    Paciente pac1, pac2;
    ArrayList lista;
    PlanoSaude plano;
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
        
        
        plano = new PlanoSaude(1, dat2, "Samp");
        
        pac1 = new Paciente.Builder(plano, "Serra").build();
        pac1.setCpf("34088955030");
        pac1.setRg("3452007");
        pac1.setNome("Letícia");
        pac1.setSobrenome("Teixeira");
        pac1.setDataNascimento(dat1);
        pac1.setEmail("leticia@gmail.com");
        pac1.setSenha("87654321");

        
        pac2 = new Paciente.Builder(plano, "Serra").build();
        pac2.setCpf("16951782709");
        pac2.setRg("1234567");
        pac2.setNome("Matheus");
        pac2.setSobrenome("Garcias");
        pac2.setDataNascimento(dat2);
        pac2.setEmail("matheus@gmail.com");
        pac2.setSenha("12345678");

        
        lista = new ArrayList();
    }
    
    public PacienteCrudTest() {
        
    }

    @Test
    public void testCrudCriar() throws Exception {
        try {
            pacCrud = new PacienteCrud("jdbc:postgresql://motty.db.elephantsql.com/bveutvuk", "bveutvuk", "Bjtrmmzo1AuDKY4EtdIBE_aAxlr_78he");
        } catch (Exception ex) {
            fail("Falha ao conectar ao banco de dados");
            Logger.getLogger(PacienteCrudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            pacCrud.crudCriar(pac1);
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao criar obj no banco de dados");
        }
    }
    
    @Test
    public void testCrudLer() throws Exception {
        try {
            pacCrud = new PacienteCrud("jdbc:postgresql://motty.db.elephantsql.com/bveutvuk", "bveutvuk", "Bjtrmmzo1AuDKY4EtdIBE_aAxlr_78he");
        } catch (Exception ex) {
            fail("Falha ao conectar ao banco de dados");
            Logger.getLogger(PacienteCrudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pac2 = (Paciente)pacCrud.crudLer("nome","Letícia");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao ler obj do banco de dados");
        }
    }
    
    @Test
    public void testCrudAtualizar() throws Exception {
        try {
            pacCrud = new PacienteCrud("jdbc:postgresql://motty.db.elephantsql.com/bveutvuk", "bveutvuk", "Bjtrmmzo1AuDKY4EtdIBE_aAxlr_78he");
        } catch (Exception ex) {
            fail("Falha ao conectar ao banco de dados");
            Logger.getLogger(PacienteCrudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pacCrud.crudAtualizar(pac2,"nome","Maria");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao atualizar obj no banco de dados");
        }
    }
    
    @Test
    public void testCrudRemover() throws Exception {
        try {
            pacCrud = new PacienteCrud("jdbc:postgresql://motty.db.elephantsql.com/bveutvuk", "bveutvuk", "Bjtrmmzo1AuDKY4EtdIBE_aAxlr_78he");
        } catch (Exception ex) {
            fail("Falha ao conectar ao banco de dados");
            Logger.getLogger(PacienteCrudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pacCrud.crudRemover("cpf_fk","16951782709");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao remover obj do banco de dados");
        }
    }
    
    @Test
    public void testCrudListar() throws Exception {
        try {
            pacCrud = new PacienteCrud("jdbc:postgresql://motty.db.elephantsql.com/bveutvuk", "bveutvuk", "Bjtrmmzo1AuDKY4EtdIBE_aAxlr_78he");
        } catch (Exception ex) {
            fail("Falha ao conectar ao banco de dados");
            Logger.getLogger(PacienteCrudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            lista = (ArrayList)pacCrud.crudListar();
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao listar objs do banco de dados");
        }
    }
}