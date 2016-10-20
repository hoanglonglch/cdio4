package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parent database table.
 * 
 */
@Entity
@Table (name = "parent")
@NamedQuery(name="ParentEntity.findAll", query="SELECT p FROM ParentEntity p")
public class ParentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String parent;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="parent")
	private List<CategoryEntity> categories;

	public ParentEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public List<CategoryEntity> getCategories() {
		return this.categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}

	public CategoryEntity addCategory(CategoryEntity category) {
		getCategories().add(category);
		category.setParent(this);

		return category;
	}

	public CategoryEntity removeCategory(CategoryEntity category) {
		getCategories().remove(category);
		category.setParent(null);

		return category;
	}

}