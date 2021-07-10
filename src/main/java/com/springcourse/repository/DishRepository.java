package com.springcourse.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.springcourse.model.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {

}
