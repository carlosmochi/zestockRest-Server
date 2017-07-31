/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author gedsonfaria
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(jpa.service.CORSFilter.class);
        resources.add(jpa.service.TbBemPermanenteFacadeREST.class);
        resources.add(jpa.service.TbConsumoFacadeREST.class);
        resources.add(jpa.service.TbEmprestimoBemPermanenteFacadeREST.class);
        resources.add(jpa.service.TbEstadoBemPermanenteFacadeREST.class);
        resources.add(jpa.service.TbFabricanteFacadeREST.class);
        resources.add(jpa.service.TbFasesEmprestimoBemPermanenteFacadeREST.class);
        resources.add(jpa.service.TbHistoricoConsumoFacadeREST.class);
        resources.add(jpa.service.TbLocaisLotacaoBemPermanenteFacadeREST.class);
        resources.add(jpa.service.TbProdutoConsumoFacadeREST.class);
        resources.add(jpa.service.TbStatusEmprestimoBemPermanenteFacadeREST.class);
        resources.add(jpa.service.TbUnidadeFacadeREST.class);
        resources.add(jpa.service.TbUsuarioFacadeREST.class);
    }
    
}
