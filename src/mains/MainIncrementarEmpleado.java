/**
 * 
 */
package mains;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import servicios.EmployeesServices;
import session.SessionManager;


/**
 * @author Alberto Vivas
 *
 * 
 */
public class MainIncrementarEmpleado {

	
	public static void main(String[] args) {
		EmployeesServices es = new EmployeesServices();
		BigDecimal d = new BigDecimal(20);
		//es.incrementarSalario(d);
		try{
		//es.mostrarEmpleados();
		//es.incrementarSalario(d);
		//es.mostrarEmpleados();
		/*Jobs jobs = new Jobs("ZGZ_mal", "Malavarista");
		Date hireDate = new Date(2015, 6, 11);
		String email = "malavarista@gmail.com";
		int employeeId = 2000;
		String lastName = "geta";
		Set jobHistories = null;
		short s = 100;
		Departments departments = new Departments(s, "entretenimiento");
		String firstName = "Juanton";
		BigDecimal salary = new BigDecimal(2000);
		String phoneNumber = "666111000";
		Set departmentses = null;
		Set employeeses = null;
		BigDecimal commissionPct= new BigDecimal(5);
		Employees employees = null;
		Employees em = new Employees(employeeId, jobs, departments, employees, firstName, lastName, email, phoneNumber, hireDate, salary, commissionPct, employeeses, departmentses, jobHistories);
		es.insertarempleado(em);*/
		
		/*
		System.out.println("\n mostrar empleado\n"+es.obtenerempleado(105));
		JobsServices js = new JobsServices();
		Jobs j = js.mostrarJobs("IT_PROG");
		System.out.println("\n mostrat job\n"+j.tomiString());
		*/
		
		/*
		List<Employees> ale = es.obtenerEmpleadosMejorPagados();
		Iterator<Employees> i = ale.iterator();
		System.out.println("\n Lista de empleados mejor pagados\n");
		while(i.hasNext()){
			System.out.println(i.next().imprime());
		}
		*/
			
		ArrayList<Employees> ale1 = es.obtenerEmpleadosMejorPagadosv20();
		Iterator<Employees> i1 = ale1.iterator();
		System.out.println("\n Lista de empleados mejor pagados\n");
		while(i1.hasNext()){
			System.out.println(i1.next().imprime());
		}	
			
			
			int in = 50;
			List<Employees> ale = es.obtenerEmpleadosPorDepartamento(in);
			Iterator<Employees> i = ale.iterator();
			System.out.println("\nLista de empleados del departamento ("+in+"):"+"\n");
			System.out.println("nombre              dep_id    salario");
			while (i.hasNext()) {
				System.out.println(i.next().imprime());
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally{
			SessionManager.closeAll();
		}
	}
}