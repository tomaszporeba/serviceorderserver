package org.serviceorder.controller;

import org.serviceorder.model.service.Category;
import org.serviceorder.model.service.Service;
import org.serviceorder.model.service.View;
import org.serviceorder.repository.CategoryRepository;
import org.serviceorder.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class ServiceRestController {

	@Autowired
	ServiceRepository serviceRepository;
	@Autowired
	CategoryRepository categoryRepository;
	

	@RequestMapping(path = "/services", method = RequestMethod.GET)
	public void getServices() {
	}

	@RequestMapping(path = "/addService", method = RequestMethod.POST)
	public void addService(@RequestBody Service service) {
		serviceRepository.save(service);
	}
	@JsonView(View.OnlyService.class)
	@RequestMapping(path = "/getAll", method = RequestMethod.GET)
	public Iterable<Service> getAllServices() {
		//return this.serviceRepository.findByCategoryId(1);
		return this.serviceRepository.findAll();
	}
	
	@JsonView(View.OnlyService.class)
	@RequestMapping(path = "/getService/{n}", method = RequestMethod.GET)
	public Service getService(@PathVariable long n) {
		return this.serviceRepository.findById(n);
	}
	
	@JsonView(View.OnlyService.class)
	@RequestMapping(path = "/getServicesByName/{?name}", method = RequestMethod.GET)
	public Iterable<Service> getServicesByName(@PathVariable String name) {
		return this.serviceRepository.findByServiceName(name);
	}
	
	@JsonView(View.OnlyCategory.class)
	@RequestMapping(path = "getAllCategories", method = RequestMethod.GET)
	public Iterable<Category> getAllCategories() {
		return this.categoryRepository.findAll();
	}
}
