package org.serviceorder.model.service;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "CATEGORY")
public class Category {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
	@JsonView(View.OnlyCategory.class)
    private int id;

    @Column(name = "NAME", length = 50)
    @NotNull
    @JsonView({View.OnlyService.class, View.OnlyCategory.class})
    @Enumerated(EnumType.STRING)
    private CategoryName name;

   
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonView(View.OnlyCategory.class)
    private List<Service> services;
    
    
	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public int getId() {
        return id;
    }

    public CategoryName getName() {
		return name;
	}

	public void setName(CategoryName name) {
		this.name = name;
	}



	public void setId(int id) {
        this.id = id;
    }

    
}
