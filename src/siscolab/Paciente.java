/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab;

/**
 *
 * @author 20171bsi0456
 */
public class Paciente extends Usuario {
    private String planoSaude;
    private String municipioResidencia;
    
    public Paciente(String cpf, String rg, String nome, String sobrenome, String dataNascimento, String email, String senha, String planoSaude, String municipioResidencia) {
        super(cpf, rg, nome, sobrenome, dataNascimento, email, senha);
        this.planoSaude = planoSaude;
        this.municipioResidencia = municipioResidencia;
    }

}