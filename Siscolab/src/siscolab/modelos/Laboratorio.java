/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.modelos;

import siscolab.cruds.HasCrud;

/**
 *
 * @author 20171bsi0456
 */
public class Laboratorio extends UsuarioLaboratorio implements HasCrud {
    private String municipioAtendimento;
    private String[] planosAtende; 
    
    public Laboratorio(){}
    
    public Laboratorio(String nomeFantasia, String cnpj, String email, String senha, String municipioAtendimento, String[] planosAtende) throws Exception{
        super(nomeFantasia, cnpj, email, senha);
        this.setMunicipioAtendimento(municipioAtendimento);
        this.setPlanosAtende(planosAtende);
    }

    
    //GETTERS    
    public String getMunicipioAtendimento() {
        return municipioAtendimento;
    }
    
    public String[] getPlanosAtende() {
        return planosAtende;
    }

   
    //SETTERS
    public void setMunicipioAtendimento(String municipioAtendimento) {
        this.municipioAtendimento = municipioAtendimento;
    }

    public void setPlanosAtende(String[] planosAtende) {
        this.planosAtende = planosAtende;
    }

}