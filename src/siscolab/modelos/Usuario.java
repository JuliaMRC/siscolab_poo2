/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.modelos;

import java.io.Serializable;
import siscolab.cruds.HasCrud;

/**
 *
 * @author Julia
 */
public abstract class Usuario implements Serializable, HasCrud{
    private String email;
    private String senha;
    
    public Usuario(){}
    
    public Usuario(String email, String senha) throws Exception{
        this.setEmail(email);
        this.setSenha(senha);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception{
        try{
            if(Validacao.validaEmail(email)){
                this.email = email;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        } 
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
