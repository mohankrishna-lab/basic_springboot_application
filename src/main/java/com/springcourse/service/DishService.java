package com.springcourse.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springcourse.model.Dish;
import com.springcourse.repository.DishRepository;

@Component
@Service
public class DishService {

	@Autowired
	private DishRepository repo;

	@Transactional
	public Optional<Dish> getDish(int id) {
		return repo.findById(id);
	}

	@Transactional
	public List<Dish> getAllDishes(){
		return repo.findAll();
	}

	@Transactional
	public Dish saveDish(Dish dish) {
		return repo.save(dish);
	}

	@Transactional
	public Dish updateDish(int id, Dish dish) {
		dish.setId(id);
		return repo.save(dish);
	}

	@Transactional
	public void deleteDishById(int id) {
		repo.deleteById(id);
	}
}
