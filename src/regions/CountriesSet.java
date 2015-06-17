/**
 * 
 */
package mostrar.countries.por.regions;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.cfg.Mappings;
import org.hibernate.mapping.PersistentClass;
//import org.hibernate.mapping.Set;

import tablas_Clases.Countries;
import tablas_Clases.Regions;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class CountriesSet implements Set{

	private Set s;
	/**
	 * @param mappings
	 * @param owner
	 */
	public CountriesSet(Set s) {
		this.s=s;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.mapping.Collection#toString()
	 */
	@Override
	public String toString() {
		String str_dev="";
		
		Iterator<Countries> i = s.iterator();
		
		while (i.hasNext())
		{
			str_dev = str_dev + i.next().toString()+"\n";
		}
		
		
		return str_dev;
	}