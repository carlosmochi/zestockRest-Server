/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import jpa.TbFasesEmprestimoBemPermanente;
import jpa.TbFasesEmprestimoBemPermanentePK;

/**
 *
 * @author gedsonfaria
 */
@Stateless
@Path("jpa.tbfasesemprestimobempermanente")
public class TbFasesEmprestimoBemPermanenteFacadeREST extends AbstractFacade<TbFasesEmprestimoBemPermanente> {

    @PersistenceContext(unitName = "EstoqueRestPU")
    private EntityManager em;

    private TbFasesEmprestimoBemPermanentePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idPedidoEmprestimo=idPedidoEmprestimoValue;idStatus=idStatusValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        jpa.TbFasesEmprestimoBemPermanentePK key = new jpa.TbFasesEmprestimoBemPermanentePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idPedidoEmprestimo = map.get("idPedidoEmprestimo");
        if (idPedidoEmprestimo != null && !idPedidoEmprestimo.isEmpty()) {
            key.setIdPedidoEmprestimo(new java.lang.Integer(idPedidoEmprestimo.get(0)));
        }
        java.util.List<String> idStatus = map.get("idStatus");
        if (idStatus != null && !idStatus.isEmpty()) {
            key.setIdStatus(idStatus.get(0));
        }
        return key;
    }

    public TbFasesEmprestimoBemPermanenteFacadeREST() {
        super(TbFasesEmprestimoBemPermanente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TbFasesEmprestimoBemPermanente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, TbFasesEmprestimoBemPermanente entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        jpa.TbFasesEmprestimoBemPermanentePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TbFasesEmprestimoBemPermanente find(@PathParam("id") PathSegment id) {
        jpa.TbFasesEmprestimoBemPermanentePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TbFasesEmprestimoBemPermanente> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TbFasesEmprestimoBemPermanente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
