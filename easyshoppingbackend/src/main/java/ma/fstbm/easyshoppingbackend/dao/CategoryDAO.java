package ma.fstbm.easyshoppingbackend.dao;

import java.util.List;

import ma.fstbm.easyshoppingbackend.domain.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category getCategoryById(Long id);

}
