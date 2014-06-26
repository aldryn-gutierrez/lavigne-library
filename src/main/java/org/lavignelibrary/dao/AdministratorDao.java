package org.lavignelibrary.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.lavignelibrary.domain.Administrator;
import org.springframework.stereotype.Repository;

@Repository
public class AdministratorDao extends BaseDao {
	
	public void save(Administrator admin){
		sess().save(admin);
		
	}
	
	public Administrator getById(int id) {
		return (Administrator) sess().get(Administrator.class, id);		
	}

	public Administrator getByUsernameAndPassword(String username, String password) {
		
		Criteria criteria = sess().createCriteria(Administrator.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		
		return (Administrator)criteria.uniqueResult();
	}

}
