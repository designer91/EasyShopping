package ma.fstbm.easyshoppingbackend.custom;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

public class HibernateAwareObjectMapper {
	
	private static final long serialVersionUID = 1L;

	public HibernateAwareObjectMapper() {
        registerModule(new Hibernate5Module());
    }

	private void registerModule(Hibernate5Module hibernate5Module) {
		// TODO Auto-generated method stub
		
	}

}
