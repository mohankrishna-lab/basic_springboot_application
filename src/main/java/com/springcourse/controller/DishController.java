package com.springcourse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcourse.model.Dish;
import com.springcourse.service.DishService;

@RestController
@RequestMapping(value = "/home")
public class DishController {

	@Autowired
	private DishService service;

	@GetMapping(value = "get/{id}")
	public Optional<Dish> getDishBy(@PathVariable("id") int id) {
		return service.getDish(id);
	}

	@GetMapping(value = "get/all")
	public List<Dish> getAll(){
		return service.getAllDishes();
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Dish saveDish(@RequestBody Dish dish) {
		return service.saveDish(dish);
	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Dish updateDish(@PathVariable("id") int id, @RequestBody Dish dish) {
		System.out.println("hi");
		return service.updateDish(id, dish);
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteDish(@PathVariable("id") int id) {
		service.deleteDishById(id);
		return "successfully deleted dish by Id " + id;
	}
}
