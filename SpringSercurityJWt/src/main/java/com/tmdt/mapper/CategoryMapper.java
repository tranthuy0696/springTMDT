package com.tmdt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tmdt.domain.Category;


@Mapper
public interface CategoryMapper {
	public List<Category> getListCategory();

	public List<Category> getListSubCategory(int id);

	public void deleteCategory(int categoryId);

	public void deleteSubCategory(int id);

	public void insertCategory(Category category);

	public void updateCategory(Category category);

}
