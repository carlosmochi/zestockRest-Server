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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_produto_consumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProdutoConsumo.findAll", query = "SELECT t FROM TbProdutoConsumo t")
    , @NamedQuery(name = "TbProdutoConsumo.findByIdProdutoConsumo", query = "SELECT t FROM TbProdutoConsumo t WHERE t.idProdutoConsumo = :idProdutoConsumo")
    , @NamedQuery(name = "TbProdutoConsumo.findByDescricao", query = "SELECT t FROM TbProdutoConsumo t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "TbProdutoConsumo.findByEspecificacao", query = "SELECT t FROM TbProdutoConsumo t WHERE t.especificacao = :especificacao")
    , @NamedQuery(name = "TbProdutoConsumo.findByCodigoBarra", query = "SELECT t FROM TbProdutoConsumo t WHERE t.codigoBarra = :codigoBarra")})
public class TbProdutoConsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto_consumo")
    private Integer idProdutoConsumo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 255)
    @Column(name = "especificacao")
    private String especificacao;
    @Size(max = 32)
    @Column(name = "codigo_barra")
    private String codigoBarra;
    @OneToMany(mappedBy = "idProduto")
    private Collection<TbConsumo> tbConsumoCollection;
    @JoinColumn(name = "id_unidade", referencedColumnName = "id_unidade")
    @ManyToOne
    private TbUnidade idUnidade;

    public TbProdutoConsumo() {
    }

    public TbProdutoConsumo(Integer idProdutoConsumo) {
        this.idProdutoConsumo = idProdutoConsumo;
    }

    public TbProdutoConsumo(Integer idProdutoConsumo, String descricao) {
        this.idProdutoConsumo = idProdutoConsumo;
        this.descricao = descricao;
    }

    public Integer getIdProdutoConsumo() {
        return idProdutoConsumo;
    }

    public void setIdProdutoConsumo(Integer idProdutoConsumo) {
        this.idProdutoConsumo = idProdutoConsumo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    @XmlTransient
    public Collection<TbConsumo> getTbConsumoCollection() {
        return tbConsumoCollection;
    }

    public void setTbConsumoCollection(Collection<TbConsumo> tbConsumoCollection) {
        this.tbConsumoCollection = tbConsumoCollection;
    }

    public TbUnidade getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(TbUnidade idUnidade) {
        this.idUnidade = idUnidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdutoConsumo != null ? idProdutoConsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProdutoConsumo)) {
            return false;
        }
        TbProdutoConsumo other = (TbProdutoConsumo) object;
        if ((this.idProdutoConsumo == null && other.idProdutoConsumo != null) || (this.idProdutoConsumo != null && !this.idProdutoConsumo.equals(other.idProdutoConsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbProdutoConsumo[ idProdutoConsumo=" + idProdutoConsumo + " ]";
    }
    
}
