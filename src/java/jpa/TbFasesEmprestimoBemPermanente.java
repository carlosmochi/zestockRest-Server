/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gedsonfaria
 */
@Entity
@Table(name = "tb_fases_emprestimo_bem_permanente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFasesEmprestimoBemPermanente.findAll", query = "SELECT t FROM TbFasesEmprestimoBemPermanente t")
    , @NamedQuery(name = "TbFasesEmprestimoBemPermanente.findByIdPedidoEmprestimo", query = "SELECT t FROM TbFasesEmprestimoBemPermanente t WHERE t.tbFasesEmprestimoBemPermanentePK.idPedidoEmprestimo = :idPedidoEmprestimo")
    , @NamedQuery(name = "TbFasesEmprestimoBemPermanente.findByDtStatus", query = "SELECT t FROM TbFasesEmprestimoBemPermanente t WHERE t.dtStatus = :dtStatus")
    , @NamedQuery(name = "TbFasesEmprestimoBemPermanente.findByIdStatus", query = "SELECT t FROM TbFasesEmprestimoBemPermanente t WHERE t.tbFasesEmprestimoBemPermanentePK.idStatus = :idStatus")})
public class TbFasesEmprestimoBemPermanente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbFasesEmprestimoBemPermanentePK tbFasesEmprestimoBemPermanentePK;
    @Column(name = "dt_status")
    @Temporal(TemporalType.DATE)
    private Date dtStatus;
    @JoinColumn(name = "id_pedido_emprestimo", referencedColumnName = "id_pedido_emprestimo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbEmprestimoBemPermanente tbEmprestimoBemPermanente;
    @JoinColumn(name = "id_status", referencedColumnName = "id_status", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbStatusEmprestimoBemPermanente tbStatusEmprestimoBemPermanente;
    @JoinColumn(name = "id_responsavel", referencedColumnName = "id_usuario")
    @ManyToOne
    private TbUsuario idResponsavel;

    public TbFasesEmprestimoBemPermanente() {
    }

    public TbFasesEmprestimoBemPermanente(TbFasesEmprestimoBemPermanentePK tbFasesEmprestimoBemPermanentePK) {
        this.tbFasesEmprestimoBemPermanentePK = tbFasesEmprestimoBemPermanentePK;
    }

    public TbFasesEmprestimoBemPermanente(int idPedidoEmprestimo, String idStatus) {
        this.tbFasesEmprestimoBemPermanentePK = new TbFasesEmprestimoBemPermanentePK(idPedidoEmprestimo, idStatus);
    }

    public TbFasesEmprestimoBemPermanentePK getTbFasesEmprestimoBemPermanentePK() {
        return tbFasesEmprestimoBemPermanentePK;
    }

    public void setTbFasesEmprestimoBemPermanentePK(TbFasesEmprestimoBemPermanentePK tbFasesEmprestimoBemPermanentePK) {
        this.tbFasesEmprestimoBemPermanentePK = tbFasesEmprestimoBemPermanentePK;
    }

    public Date getDtStatus() {
        return dtStatus;
    }

    public void setDtStatus(Date dtStatus) {
        this.dtStatus = dtStatus;
    }

    public TbEmprestimoBemPermanente getTbEmprestimoBemPermanente() {
        return tbEmprestimoBemPermanente;
    }

    public void setTbEmprestimoBemPermanente(TbEmprestimoBemPermanente tbEmprestimoBemPermanente) {
        this.tbEmprestimoBemPermanente = tbEmprestimoBemPermanente;
    }

    public TbStatusEmprestimoBemPermanente getTbStatusEmprestimoBemPermanente() {
        return tbStatusEmprestimoBemPermanente;
    }

    public void setTbStatusEmprestimoBemPermanente(TbStatusEmprestimoBemPermanente tbStatusEmprestimoBemPermanente) {
        this.tbStatusEmprestimoBemPermanente = tbStatusEmprestimoBemPermanente;
    }

    public TbUsuario getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(TbUsuario idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbFasesEmprestimoBemPermanentePK != null ? tbFasesEmprestimoBemPermanentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFasesEmprestimoBemPermanente)) {
            return false;
        }
        TbFasesEmprestimoBemPermanente other = (TbFasesEmprestimoBemPermanente) object;
        if ((this.tbFasesEmprestimoBemPermanentePK == null && other.tbFasesEmprestimoBemPermanentePK != null) || (this.tbFasesEmprestimoBemPermanentePK != null && !this.tbFasesEmprestimoBemPermanentePK.equals(other.tbFasesEmprestimoBemPermanentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbFasesEmprestimoBemPermanente[ tbFasesEmprestimoBemPermanentePK=" + tbFasesEmprestimoBemPermanentePK + " ]";
    }
    
}
