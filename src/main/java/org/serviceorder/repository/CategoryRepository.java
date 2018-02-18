package org.serviceorder.repository;

import org.serviceorder.model.service.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
