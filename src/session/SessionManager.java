/**
 * 
 */
package session;

import javax.security.auth.login.Configuration;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class SessionManager {

	private Session session;
	private static Configuration configuration;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	
	private  static SessionManager sessionManager = new SessionManager();
	

	private SessionManager(){
		configuration = new Configuration().configure();
		builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}
	
	public static Session obtenerSession(){
		sessionManager.session =factory.openSession();
		return sessionManager.session;
	}
	
	public static void disconectSession(){
		sessionManager.session.close();
	}
	
	
	@SuppressWarnings("static-access")
	public static void closeAll(){
		try{
			//sessionManager.session.close();
			sessionManager.factory.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}

