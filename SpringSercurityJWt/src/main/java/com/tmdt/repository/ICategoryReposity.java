package com.tmdt.repository;

import java.util.List;

import com.tmdt.domain.Category;


public interface ICategoryReposity {
	public List<Category> getListCategory();

	public List<Category> getListSubCategory(int id);

	public void deleteCategory(int categoryId);

	public void deleteSubCategory(int id);

	public void deleteWholeSubCategory(int id);

	public void insertCategory(Category category);

	public void updateCategory(Category category);

}
