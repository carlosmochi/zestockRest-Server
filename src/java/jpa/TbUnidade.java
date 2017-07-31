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
@Table(name = "tb_unidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUnidade.findAll", query = "SELECT t FROM TbUnidade t")
    , @NamedQuery(name = "TbUnidade.findByIdUnidade", query = "SELECT t FROM TbUnidade t WHERE t.idUnidade = :idUnidade")
    , @NamedQuery(name = "TbUnidade.findByUnidade", query = "SELECT t FROM TbUnidade t WHERE t.unidade = :unidade")})
public class TbUnidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidade")
    private Integer idUnidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "unidade")
    private String unidade;
    @OneToMany(mappedBy = "idUnidade")
    private Collection<TbProdutoConsumo> tbProdutoConsumoCollection;

    public TbUnidade() {
    }

    public TbUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public TbUnidade(Integer idUnidade, String unidade) {
        this.idUnidade = idUnidade;
        this.unidade = unidade;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @XmlTransient
    public Collection<TbProdutoConsumo> getTbProdutoConsumoCollection() {
        return tbProdutoConsumoCollection;
    }

    public void setTbProdutoConsumoCollection(Collection<TbProdutoConsumo> tbProdutoConsumoCollection) {
        this.tbProdutoConsumoCollection = tbProdutoConsumoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidade != null ? idUnidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUnidade)) {
            return false;
        }
        TbUnidade other = (TbUnidade) object;
        if ((this.idUnidade == null && other.idUnidade != null) || (this.idUnidade != null && !this.idUnidade.equals(other.idUnidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbUnidade[ idUnidade=" + idUnidade + " ]";
    }
    
}
