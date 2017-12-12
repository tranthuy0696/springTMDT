package com.tmdt.repository.impl;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tmdt.domain.Category;
import com.tmdt.mapper.CategoryMapper;
import com.tmdt.repository.ICategoryReposity;


@Repository
public class CategoryReposity implements ICategoryReposity {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryReposity.class);
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * lay toan bo danh sach category
	 */
	@Override
	public List<Category> getListCategory() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Category> result = Collections.emptyList();
		try {
			CategoryMapper subCategory = session.getMapper(CategoryMapper.class);
			/**
			 * danh sach category cap 0
			 */
			result = subCategory.getListCategory();
			getListCategory(result);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	/**
	 * lay danh sach category cap con bac 1
	 */

	@Override
	public List<Category> getListSubCategory(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Category> result = Collections.emptyList();
		try {
			CategoryMapper subCategory = session.getMapper(CategoryMapper.class);
			result = subCategory.getListSubCategory(id);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	/**
	 * them category con vao category cha
	 * 
	 * @param list
	 */
	private void getListCategory(List<Category> list) {
		if (list != null && !list.isEmpty()) {
			for (Category subCategory : list) {
				List<Category> listSub = getListSubCategory(subCategory.getCategoryId());
				subCategory.setListSubCategory(listSub);
				getListCategory(subCategory.getListSubCategory());
			}
		}
	}

	/**
	 * xoa category and category con neu category con ton tai
	 */
	@Override
	public void deleteCategory(int categoryId) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
			categoryMapper.deleteCategory(categoryId);
			deleteWholeSubCategory(categoryId);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}

	}

	//
	// /**
	// * de quy xoa category con
	// *
	// * @param id
	// * @param categoryMapper
	// */
	public void deleteWholeSubCategory(int id) {
		if (!getListSubCategory(id).isEmpty()) {
			for (Category subCategory : getListSubCategory(id)) {
				deleteSubCategory(id);
				deleteWholeSubCategory(subCategory.getCategoryId());
			}

		}

	}

	/**
	 * delete subCategory
	 */
	public void deleteSubCategory(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
			categoryMapper.deleteSubCategory(id);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}

	}

	/**
	 * insert category
	 */
	public void insertCategory(Category category) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
			categoryMapper.insertCategory(category);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
	}

	/**
	 * update category
	 */
	public void updateCategory(Category category) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
			categoryMapper.updateCategory(category);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
	}

}
