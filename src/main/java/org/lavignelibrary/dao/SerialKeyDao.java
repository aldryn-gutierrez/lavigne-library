package org.lavignelibrary.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.lavignelibrary.domain.SerialKey;
import org.lavignelibrary.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class SerialKeyDao extends BaseDao {

	public boolean validateKey(String sk){
		
		Criteria criteria = sess().createCriteria(SerialKey.class);
		criteria.add(Restrictions.eq("serialKey", sk));

		SerialKey validSk = (SerialKey)criteria.uniqueResult();
		
		if(validSk != null) {
			
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public void useSerialKey(String sk){
	
		Criteria criteria = sess().createCriteria(SerialKey.class);
		criteria.add(Restrictions.eq("serialKey", sk));

		SerialKey validSk = (SerialKey)criteria.uniqueResult();
		
		validSk.setUsed(true);
		
		sess().update(validSk);
		
	}
	
}
