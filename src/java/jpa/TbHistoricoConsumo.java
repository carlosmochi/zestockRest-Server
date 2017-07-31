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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gedsonfaria
 */
@Entity
@Table(name = "tb_historico_consumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbHistoricoConsumo.findAll", query = "SELECT t FROM TbHistoricoConsumo t")
    , @NamedQuery(name = "TbHistoricoConsumo.findByIdMaterialRetirado", query = "SELECT t FROM TbHistoricoConsumo t WHERE t.tbHistoricoConsumoPK.idMaterialRetirado = :idMaterialRetirado")
    , @NamedQuery(name = "TbHistoricoConsumo.findByQuantidadeRetirada", query = "SELECT t FROM TbHistoricoConsumo t WHERE t.quantidadeRetirada = :quantidadeRetirada")
    , @NamedQuery(name = "TbHistoricoConsumo.findByMotivoRetirada", query = "SELECT t FROM TbHistoricoConsumo t WHERE t.motivoRetirada = :motivoRetirada")
    , @NamedQuery(name = "TbHistoricoConsumo.findByDtRetirada", query = "SELECT t FROM TbHistoricoConsumo t WHERE t.tbHistoricoConsumoPK.dtRetirada = :dtRetirada")})
public class TbHistoricoConsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbHistoricoConsumoPK tbHistoricoConsumoPK;
    @Column(name = "quantidade_retirada")
    private Integer quantidadeRetirada;
    @Size(max = 255)
    @Column(name = "motivo_retirada")
    private String motivoRetirada;
    @JoinColumn(name = "id_material_retirado", referencedColumnName = "id_consumo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbConsumo tbConsumo;
    @JoinColumn(name = "id_quem_retirou", referencedColumnName = "id_usuario")
    @ManyToOne
    private TbUsuario idQuemRetirou;

    public TbHistoricoConsumo() {
    }

    public TbHistoricoConsumo(TbHistoricoConsumoPK tbHistoricoConsumoPK) {
        this.tbHistoricoConsumoPK = tbHistoricoConsumoPK;
    }

    public TbHistoricoConsumo(int idMaterialRetirado, Date dtRetirada) {
        this.tbHistoricoConsumoPK = new TbHistoricoConsumoPK(idMaterialRetirado, dtRetirada);
    }

    public TbHistoricoConsumoPK getTbHistoricoConsumoPK() {
        return tbHistoricoConsumoPK;
    }

    public void setTbHistoricoConsumoPK(TbHistoricoConsumoPK tbHistoricoConsumoPK) {
        this.tbHistoricoConsumoPK = tbHistoricoConsumoPK;
    }

    public Integer getQuantidadeRetirada() {
        return quantidadeRetirada;
    }

    public void setQuantidadeRetirada(Integer quantidadeRetirada) {
        this.quantidadeRetirada = quantidadeRetirada;
    }

    public String getMotivoRetirada() {
        return motivoRetirada;
    }

    public void setMotivoRetirada(String motivoRetirada) {
        this.motivoRetirada = motivoRetirada;
    }

    public TbConsumo getTbConsumo() {
        return tbConsumo;
    }

    public void setTbConsumo(TbConsumo tbConsumo) {
        this.tbConsumo = tbConsumo;
    }

    public TbUsuario getIdQuemRetirou() {
        return idQuemRetirou;
    }

    public void setIdQuemRetirou(TbUsuario idQuemRetirou) {
        this.idQuemRetirou = idQuemRetirou;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbHistoricoConsumoPK != null ? tbHistoricoConsumoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbHistoricoConsumo)) {
            return false;
        }
        TbHistoricoConsumo other = (TbHistoricoConsumo) object;
        if ((this.tbHistoricoConsumoPK == null && other.tbHistoricoConsumoPK != null) || (this.tbHistoricoConsumoPK != null && !this.tbHistoricoConsumoPK.equals(other.tbHistoricoConsumoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbHistoricoConsumo[ tbHistoricoConsumoPK=" + tbHistoricoConsumoPK + " ]";
    }
    
}
