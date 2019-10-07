/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab_db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julia
 */
@Entity
@Table(name = "usuario_fisico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioFisico.findAll", query = "SELECT u FROM UsuarioFisico u"),
    @NamedQuery(name = "UsuarioFisico.findByEmail", query = "SELECT u FROM UsuarioFisico u WHERE u.email = :email"),
    @NamedQuery(name = "UsuarioFisico.findBySenha", query = "SELECT u FROM UsuarioFisico u WHERE u.senha = :senha"),
    @NamedQuery(name = "UsuarioFisico.findByCpf", query = "SELECT u FROM UsuarioFisico u WHERE u.cpf = :cpf"),
    @NamedQuery(name = "UsuarioFisico.findByRg", query = "SELECT u FROM UsuarioFisico u WHERE u.rg = :rg"),
    @NamedQuery(name = "UsuarioFisico.findByNome", query = "SELECT u FROM UsuarioFisico u WHERE u.nome = :nome"),
    @NamedQuery(name = "UsuarioFisico.findBySobrenome", query = "SELECT u FROM UsuarioFisico u WHERE u.sobrenome = :sobrenome"),
    @NamedQuery(name = "UsuarioFisico.findByNascimento", query = "SELECT u FROM UsuarioFisico u WHERE u.nascimento = :nascimento")})
public class UsuarioFisico implements Serializable {

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
    @Size(min = 1, max = 11)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 7)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nome")
    private String nome;
    @Size(max = 30)
    @Column(name = "sobrenome")
    private String sobrenome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;

    public UsuarioFisico() {
    }

    public UsuarioFisico(String cpf) {
        this.cpf = cpf;
    }

    public UsuarioFisico(String cpf, String email, String senha, String nome, Date nascimento) {
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.nascimento = nascimento;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioFisico)) {
            return false;
        }
        UsuarioFisico other = (UsuarioFisico) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "siscolab_db.UsuarioFisico[ cpf=" + cpf + " ]";
    }
    
}
