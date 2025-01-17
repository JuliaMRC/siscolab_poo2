/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.modelos;
import java.util.Date;
import siscolab.cruds.HasCrud;
/**
 *
 * @author 20171bsi0456
 */
public class Medico extends UsuarioFisico implements HasCrud, Observer {
    private static final long serialVersionUID = 1L;
    private String crm;
    private Especialidade especialidade;
    private String municipioAtuacao;

    private Medico(Builder builder) {
        this.crm = builder.crm;
        this.especialidade = builder.especialidade;
        this.municipioAtuacao = builder.municipioAtuacao;
    }
    
    public Medico(){}
    
    /*public Medico(String cpf, String rg, String nome, String sobrenome, int[] dataNascimento, String email, String senha, String crm, Especialidade especialidade, String municipioAtuacao) throws Exception {
        super(cpf, rg, nome, sobrenome, dataNascimento, email, senha);
        this.setCrm(crm);
        this.setEspecialidade(especialidade);
        this.setMunicipioAtuacao(municipioAtuacao);
    }*/

    // Getters

    public String getCrm() {
        return this.crm;
    }

    public Especialidade getEspecialidade() {
        return this.especialidade;
    }
    
    public String getMunicipioAtuacao() {
        return this.municipioAtuacao;
    }

    // Setters

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    
    public void setMunicipioAtuacao(String municipioAtuacao) {
        this.municipioAtuacao = municipioAtuacao;
    }

    @Override
    public void update(Observable obs) {
        System.out.println("Médico. O estado do exame foi alterado.");
    }
    
    
    
    public static class Builder{
        private String crm;
        private Especialidade especialidade;
        private String municipioAtuacao;
        
        public Builder(String crm, Especialidade especialidade, String municipioAtuacao) throws Exception {
            this.crm = crm;
            this.especialidade = especialidade;
            this.municipioAtuacao = municipioAtuacao;
        }
        
        public Medico build(){
            return new Medico(this);
        }
    }
    
}