/**
 * 
 */
package mostrar.countries.por.regions;

import java.util.Iterator;
import java.util.List;

import javax.security.auth.login.Configuration;



/**
 * @author Alberto Vivas
 *
 * 
 */
public class mostrarPaises {
	private static Session session;
	private static Configuration configuration;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	private static Transaction transaction;
	
	public mostrarPaises(){
		configuration = new Configuration().configure();
		builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
		setSession(factory.openSession());
		disconectSession();
	}
	
	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		mostrarPaises.session = session;
	}


	
	private static void obtenerSession(){
		if(!session.isConnected())
		session = factory.getCurrentSession(); // este suele usarse mas para no crear multiples sesiones y cerrarlas sino usar una unica
	}
	
	private static void disconectSession(){
		session.disconnect();
	}
	
	public void closeSession(){
		try{
		session.close();
		factory.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("finally")
	public boolean mostrarlistaPaises(){
		boolean respuesta = false;
		Regions region;
		System.out.println("Departamento de ventas: \n");
		try {
			obtenerSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Regions> list = session.createSQLQuery("SELECT * FROM REGIONS").addEntity(Regions.class).list();
			Iterator<Regions> it = list.iterator();
			while (it.hasNext()) {
				region =it.next();
				CountriesSet cs = new CountriesSet(region.getCountrieses());
				System.out.println("Region: "+region.getRegionName()+", contiene los paises: \n"+cs);
			}
			transaction.commit();
			respuesta = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			disconectSession();
			return respuesta;
		}

	}
	
	
	
	
	
	
	
	
	
}

