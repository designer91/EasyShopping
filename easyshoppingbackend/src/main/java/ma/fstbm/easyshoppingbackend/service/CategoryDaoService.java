package ma.fstbm.easyshoppingbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.fstbm.easyshoppingbackend.dao.CategoryDAO;
import ma.fstbm.easyshoppingbackend.domain.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDaoService implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>();
	
	/*static {
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
		
	}*/
	
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = " FROM Category WHERE active =:active ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
		
	  //return categories;
		
	}

	@Override
	public Category getCategoryById(Long id) {
		/*for (Category category : categories) {
			if (category.getCategoryID() == id) { return category; }
		}*/
		return sessionFactory.getCurrentSession().get(Category.class, Long.valueOf(id));
	}

	@Override
	public boolean addCategory(Category category) {
		
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		
		category.setActive(false);
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
