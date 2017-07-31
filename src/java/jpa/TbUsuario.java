/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gedsonfaria
 */
@Entity
@Table(name = "tb_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t")
    , @NamedQuery(name = "TbUsuario.findByIdUsuario", query = "SELECT t FROM TbUsuario t WHERE t.idUsuario = :idUsuario")
    , @NamedQuery(name = "TbUsuario.findByNomeUsuario", query = "SELECT t FROM TbUsuario t WHERE t.nomeUsuario = :nomeUsuario")
    , @NamedQuery(name = "TbUsuario.findByRegistroFuncional", query = "SELECT t FROM TbUsuario t WHERE t.registroFuncional = :registroFuncional")
    , @NamedQuery(name = "TbUsuario.findByEmail", query = "SELECT t FROM TbUsuario t WHERE t.email = :email")
    , @NamedQuery(name = "TbUsuario.findBySenha", query = "SELECT t FROM TbUsuario t WHERE t.senha = :senha")
    , @NamedQuery(name = "TbUsuario.findByTheme", query = "SELECT t FROM TbUsuario t WHERE t.theme = :theme")})
public class TbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome_usuario")
    private String nomeUsuario;
    @Column(name = "registro_funcional")
    private Integer registroFuncional;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "senha")
    private String senha;
    @Size(max = 40)
    @Column(name = "theme")
    private String theme;
    @OneToMany(mappedBy = "idCoResponsavel")
    private Collection<TbBemPermanente> tbBemPermanenteCollection;
    @OneToMany(mappedBy = "idQuemRecebeu")
    private Collection<TbConsumo> tbConsumoCollection;
    @OneToMany(mappedBy = "idResponsavel")
    private Collection<TbFasesEmprestimoBemPermanente> tbFasesEmprestimoBemPermanenteCollection;
    @OneToMany(mappedBy = "idSolicitante")
    private Collection<TbEmprestimoBemPermanente> tbEmprestimoBemPermanenteCollection;
    @OneToMany(mappedBy = "idQuemRetirou")
    private Collection<TbHistoricoConsumo> tbHistoricoConsumoCollection;

    public TbUsuario() {
    }

    public TbUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TbUsuario(Integer idUsuario, String nomeUsuario, String email, String senha) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Integer getRegistroFuncional() {
        return registroFuncional;
    }

    public void setRegistroFuncional(Integer registroFuncional) {
        this.registroFuncional = registroFuncional;
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @XmlTransient
    public Collection<TbBemPermanente> getTbBemPermanenteCollection() {
        return tbBemPermanenteCollection;
    }

    public void setTbBemPermanenteCollection(Collection<TbBemPermanente> tbBemPermanenteCollection) {
        this.tbBemPermanenteCollection = tbBemPermanenteCollection;
    }

    @XmlTransient
    public Collection<TbConsumo> getTbConsumoCollection() {
        return tbConsumoCollection;
    }

    public void setTbConsumoCollection(Collection<TbConsumo> tbConsumoCollection) {
        this.tbConsumoCollection = tbConsumoCollection;
    }

    @XmlTransient
    public Collection<TbFasesEmprestimoBemPermanente> getTbFasesEmprestimoBemPermanenteCollection() {
        return tbFasesEmprestimoBemPermanenteCollection;
    }

    public void setTbFasesEmprestimoBemPermanenteCollection(Collection<TbFasesEmprestimoBemPermanente> tbFasesEmprestimoBemPermanenteCollection) {
        this.tbFasesEmprestimoBemPermanenteCollection = tbFasesEmprestimoBemPermanenteCollection;
    }

    @XmlTransient
    public Collection<TbEmprestimoBemPermanente> getTbEmprestimoBemPermanenteCollection() {
        return tbEmprestimoBemPermanenteCollection;
    }

    public void setTbEmprestimoBemPermanenteCollection(Collection<TbEmprestimoBemPermanente> tbEmprestimoBemPermanenteCollection) {
        this.tbEmprestimoBemPermanenteCollection = tbEmprestimoBemPermanenteCollection;
    }

    @XmlTransient
    public Collection<TbHistoricoConsumo> getTbHistoricoConsumoCollection() {
        return tbHistoricoConsumoCollection;
    }

    public void setTbHistoricoConsumoCollection(Collection<TbHistoricoConsumo> tbHistoricoConsumoCollection) {
        this.tbHistoricoConsumoCollection = tbHistoricoConsumoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuario)) {
            return false;
        }
        TbUsuario other = (TbUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
