/**
 * 
 */
package interfaces;

import java.util.List;

/**
 * @author Alberto Vivas
 *
 * 
 */
public interface InterfaceEmployeesDAO extends InterfaceDAO {
	List<Employees> obtenerEmpleados();
}