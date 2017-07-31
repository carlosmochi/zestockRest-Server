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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gedsonfaria
 */
@Entity
@Table(name = "tb_locais_lotacao_bem_permanente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbLocaisLotacaoBemPermanente.findAll", query = "SELECT t FROM TbLocaisLotacaoBemPermanente t")
    , @NamedQuery(name = "TbLocaisLotacaoBemPermanente.findByIdLocaLotacao", query = "SELECT t FROM TbLocaisLotacaoBemPermanente t WHERE t.idLocaLotacao = :idLocaLotacao")
    , @NamedQuery(name = "TbLocaisLotacaoBemPermanente.findByUnidadeSetorial", query = "SELECT t FROM TbLocaisLotacaoBemPermanente t WHERE t.unidadeSetorial = :unidadeSetorial")
    , @NamedQuery(name = "TbLocaisLotacaoBemPermanente.findBySetor", query = "SELECT t FROM TbLocaisLotacaoBemPermanente t WHERE t.setor = :setor")
    , @NamedQuery(name = "TbLocaisLotacaoBemPermanente.findBySala", query = "SELECT t FROM TbLocaisLotacaoBemPermanente t WHERE t.sala = :sala")})
public class TbLocaisLotacaoBemPermanente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_loca_lotacao")
    private Integer idLocaLotacao;
    @Size(max = 6)
    @Column(name = "unidade_setorial")
    private String unidadeSetorial;
    @Size(max = 64)
    @Column(name = "setor")
    private String setor;
    @Size(max = 64)
    @Column(name = "sala")
    private String sala;
    @OneToMany(mappedBy = "salaAlocacao")
    private Collection<TbBemPermanente> tbBemPermanenteCollection;

    public TbLocaisLotacaoBemPermanente() {
    }

    public TbLocaisLotacaoBemPermanente(Integer idLocaLotacao) {
        this.idLocaLotacao = idLocaLotacao;
    }

    public Integer getIdLocaLotacao() {
        return idLocaLotacao;
    }

    public void setIdLocaLotacao(Integer idLocaLotacao) {
        this.idLocaLotacao = idLocaLotacao;
    }

    public String getUnidadeSetorial() {
        return unidadeSetorial;
    }

    public void setUnidadeSetorial(String unidadeSetorial) {
        this.unidadeSetorial = unidadeSetorial;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
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
        hash += (idLocaLotacao != null ? idLocaLotacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbLocaisLotacaoBemPermanente)) {
            return false;
        }
        TbLocaisLotacaoBemPermanente other = (TbLocaisLotacaoBemPermanente) object;
        if ((this.idLocaLotacao == null && other.idLocaLotacao != null) || (this.idLocaLotacao != null && !this.idLocaLotacao.equals(other.idLocaLotacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TbLocaisLotacaoBemPermanente[ idLocaLotacao=" + idLocaLotacao + " ]";
    }
    
}
