/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.modelos;

/**
 *
 * @author Julia
 */
public class UsuarioLaboratorio extends Usuario{
    private String nomeFantasia;
    private String cnpj;


    public UsuarioLaboratorio(){}
    
    public UsuarioLaboratorio (String nomeFantasia, String cnpj, String email, String senha) throws Exception{
        super(email,senha);
        this.setNomeFantasia(nomeFantasia);
        this.setCnpj(cnpj);
    }

    //GETTERS
    
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    //SETTERS
    
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setCnpj(String cnpj) {
        try{
            if(Validacao.validaCnpj(cnpj)){
                this.cnpj = cnpj;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    

}