/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab_db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Julia
 */
@Entity
@Table(name = "plano_saude")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanoSaude.findAll", query = "SELECT p FROM PlanoSaude p"),
    @NamedQuery(name = "PlanoSaude.findByNumero", query = "SELECT p FROM PlanoSaude p WHERE p.numero = :numero"),
    @NamedQuery(name = "PlanoSaude.findByValidade", query = "SELECT p FROM PlanoSaude p WHERE p.validade = :validade"),
    @NamedQuery(name = "PlanoSaude.findByEmpresa", query = "SELECT p FROM PlanoSaude p WHERE p.empresa = :empresa")})
public class PlanoSaude implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "validade")
    @Temporal(TemporalType.DATE)
    private Date validade;
    @Size(max = 50)
    @Column(name = "empresa")
    private String empresa;
    @ManyToMany(mappedBy = "planoSaudeCollection")
    private Collection<UsuarioLaboratorio> usuarioLaboratorioCollection;

    public PlanoSaude() {
    }

    public PlanoSaude(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @XmlTransient
    public Collection<UsuarioLaboratorio> getUsuarioLaboratorioCollection() {
        return usuarioLaboratorioCollection;
    }

    public void setUsuarioLaboratorioCollection(Collection<UsuarioLaboratorio> usuarioLaboratorioCollection) {
        this.usuarioLaboratorioCollection = usuarioLaboratorioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanoSaude)) {
            return false;
        }
        PlanoSaude other = (PlanoSaude) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "siscolab_db.PlanoSaude[ numero=" + numero + " ]";
    }
    
}
