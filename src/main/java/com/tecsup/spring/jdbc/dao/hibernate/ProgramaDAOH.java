/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.spring.jdbc.dao.hibernate;

import com.tecsup.spring.jdbc.dao.ProgramaDAO;
import com.tecsup.spring.jdbc.dao.hibernate.BaseHibernateDAO;
import com.tecsup.spring.jdbc.model.Programa;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("programaDAO")
public class ProgramaDAOH extends BaseHibernateDAO implements ProgramaDAO{
    
    public List<Programa> list() {
        Criteria criteria = this.getSession().createCriteria(Programa.class);
        return criteria.list();
    }
    public Programa get(Long t) {
        Criteria criteria= this.getSession().createCriteria(Programa.class);
        criteria.add(Restrictions.eq("id", t));
        return (Programa) criteria.uniqueResult();
    }
    public void save(Programa t) {
        this.getSession().save(t);
    }
    public void update(Programa t) {
        this.getSession().merge(t);
    }
    public void delete(Programa t) {
        this.getSession().delete(t);
    }
    
}

