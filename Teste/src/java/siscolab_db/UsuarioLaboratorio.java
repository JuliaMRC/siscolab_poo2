/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab_db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Julia
 */
@Entity
@Table(name = "usuario_laboratorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioLaboratorio.findAll", query = "SELECT u FROM UsuarioLaboratorio u"),
    @NamedQuery(name = "UsuarioLaboratorio.findByEmail", query = "SELECT u FROM UsuarioLaboratorio u WHERE u.email = :email"),
    @NamedQuery(name = "UsuarioLaboratorio.findBySenha", query = "SELECT u FROM UsuarioLaboratorio u WHERE u.senha = :senha"),
    @NamedQuery(name = "UsuarioLaboratorio.findByCnpj", query = "SELECT u FROM UsuarioLaboratorio u WHERE u.cnpj = :cnpj"),
    @NamedQuery(name = "UsuarioLaboratorio.findByNome", query = "SELECT u FROM UsuarioLaboratorio u WHERE u.nome = :nome")})
public class UsuarioLaboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "senha")
    private String senha;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @JoinTable(name = "laboratorios_planos", joinColumns = {
        @JoinColumn(name = "cnpj_fk", referencedColumnName = "cnpj")}, inverseJoinColumns = {
        @JoinColumn(name = "plano_saude", referencedColumnName = "numero")})
    @ManyToMany
    private Collection<PlanoSaude> planoSaudeCollection;

    public UsuarioLaboratorio() {
    }

    public UsuarioLaboratorio(String cnpj) {
        this.cnpj = cnpj;
    }

    public UsuarioLaboratorio(String cnpj, String email, String senha, String nome) {
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<PlanoSaude> getPlanoSaudeCollection() {
        return planoSaudeCollection;
    }

    public void setPlanoSaudeCollection(Collection<PlanoSaude> planoSaudeCollection) {
        this.planoSaudeCollection = planoSaudeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnpj != null ? cnpj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioLaboratorio)) {
            return false;
        }
        UsuarioLaboratorio other = (UsuarioLaboratorio) object;
        if ((this.cnpj == null && other.cnpj != null) || (this.cnpj != null && !this.cnpj.equals(other.cnpj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "siscolab_db.UsuarioLaboratorio[ cnpj=" + cnpj + " ]";
    }
    
}
