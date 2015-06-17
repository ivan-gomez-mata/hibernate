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
public interface InterfaceJobsDAO extends InterfaceDAO{
	List<Jobs> obtenerJobs();
}