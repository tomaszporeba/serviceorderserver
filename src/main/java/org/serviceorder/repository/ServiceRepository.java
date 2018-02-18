package org.serviceorder.repository;
import java.util.List;

import org.serviceorder.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepository extends JpaRepository<Service, Long>{
	List<Service> findByServiceName(String serviceName);
	Iterable<Service> findByCategoryId(int id);
	Iterable<Service> findByCategoryName(String name);
	Service findById(long id);
	
}
