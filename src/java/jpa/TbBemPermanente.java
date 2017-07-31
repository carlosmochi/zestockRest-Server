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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gedsonfaria
 */
@Entity
@Table(name = "tb_bem_permanente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbBemPermanente.findAll", query = "SELECT t FROM TbBemPermanente t")
    , @NamedQuery(name = "TbBemPermanente.findByIdBemPermanente", query = "SELECT t FROM TbBemPermanente t WHERE t.idBemPermanente = :idBemPermanente")
    , @NamedQuery(name = "TbBemPermanente.findByDescricaoBem", query = "SELECT t FROM TbBemPermanente t WHERE t.descricaoBem = :descricaoBem")
    , @NamedQuery(name = "TbBemPermanente.findByDtEntrada", query = "SELECT t FROM TbBemPermanente t WHERE t.dtEntrada = :dtEntrada")
    , @NamedQuery(name = "TbBemPermanente.findByObservacao", query = "SELECT t FROM TbBemPermanente t WHERE t.observacao = :observacao")
    , @NamedQuery(name = "TbBemPermanente.findByNumPatrimonio", query = "SELECT t FROM TbBemPermanente t WHERE t.numPatrimonio = :numPatrimonio")})
public class TbBemPermanente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bem_permanente")
    private Integer idBemPermanente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao_bem")
    private String descricaoBem;
    @Column(name = "dt_entrada")
    @Temporal(TemporalType.DATE)
    private Date dtEntrada;
    @Size(max = 255)
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "num_patrimonio")
    private Integer numPatrimonio;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado_bem_permanente")
    @ManyToOne
    private TbEstadoBemPermanente idEstado;
    @JoinColumn(name = "sala_alocacao", referencedColumnName = "id_loca_lotacao")
    @ManyToOne
    private TbLocaisLotacaoBemPermanente salaAlocacao;
    @JoinColumn(name = "id_co_responsavel", referencedColumnName = "id_usuario")
    @ManyToOne
    private TbUsuario idCoResponsavel;
    @OneToMany(mappedBy = "idBemPermanente")
    private Collection<TbEmprestimoBemPermanente> tbEmprestimoBemPermanenteCollection;

    public TbBemPermanente() {
    }

    public TbBemPermanente(Integer idBemPermanente) {
        this.idBemPermanente = idBemPermanente;
    }

    public TbBemPermanente(Integer idBemPermanente, String descricaoBem) {
        this.idBemPermanente = idBemPermanente;
        this.descricaoBem = descricaoBem;
    }

    public Integer getIdBemPermanente() {
        return idBemPermanente;
    }

    public void setIdBemPermanente(Integer idBemPermanente) {
        this.idBemPermanente = idBemPermanente;
    }

    public String getDescricaoBem() {
        return descricaoBem;
    }

    public void setDescricaoBem(String descricaoBem) {
        this.descricaoBem = descricaoBem;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getNumPatrimonio() {
        return numPatrimonio;
    }

    public void setNumPatrimonio(Integer numPatrimonio) {
        this.numPatrimonio = numPatrimonio;
    }

    public TbEstadoBemPermanente getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TbEstadoBemPermanente idEstado) {
        this.idEstado = idEstado;
    }

    public TbLocaisLotacaoBemPermanente getSalaAlocacao() {
        return salaAlocacao;
    }

    public void setSalaAlocacao(TbLocaisLotacaoBemPermanente salaAlocacao) {
        this.salaAlocacao = salaAlocacao;
    }

    public TbUsuario getIdCoResponsavel() {
        return idCoResponsavel;
    }

    public void setIdCoResponsavel(TbUsuario idCoResponsavel) {
        this.idCoResponsavel = idCoResponsavel;
    }

    @XmlTransient
    public Collection<TbEmprestimoBemPermanente> getTbEmprestimoBemPermanenteCollection() {
        return tbEmprestimoBemPermanenteCollection;
    }

    public void setTbEmprestimoBemPermanenteCollection(Collection<TbEmprestimoBemPermanente> tbEmprestimoBemPermanenteCollection) {
        this.tbEmprestimoBemPermanenteCollection = tbEmprestimoBemPermanenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBemPermanente != null ? idBemPermanente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbBemPermanente)) {
            return false;
        }
        TbBemPermanente other = (TbBemPermanente) object;
        if ((this.idBemPermanente == null && other.idBemPermanente != null) || (this.idBemPermanente != null && !this.idBemPermanente.equals(other.idBemPermanente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbBemPermanente[ idBemPermanente=" + idBemPermanente + " ]";
    }
    
}
