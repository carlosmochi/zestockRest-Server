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
import jpa.TbHistoricoConsumo;
import jpa.TbHistoricoConsumoPK;

/**
 *
 * @author gedsonfaria
 */
@Stateless
@Path("jpa.tbhistoricoconsumo")
public class TbHistoricoConsumoFacadeREST extends AbstractFacade<TbHistoricoConsumo> {

    @PersistenceContext(unitName = "EstoqueRestPU")
    private EntityManager em;

    private TbHistoricoConsumoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idMaterialRetirado=idMaterialRetiradoValue;dtRetirada=dtRetiradaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        jpa.TbHistoricoConsumoPK key = new jpa.TbHistoricoConsumoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idMaterialRetirado = map.get("idMaterialRetirado");
        if (idMaterialRetirado != null && !idMaterialRetirado.isEmpty()) {
            key.setIdMaterialRetirado(new java.lang.Integer(idMaterialRetirado.get(0)));
        }
        java.util.List<String> dtRetirada = map.get("dtRetirada");
        if (dtRetirada != null && !dtRetirada.isEmpty()) {
            key.setDtRetirada(new java.util.Date(dtRetirada.get(0)));
        }
        return key;
    }

    public TbHistoricoConsumoFacadeREST() {
        super(TbHistoricoConsumo.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TbHistoricoConsumo create2(TbHistoricoConsumo entity) {
        super.create(entity);
        return entity;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, TbHistoricoConsumo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        jpa.TbHistoricoConsumoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TbHistoricoConsumo find(@PathParam("id") PathSegment id) {
        jpa.TbHistoricoConsumoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TbHistoricoConsumo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TbHistoricoConsumo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
