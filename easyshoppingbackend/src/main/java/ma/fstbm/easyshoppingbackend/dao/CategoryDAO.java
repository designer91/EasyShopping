package ma.fstbm.easyshoppingbackend.dao;

import java.util.List;

import ma.fstbm.easyshoppingbackend.domain.Category;

public interface CategoryDAO {
	
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
	List<Category> list();
	Category getCategoryById(Long id);

}
