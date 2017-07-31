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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gedsonfaria
 */
@Entity
@Table(name = "tb_emprestimo_bem_permanente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEmprestimoBemPermanente.findAll", query = "SELECT t FROM TbEmprestimoBemPermanente t")
    , @NamedQuery(name = "TbEmprestimoBemPermanente.findByIdPedidoEmprestimo", query = "SELECT t FROM TbEmprestimoBemPermanente t WHERE t.idPedidoEmprestimo = :idPedidoEmprestimo")
    , @NamedQuery(name = "TbEmprestimoBemPermanente.findByDtPrevistaRetirada", query = "SELECT t FROM TbEmprestimoBemPermanente t WHERE t.dtPrevistaRetirada = :dtPrevistaRetirada")
    , @NamedQuery(name = "TbEmprestimoBemPermanente.findByJustificativa", query = "SELECT t FROM TbEmprestimoBemPermanente t WHERE t.justificativa = :justificativa")
    , @NamedQuery(name = "TbEmprestimoBemPermanente.findByDtPrevistaDevolucao", query = "SELECT t FROM TbEmprestimoBemPermanente t WHERE t.dtPrevistaDevolucao = :dtPrevistaDevolucao")})
public class TbEmprestimoBemPermanente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido_emprestimo")
    private Integer idPedidoEmprestimo;
    @Column(name = "dt_prevista_retirada")
    @Temporal(TemporalType.DATE)
    private Date dtPrevistaRetirada;
    @Size(max = 255)
    @Column(name = "justificativa")
    private String justificativa;
    @Column(name = "dt_prevista_devolucao")
    @Temporal(TemporalType.DATE)
    private Date dtPrevistaDevolucao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbEmprestimoBemPermanente")
    private Collection<TbFasesEmprestimoBemPermanente> tbFasesEmprestimoBemPermanenteCollection;
    @JoinColumn(name = "id_bem_permanente", referencedColumnName = "id_bem_permanente")
    @ManyToOne
    private TbBemPermanente idBemPermanente;
    @JoinColumn(name = "id_solicitante", referencedColumnName = "id_usuario")
    @ManyToOne
    private TbUsuario idSolicitante;

    public TbEmprestimoBemPermanente() {
    }

    public TbEmprestimoBemPermanente(Integer idPedidoEmprestimo) {
        this.idPedidoEmprestimo = idPedidoEmprestimo;
    }

    public Integer getIdPedidoEmprestimo() {
        return idPedidoEmprestimo;
    }

    public void setIdPedidoEmprestimo(Integer idPedidoEmprestimo) {
        this.idPedidoEmprestimo = idPedidoEmprestimo;
    }

    public Date getDtPrevistaRetirada() {
        return dtPrevistaRetirada;
    }

    public void setDtPrevistaRetirada(Date dtPrevistaRetirada) {
        this.dtPrevistaRetirada = dtPrevistaRetirada;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Date getDtPrevistaDevolucao() {
        return dtPrevistaDevolucao;
    }

    public void setDtPrevistaDevolucao(Date dtPrevistaDevolucao) {
        this.dtPrevistaDevolucao = dtPrevistaDevolucao;
    }

    @XmlTransient
    public Collection<TbFasesEmprestimoBemPermanente> getTbFasesEmprestimoBemPermanenteCollection() {
        return tbFasesEmprestimoBemPermanenteCollection;
    }

    public void setTbFasesEmprestimoBemPermanenteCollection(Collection<TbFasesEmprestimoBemPermanente> tbFasesEmprestimoBemPermanenteCollection) {
        this.tbFasesEmprestimoBemPermanenteCollection = tbFasesEmprestimoBemPermanenteCollection;
    }

    public TbBemPermanente getIdBemPermanente() {
        return idBemPermanente;
    }

    public void setIdBemPermanente(TbBemPermanente idBemPermanente) {
        this.idBemPermanente = idBemPermanente;
    }

    public TbUsuario getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(TbUsuario idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidoEmprestimo != null ? idPedidoEmprestimo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEmprestimoBemPermanente)) {
            return false;
        }
        TbEmprestimoBemPermanente other = (TbEmprestimoBemPermanente) object;
        if ((this.idPedidoEmprestimo == null && other.idPedidoEmprestimo != null) || (this.idPedidoEmprestimo != null && !this.idPedidoEmprestimo.equals(other.idPedidoEmprestimo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbEmprestimoBemPermanente[ idPedidoEmprestimo=" + idPedidoEmprestimo + " ]";
    }
    
}
