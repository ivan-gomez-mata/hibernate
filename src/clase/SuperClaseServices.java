/**
 * 
 */
package clase;

import interfaces.InterfaceDAO;
import session.SessionManager;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class SuperClaseServices extends SuperClaseDAO implements InterfaceDAO{
	
	
	private SuperClaseServices scDAO;
	public SuperClaseServices(){
		scDAO = new SuperClaseServices();
	}

	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#create(java.lang.Object)
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean create(Object arg) {
		boolean b_dev = false;
		Session session = null;
		Transaction transaction = null;
		try{
		session = SessionManager.obtenerSession();
		scDAO.setSession(session);
		transaction = session.beginTransaction();
		b_dev = scDAO.create(arg);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}

	
	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#Read(java.lang.Object)
	 */
	@SuppressWarnings("finally")
	@Override
	public Object Read(Object arg) {
		Object b_dev = false;
		Session session = null;
		Transaction transaction = null;
		try{
		session = SessionManager.obtenerSession();
		scDAO.setSession(session);
		transaction = session.beginTransaction();
		b_dev = scDAO.Read(arg);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}

	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#update(java.lang.Object)
	 */
	@SuppressWarnings("finally")
	@Override
	public Object update(Object arg) {
		Object b_dev = false;
		Session session = null;
		Transaction transaction = null;
		try{
		session = SessionManager.obtenerSession();
		scDAO.setSession(session);
		transaction = session.beginTransaction();
		b_dev = scDAO.update(arg);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}

	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#delete(java.lang.Object)
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean delete(Object arg) {
		boolean b_dev = false;
		Session session = null;
		Transaction transaction = null;
		try{
		session = SessionManager.obtenerSession();
		scDAO.setSession(session);
		transaction = session.beginTransaction();
		b_dev = scDAO.delete(arg);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}

}

