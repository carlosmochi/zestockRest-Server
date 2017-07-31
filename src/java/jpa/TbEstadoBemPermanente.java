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
@Table(name = "tb_estado_bem_permanente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEstadoBemPermanente.findAll", query = "SELECT t FROM TbEstadoBemPermanente t")
    , @NamedQuery(name = "TbEstadoBemPermanente.findByIdEstadoBemPermanente", query = "SELECT t FROM TbEstadoBemPermanente t WHERE t.idEstadoBemPermanente = :idEstadoBemPermanente")
    , @NamedQuery(name = "TbEstadoBemPermanente.findByDescricaoEstadoFisico", query = "SELECT t FROM TbEstadoBemPermanente t WHERE t.descricaoEstadoFisico = :descricaoEstadoFisico")})
public class TbEstadoBemPermanente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "id_estado_bem_permanente")
    private String idEstadoBemPermanente;
    @Size(max = 64)
    @Column(name = "descricao_estado_fisico")
    private String descricaoEstadoFisico;
    @OneToMany(mappedBy = "idEstado")
    private Collection<TbBemPermanente> tbBemPermanenteCollection;

    public TbEstadoBemPermanente() {
    }

    public TbEstadoBemPermanente(String idEstadoBemPermanente) {
        this.idEstadoBemPermanente = idEstadoBemPermanente;
    }

    public String getIdEstadoBemPermanente() {
        return idEstadoBemPermanente;
    }

    public void setIdEstadoBemPermanente(String idEstadoBemPermanente) {
        this.idEstadoBemPermanente = idEstadoBemPermanente;
    }

    public String getDescricaoEstadoFisico() {
        return descricaoEstadoFisico;
    }

    public void setDescricaoEstadoFisico(String descricaoEstadoFisico) {
        this.descricaoEstadoFisico = descricaoEstadoFisico;
    }

    @XmlTransient
    public Collection<TbBemPermanente> getTbBemPermanenteCollection() {
        return tbBemPermanenteCollection;
    }

    public void setTbBemPermanenteCollection(Collection<TbBemPermanente> tbBemPermanenteCollection) {
        this.tbBemPermanenteCollection = tbBemPermanenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoBemPermanente != null ? idEstadoBemPermanente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEstadoBemPermanente)) {
            return false;
        }
        TbEstadoBemPermanente other = (TbEstadoBemPermanente) object;
        if ((this.idEstadoBemPermanente == null && other.idEstadoBemPermanente != null) || (this.idEstadoBemPermanente != null && !this.idEstadoBemPermanente.equals(other.idEstadoBemPermanente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbEstadoBemPermanente[ idEstadoBemPermanente=" + idEstadoBemPermanente + " ]";
    }
    
}
