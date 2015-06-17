
/**
 * 
 */
package incrementarsalario;

import java.math.BigDecimal;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class mainIncrementarSalario {

	
	
	public static void main(String[] args) {
		//IncrementarSalarios is = null;
		IncrementarSalarios is =new IncrementarSalarios();
		try{
		is.mostrarDepVentas();
		//is.incrementarSalario20();
		BigDecimal d = new BigDecimal(0);
		is.incrementarSalarioXporCiento(d);
		is.mostrarDepVentas();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			is.closeSession();
		}
	}
}