/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gedsonfaria
 */
@Embeddable
public class TbHistoricoConsumoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_material_retirado")
    private int idMaterialRetirado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_retirada")
    @Temporal(TemporalType.DATE)
    private Date dtRetirada;

    public TbHistoricoConsumoPK() {
    }

    public TbHistoricoConsumoPK(int idMaterialRetirado, Date dtRetirada) {
        this.idMaterialRetirado = idMaterialRetirado;
        this.dtRetirada = dtRetirada;
    }

    public int getIdMaterialRetirado() {
        return idMaterialRetirado;
    }

    public void setIdMaterialRetirado(int idMaterialRetirado) {
        this.idMaterialRetirado = idMaterialRetirado;
    }

    public Date getDtRetirada() {
        return dtRetirada;
    }

    public void setDtRetirada(Date dtRetirada) {
        this.dtRetirada = dtRetirada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMaterialRetirado;
        hash += (dtRetirada != null ? dtRetirada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbHistoricoConsumoPK)) {
            return false;
        }
        TbHistoricoConsumoPK other = (TbHistoricoConsumoPK) object;
        if (this.idMaterialRetirado != other.idMaterialRetirado) {
            return false;
        }
        if ((this.dtRetirada == null && other.dtRetirada != null) || (this.dtRetirada != null && !this.dtRetirada.equals(other.dtRetirada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbHistoricoConsumoPK[ idMaterialRetirado=" + idMaterialRetirado + ", dtRetirada=" + dtRetirada + " ]";
    }
    
}
