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
@Table(name = "tb_fabricante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFabricante.findAll", query = "SELECT t FROM TbFabricante t")
    , @NamedQuery(name = "TbFabricante.findByIdFabricante", query = "SELECT t FROM TbFabricante t WHERE t.idFabricante = :idFabricante")
    , @NamedQuery(name = "TbFabricante.findByFabricante", query = "SELECT t FROM TbFabricante t WHERE t.fabricante = :fabricante")})
public class TbFabricante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fabricante")
    private Integer idFabricante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fabricante")
    private String fabricante;
    @OneToMany(mappedBy = "idFabricante")
    private Collection<TbConsumo> tbConsumoCollection;

    public TbFabricante() {
    }

    public TbFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public TbFabricante(Integer idFabricante, String fabricante) {
        this.idFabricante = idFabricante;
        this.fabricante = fabricante;
    }

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @XmlTransient
    public Collection<TbConsumo> getTbConsumoCollection() {
        return tbConsumoCollection;
    }

    public void setTbConsumoCollection(Collection<TbConsumo> tbConsumoCollection) {
        this.tbConsumoCollection = tbConsumoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFabricante != null ? idFabricante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFabricante)) {
            return false;
        }
        TbFabricante other = (TbFabricante) object;
        if ((this.idFabricante == null && other.idFabricante != null) || (this.idFabricante != null && !this.idFabricante.equals(other.idFabricante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbFabricante[ idFabricante=" + idFabricante + " ]";
    }
    
}
