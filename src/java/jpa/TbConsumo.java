/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gedsonfaria
 */
@Entity
@Table(name = "tb_consumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbConsumo.findAll", query = "SELECT t FROM TbConsumo t")
    , @NamedQuery(name = "TbConsumo.findByIdConsumo", query = "SELECT t FROM TbConsumo t WHERE t.idConsumo = :idConsumo")
    , @NamedQuery(name = "TbConsumo.findByDtFabricacao", query = "SELECT t FROM TbConsumo t WHERE t.dtFabricacao = :dtFabricacao")
    , @NamedQuery(name = "TbConsumo.findByDtValidade", query = "SELECT t FROM TbConsumo t WHERE t.dtValidade = :dtValidade")
    , @NamedQuery(name = "TbConsumo.findByQuantidadeEmEstoque", query = "SELECT t FROM TbConsumo t WHERE t.quantidadeEmEstoque = :quantidadeEmEstoque")
    , @NamedQuery(name = "TbConsumo.findByDtQuandoRecebeu", query = "SELECT t FROM TbConsumo t WHERE t.dtQuandoRecebeu = :dtQuandoRecebeu")})
public class TbConsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consumo")
    private Integer idConsumo;
    @Column(name = "dt_fabricacao")
    @Temporal(TemporalType.DATE)
    private Date dtFabricacao;
    @Column(name = "dt_validade")
    @Temporal(TemporalType.DATE)
    private Date dtValidade;
    @Column(name = "quantidade_em_estoque")
    private Integer quantidadeEmEstoque;
    @Column(name = "dt_quando_recebeu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtQuandoRecebeu;
    @JoinColumn(name = "id_fabricante", referencedColumnName = "id_fabricante")
    @ManyToOne
    private TbFabricante idFabricante;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto_consumo")
    @ManyToOne
    private TbProdutoConsumo idProduto;
    @JoinColumn(name = "id_quem_recebeu", referencedColumnName = "id_usuario")
    @ManyToOne
    private TbUsuario idQuemRecebeu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbConsumo")
    private Collection<TbHistoricoConsumo> tbHistoricoConsumoCollection;

    public TbConsumo() {
    }

    public TbConsumo(Integer idConsumo) {
        this.idConsumo = idConsumo;
    }

    public Integer getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(Integer idConsumo) {
        this.idConsumo = idConsumo;
    }

    public Date getDtFabricacao() {
        return dtFabricacao;
    }

    public void setDtFabricacao(Date dtFabricacao) {
        this.dtFabricacao = dtFabricacao;
    }

    public Date getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(Date dtValidade) {
        this.dtValidade = dtValidade;
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Date getDtQuandoRecebeu() {
        return dtQuandoRecebeu;
    }

    public void setDtQuandoRecebeu(Date dtQuandoRecebeu) {
        this.dtQuandoRecebeu = dtQuandoRecebeu;
    }

    public TbFabricante getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(TbFabricante idFabricante) {
        this.idFabricante = idFabricante;
    }

    public TbProdutoConsumo getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(TbProdutoConsumo idProduto) {
        this.idProduto = idProduto;
    }

    public TbUsuario getIdQuemRecebeu() {
        return idQuemRecebeu;
    }

    public void setIdQuemRecebeu(TbUsuario idQuemRecebeu) {
        this.idQuemRecebeu = idQuemRecebeu;
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
        hash += (idConsumo != null ? idConsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbConsumo)) {
            return false;
        }
        TbConsumo other = (TbConsumo) object;
        if ((this.idConsumo == null && other.idConsumo != null) || (this.idConsumo != null && !this.idConsumo.equals(other.idConsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbConsumo[ idConsumo=" + idConsumo + " ]";
    }
    
}
