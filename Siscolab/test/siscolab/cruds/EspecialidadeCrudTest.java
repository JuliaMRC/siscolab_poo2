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
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import siscolab.modelos.Especialidade;

/**
 *
 * @author user
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EspecialidadeCrudTest {
    EspecialidadeCrud espCrud = new EspecialidadeCrud();
    Especialidade esp1, esp2, esp3;
    ArrayList lista;
    
    
    @Before
    public void setUp() {
        esp1 = new Especialidade("Cardiologista");
        esp2 = new Especialidade();
        esp3 = new Especialidade("Clinico Geral");
        lista = new ArrayList();
    }
    
    public EspecialidadeCrudTest() {
        
    }

    @Test
    public void test1CrudCriar() throws Exception {
        try {
            espCrud.crudCriar(esp1);
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EspecialidadeCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao criar obj no banco de dados");
        }
    }
    
    @Test
    public void test2CrudLer() throws Exception {
        try {
            esp2 = (Especialidade)espCrud.crudLer("especialidade","Cardiologia");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EspecialidadeCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao ler obj do banco de dados");
        }
    }
    
    @Test
    public void test3CrudAtualizar() throws Exception {
        try {
            espCrud.crudAtualizar(esp3,"especialidade","Clinico Geral");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EspecialidadeCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao atualizar obj no banco de dados");
        }
    }
    
    @Test
    public void test4CrudRemover() throws Exception {
        try {
            espCrud.crudRemover("especialidade","Cardiologista");
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EspecialidadeCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao remover obj do banco de dados");
        }
    }
    
    @Test
    public void test5CrudListar() throws Exception {
        try {
            lista = (ArrayList)espCrud.crudListar();
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EspecialidadeCrudTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Falha ao listar objs do banco de dados");
        }
    }

}
