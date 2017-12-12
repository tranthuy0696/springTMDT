package com.tmdt.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private int categoryId;
	private String catagoryName;
	private boolean status;
	private String url;
	private List<Category> listSubCategory = new ArrayList<Category>();
	private int id;

	public Category() {

	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Category> getListSubCategory() {
		return listSubCategory;
	}

	public void setListSubCategory(List<Category> listSubCategory) {
		this.listSubCategory = listSubCategory;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SubCategory [categoryId=" + categoryId + ", catagoryName=" + catagoryName + ", status=" + status
				+ ", listSubCategory=" + listSubCategory + "]";
	}

}
