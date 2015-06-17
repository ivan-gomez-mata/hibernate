/**
 * 
 */
package ejercicio.incrementar.salario;



import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.login.Configuration;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class IncrementarSalarios {
	
	private static Session session;
	private static Configuration configuration;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	private static Transaction transaction;
	
	public IncrementarSalarios(){
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
		IncrementarSalarios.session = session;
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
	public boolean incrementarSalario20(){
		boolean respuesta = false;
		try {
			System.out.println("\n Incrementando el salario\n");
			obtenerSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Employees> list = session.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID =(SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME like 'Sales') ").addEntity(Employees.class).list();//entity es el objeto java asociada a la base de datos
			Iterator<Employees> it = list.iterator();
			Employees employees =null;
			BigDecimal n_salary = new BigDecimal(0);
			BigDecimal inc = new BigDecimal(1.2);
			while(it.hasNext()){
				employees=it.next();
				n_salary= employees.getSalary().multiply(inc);
				employees.setSalary(n_salary);
			}
			transaction.commit();
			respuesta = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			System.out.println("Termino de incrementar");
			disconectSession();
			return respuesta;
		}
	}
	/**
	 * 
	 * @param d es in BigDecimal pos,neg o cero (procentaje a incrementar)
	 * En cada caso el metodo devuelce un syso segun el tipo de operacion que realiza
	 * pos = incrementar
	 * neg = decrementar
	 * cero = salario no cambia.
	 * @return boolean T/F si si logra incrementar o no el salario
	 */
	@SuppressWarnings("finally")
	public boolean incrementarSalarioXporCiento(BigDecimal d){
		boolean respuesta = false;
		try {
			if(d.signum()==-1){
				System.out.println("\n Decrementando el salario en: "+d+ "%\n" );
			}
			if (d.signum()==1){
				System.out.println("\n Incrementando el salario en: "+d+"%\n");
			}
			if (d.signum()==0){
				System.out.println("\n No incrementamos el salario, inc = "+d+"%\n");
			}
			obtenerSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Employees> list = session.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID =(SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME like 'Sales') ").addEntity(Employees.class).list();//entity es el objeto java asociada a la base de datos
			Iterator<Employees> it = list.iterator();
			Employees employees =null;
			BigDecimal n_salary = new BigDecimal(0);
			BigDecimal inc = new BigDecimal(1).add(d.divide(new BigDecimal(100)));
			while(it.hasNext()){
				employees=it.next();
				n_salary= employees.getSalary().multiply(inc);
				employees.setSalary(n_salary);
				session.saveOrUpdate(employees);
			}
			
			transaction.commit();
			respuesta = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			disconectSession();
			return respuesta;
		}
	}
	
	
	
	
	
	@SuppressWarnings("finally")
	public boolean mostrarDepVentas(){
		boolean respuesta = false;
		System.out.println("Departamento de ventas: \n");
		try {
			obtenerSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Employees> list = session.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID =(SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME like 'Sales') ").addEntity(Employees.class).list();// entity es el objeto java asociada a la base de datos
			Iterator<Employees> it = list.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
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

