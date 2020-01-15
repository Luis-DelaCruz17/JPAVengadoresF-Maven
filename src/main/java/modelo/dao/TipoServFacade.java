/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidad.TipoServ;

/**
 *
 * @author Luis
 */
@Stateless
public class TipoServFacade extends AbstractFacade<TipoServ> {

    @PersistenceContext(unitName = "MavenVengadoresFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoServFacade() {
        super(TipoServ.class);
    }
    
}
