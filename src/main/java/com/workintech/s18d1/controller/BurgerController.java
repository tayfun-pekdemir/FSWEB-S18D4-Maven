package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/burger")
@Slf4j
public class BurgerController {

    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> getAllBurgerList(){
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable long id){
        BurgerValidation.validateId(id);
        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger addBurger(@RequestBody Burger burger){
        BurgerValidation.validateBurger(burger);
        burgerDao.save(burger);
        log.info("Burger created with id: {}", burger.getId());
        return burger;
    }

    @PutMapping
    public Burger updateBurger(@RequestBody Burger burger){
        BurgerValidation.validateId(burger.getId());
        BurgerValidation.validateBurger(burger);
        burgerDao.update(burger);
        log.info("Burger updated with id: {}", burger.getId());
        return burger;
    }

    @DeleteMapping("/{id}")
    public Burger deleteBurger(@PathVariable long id){
        BurgerValidation.validateId(id);
        return burgerDao.remove(id);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPriceBurger(@PathVariable double price){
        BurgerValidation.validatePrice(price);
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadTypeBurger(@PathVariable BreadType breadType){
        BurgerValidation.validateBreadType(breadType);
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContentBurger(@PathVariable String content){
        BurgerValidation.validateContent(content);
        return burgerDao.findByContent(content);
    }

}
