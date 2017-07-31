/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gedsonfaria
 */
@Embeddable
public class TbFasesEmprestimoBemPermanentePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pedido_emprestimo")
    private int idPedidoEmprestimo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "id_status")
    private String idStatus;

    public TbFasesEmprestimoBemPermanentePK() {
    }

    public TbFasesEmprestimoBemPermanentePK(int idPedidoEmprestimo, String idStatus) {
        this.idPedidoEmprestimo = idPedidoEmprestimo;
        this.idStatus = idStatus;
    }

    public int getIdPedidoEmprestimo() {
        return idPedidoEmprestimo;
    }

    public void setIdPedidoEmprestimo(int idPedidoEmprestimo) {
        this.idPedidoEmprestimo = idPedidoEmprestimo;
    }

    public String getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(String idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedidoEmprestimo;
        hash += (idStatus != null ? idStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFasesEmprestimoBemPermanentePK)) {
            return false;
        }
        TbFasesEmprestimoBemPermanentePK other = (TbFasesEmprestimoBemPermanentePK) object;
        if (this.idPedidoEmprestimo != other.idPedidoEmprestimo) {
            return false;
        }
        if ((this.idStatus == null && other.idStatus != null) || (this.idStatus != null && !this.idStatus.equals(other.idStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbFasesEmprestimoBemPermanentePK[ idPedidoEmprestimo=" + idPedidoEmprestimo + ", idStatus=" + idStatus + " ]";
    }
    
}
