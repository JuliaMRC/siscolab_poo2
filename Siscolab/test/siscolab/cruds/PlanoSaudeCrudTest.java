/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.cruds;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import siscolab.modelos.PlanoSaude;

/**
 *
 * @author Julia
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlanoSaudeCrudTest {
    PlanoSaudeCrud planoSaudeCrud = new PlanoSaudeCrud();
    int[] data, data2;
    PlanoSaude planoSaude, planoSaude2;
    
    @Before
    public void setUp() throws Exception{

        data = new int[3];
        data[0] = 2;
        data[1] = 2;
        data[2] = 2019;
        
        
        data2 = new int[3];
        data2[0] = 11;
        data2[1] = 12;
        data2[2] = 2021;
        
        planoSaude = new PlanoSaude(1, data, "Unimed");
        
        planoSaude2 = new PlanoSaude(2, data2, "Samp");
    }
    
    public PlanoSaudeCrudTest() {
        
    }


    @Test
    public void test1CrudCriar() throws Exception {
        try {
            planoSaudeCrud.crudCriar(planoSaude);

        } catch (Exception ex) {
            fail("Erro no banco etc");
        }
        

    }

    @Test
    public void test2CrudLer() throws Exception {
        PlanoSaude planoSaudeLer = new PlanoSaude();
        try {
            planoSaudeLer = (PlanoSaude) planoSaudeCrud.crudLer("empresa", "Unimed");
        } catch (Exception ex) {
            fail("erro ao tentar comunicação com banco");
        }
    }

    @Test
    public void test3CrudAtualizar() throws Exception {
        try {
            planoSaudeCrud.crudAtualizar(planoSaude2, "empresa", "Cartao de todos");
        } catch (Exception ex) {
            fail("Erro no banco etc");
        }
    }

    @Test
    public void test4CrudRemover() throws Exception {
        try {
            planoSaudeCrud.crudRemover("numero", "1");
        } catch (Exception ex) {
            fail("Erro no banco ao tentar remover");
        }

    }
    
    @Test
    public void test5CrudListar() throws Exception {
        List<PlanoSaude> lst = new ArrayList();
        try {
            lst = planoSaudeCrud.crudListar();
            System.out.println(lst);

        } catch (Exception ex) {
            fail("Erro ao listar planos de Saude");     
        }

    }

}
