package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;
import java.util.UUID;


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
	private String id= UUID.randomUUID().toString();
	
	@NotBlank
	private String parent;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
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