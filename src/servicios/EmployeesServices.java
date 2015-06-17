/**
 * 
 */
package servicios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import session.SessionManager;
import clases.DAO.EmployeesDAO;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class EmployeesServices {
	
	private static EmployeesDAO eDAO;
	//private static InterfaceDAO eDAO;
	public EmployeesServices() {
		eDAO = new EmployeesDAO();
	}
	
	@SuppressWarnings("finally")
	public boolean incrementarSalario(BigDecimal d){
		boolean b_dev= false;
		Session session = null;
		Transaction transaction = null;
		
		try{
		if(d.signum()==-1){
			System.out.println("\n Decrementando el salario en: "+d+ "%\n" );
		}
		if (d.signum()==1){
			System.out.println("\n Incrementando el salario en: "+d+"%\n");
		}
		if (d.signum()==0){
			System.out.println("\n No incrementamos el salario, inc = "+d+"%\n");
		}	
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		List<Employees> le = eDAO.obtenerEmpleados();
		Iterator<Employees> it = le.iterator();
		Employees employees =null;
		BigDecimal n_salary = new BigDecimal(0);
		BigDecimal inc = new BigDecimal(1).add(d.divide(new BigDecimal(100)));
		while(it.hasNext()){
			employees=it.next();
			n_salary= employees.getSalary().multiply(inc);
			employees.setSalary(n_salary);
		}
		transaction.commit();
		b_dev = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}

	@SuppressWarnings("finally")
	public boolean mostrarEmpleados(){
		boolean b_dev= false;
		Session session = null;
		Transaction transaction = null;
		
		try{
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		List<Employees> le = eDAO.obtenerEmpleados();
		Iterator<Employees> it = le.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		transaction.commit();
		b_dev = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean insertarempleado(Employees em){
		boolean b_dev = false;
		Session session = null;
		Transaction transaction = null;
		
		try{
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		b_dev = eDAO.create(em);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}
	
	@SuppressWarnings("finally")
	public Employees obtenerempleado(int emp_id){
		Employees b_dev = null;
		Session session = null;
		Transaction transaction = null;
		
		try{
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		b_dev = (Employees) eDAO.Read((Object)emp_id);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Employees> obtenerEmpleados(){
		Session session = null;
		Transaction transaction = null;
		List<Employees> le =null;
		try{
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		le = eDAO.obtenerEmpleados();
		transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return le;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Employees> obtenerEmpleadosMejorPagados(){
		Session session = null;
		Transaction transaction = null;
		List<Employees> le =null;
		ArrayList<Employees> lemp =null;//new ArrayList<Employees>();
		try{
		System.out.println("obtenerEmpleadosMejorPagados");	
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		le = eDAO.obtenerEmpleados();
		//Arrays.sort(lemp);
		Iterator<Employees> ie = le.iterator();
		lemp = new ArrayList<Employees>();
		Employees e = null;
		ArrayList<Employees> al10 = new ArrayList<Employees>();
		ArrayList<Employees> al20 = new ArrayList<Employees>();
		ArrayList<Employees> al30 = new ArrayList<Employees>();
		ArrayList<Employees> al40 = new ArrayList<Employees>();
		ArrayList<Employees> al50 = new ArrayList<Employees>();
		ArrayList<Employees> al60 = new ArrayList<Employees>();
		ArrayList<Employees> al70 = new ArrayList<Employees>();
		ArrayList<Employees> al80 = new ArrayList<Employees>();
		ArrayList<Employees> al90 = new ArrayList<Employees>();
		ArrayList<Employees> al100 = new ArrayList<Employees>();
		ArrayList<Employees> al110 = new ArrayList<Employees>();
		ArrayList<Employees> alb = new ArrayList<Employees>();
		
		System.out.println("voy al while");
		while(ie.hasNext()){
			e = ie.next();
			//System.out.println(e.imprime());
			//System.out.println(e.getEmployeeId());
				if (e.getEmployeeId()!= 178) {
					int e_dep_id=e.getDepartments().getDepartmentId();
					switch (e_dep_id) {
					case 10:
						al10.add(e);
						break;
					case 20:
						al20.add(e);
						break;
					case 30:
						al30.add(e);
						break;
					case 40:
						al40.add(e);
						break;
					case 50:
						al50.add(e);
						break;
					case 60:
						al60.add(e);
						break;
					case 70:
						al70.add(e);
						break;
					case 80:
						al80.add(e);
						break;
					case 90:
						al90.add(e);
						break;
					case 100:
						al100.add(e);
						break;
					case 110:
						al110.add(e);
						break;

					default:
						alb.add(e);
						break;
					}
				}
		}
		lemp.add(obtenerEmpleadoMayor(al10));
		lemp.add(obtenerEmpleadoMayor(al20));
		lemp.add(obtenerEmpleadoMayor(al30));
		lemp.add(obtenerEmpleadoMayor(al40));
		lemp.add(obtenerEmpleadoMayor(al50));
		lemp.add(obtenerEmpleadoMayor(al60));
		lemp.add(obtenerEmpleadoMayor(al70));
		lemp.add(obtenerEmpleadoMayor(al80));
		lemp.add(obtenerEmpleadoMayor(al90));
		lemp.add(obtenerEmpleadoMayor(al100));
		lemp.add(obtenerEmpleadoMayor(al110));
		transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return lemp;
		}
		
	}
	
	
	public Employees obtenerEmpleadoMayor(ArrayList<Employees> ale){
		Employees e_dev= null;
		Employees e_f = null;
		Iterator<Employees> i = ale.iterator();
		e_dev=i.next();
		
		while(i.hasNext()){
			e_f = i.next();
			if(e_f.getSalary().intValue() > e_dev.getSalary().intValue()){
				e_dev=e_f;
			}
		}
		return e_dev;
	}
	
	
	
	@SuppressWarnings("finally")
	public ArrayList<Employees> obtenerEmpleadosMejorPagadosv20(){
		Session session = null;
		Transaction transaction = null;
		ArrayList<Employees> le =new ArrayList<Employees>(11);
		try{
		System.out.println("obtenerEmpleadosMejorPagados");	
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		for (int i = 1; i <= 11; i++) {
			le.add(obtenerEmpleadoMayor(eDAO.obtenerEmpleadosPorDepartamento(i*10)));	
		}
		transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return le;
		}
		
	}
	
	/**
	 * v2.0 de obtener empleados mejor pagados por departamentos
	 * @param le
	 * @return
	 */
	public Employees obtenerEmpleadoMayor(List<Employees> le){
		Employees e_dev= null;
		Employees e_f = null;
		Iterator<Employees> i = le.iterator();
		e_dev=i.next();
		
		while(i.hasNext()){
			e_f = i.next();
			if(e_f.getSalary().intValue() > e_dev.getSalary().intValue()){
				e_dev=e_f;
			}
		}
		return e_dev;
	}
	
	
	
	
	
	
	
	
	//obtener empleados por departamento
	//obtenerEmpleadosPorDepartamento(Object departamento)
	
	@SuppressWarnings("finally")
	public List<Employees> obtenerEmpleadosPorDepartamento(int departament_id){
		Session session = null;
		Transaction transaction = null;
		List<Employees> le =null;
		try{
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		le = eDAO.obtenerEmpleadosPorDepartamento(departament_id);
		transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return le;
		}	
	}
}

