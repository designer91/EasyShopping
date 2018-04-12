package ma.fstbm.easyshoppingbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ma.fstbm.easyshoppingbackend.dao.CategoryDAO;
import ma.fstbm.easyshoppingbackend.domain.Category;

@Repository("categoryDAO")
public class CategoryDaoService implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setCategoryID(1L);
		category.setCategoryName("Informatique");
		category.setCategoryDesc("all informatique products here");
		category.setCategoryImage(null);
		category.setActive(true);
		categories.add(category);
		
		category = new Category();
		category.setCategoryID(2L);
		category.setCategoryName("Electronics");
		category.setCategoryDesc("all electronics products here");
		category.setCategoryImage(null);
		category.setActive(true);
		categories.add(category);
		
		category = new Category();
		category.setCategoryID(3L);
		category.setCategoryName("Food & Drinks");
		category.setCategoryDesc("all Food & Drinks products here");
		category.setCategoryImage(null);
		category.setActive(true);
		categories.add(category);
		
		category = new Category();
		category.setCategoryID(4L);
		category.setCategoryName("Clothes");
		category.setCategoryDesc("all Clothes products here");
		category.setCategoryImage(null);
		category.setActive(true);
		categories.add(category);
		
	}
	
	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category getCategoryById(Long id) {
		for (Category category : categories) {
			if (category.getCategoryID() == id) { return category; }
		}
		return null;
	}

}
