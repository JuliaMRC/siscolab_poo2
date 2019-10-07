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
public class Paciente extends UsuarioFisico implements HasCrud{
    private static final long serialVersionUID = 1L;
    private PlanoSaude planoSaude;
    private String municipioResidencia;
    
    public Paciente(){}
    
    private Paciente(Builder builder) {
        this.planoSaude = builder.planoSaude;
        this.municipioResidencia = builder.municipioResidencia;
    }

    //GETTERS
    
    public PlanoSaude getPlanoSaude() {
        return planoSaude;
    }
    
    public String getMunicipioResidencia() {
        return municipioResidencia;
    }

    //SETTERS
    
    public void setPlanoSaude(PlanoSaude planoSaude) {
        this.planoSaude = planoSaude;
    }

    public void setMunicipioResidencia(String municipioResidencia) {
        this.municipioResidencia = municipioResidencia;
    }

    public static class Builder{
        private PlanoSaude planoSaude;
        private String municipioResidencia;
        
        public Builder (PlanoSaude planoSaude, String municipioResidencia){
            this.planoSaude = planoSaude;
            this.municipioResidencia = municipioResidencia;
        }
        
        public Paciente build(){
            return new Paciente(this);
        }
    }
}
