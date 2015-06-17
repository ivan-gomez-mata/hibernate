/**
 * 
 */
package clases.DAO;

import interfaces.InterfaceJobsDAO;

import java.util.Iterator;
import java.util.List;

import clase.SuperClaseDAO;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class JobsDAO extends SuperClaseDAO implements InterfaceJobsDAO{

	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#create(java.lang.Object)
	 */
	@Override
	public boolean create(Object arg) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#Read(int)
	 */
	@Override
	public Object Read(Object arg) {
		String s = (String)arg;
		@SuppressWarnings("unchecked")
		List<Jobs> le =getSession().createSQLQuery("Select * from jobs where Job_ID = '"+s+"'").addEntity(Jobs.class).list();
		Iterator<Jobs> ie = le.iterator();
		return ie.next();
	}

	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#update(java.lang.Object)
	 */
	@Override
	public Object update(Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Object arg) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see interfaces.InterfaceJobsDAO#obtenerJobs()
	 */
	@SuppressWarnings("unchecked")
	public List<Jobs> obtenerJobs() {
		return getSession().createSQLQuery("SELECT * FROM JOBS").addEntity(Jobs.class).list();
	}

}

