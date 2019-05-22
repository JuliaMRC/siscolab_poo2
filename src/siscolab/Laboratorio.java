/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab;

import java.util.Date;

/**
 *
 * @author 20171bsi0456
 */
public class Laboratorio extends UsuarioLaboratorio {
    private int codigo;
    private String municipioAtendimento;
    private String[] planosAtende; 
    
    public Laboratorio(String NomeFantasia, String cnpj, String email, String senha, int codigo, String municipioAtendimento, String[] planosAtende) {
        super(nomeFantasia, cnpj, email, senha);
        this.codigo = codigo;
        this.municipioAtendimento = municipioAtendimento;
        this.planosAtende = planosAtende;
    }

    
    //GETTERS
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getMunicipioAtendimento() {
        return municipioAtendimento;
    }
    
    public String[] getPlanosAtende() {
        return planosAtende;
    }

   
    //SETTERS
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setMunicipioAtendimento(String municipioAtendimento) {
        this.municipioAtendimento = municipioAtendimento;
    }

    public void setPlanosAtende(String[] planosAtende) {
        this.planosAtende = planosAtende;
    }

}
