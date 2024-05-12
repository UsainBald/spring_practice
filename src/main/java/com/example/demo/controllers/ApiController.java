package com.example.demo.controllers;

import com.example.demo.Models.User;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
  @Autowired
  private UserRepo userRepo;

  @GetMapping(value = "/")
  public String getPage() {
    return "HELLO!!";
  }

  @GetMapping(value = "/users")
  public List<User> getUsers() {
    return userRepo.findAll();
  }

  @PostMapping(value = "/save")
  public String saveUser(@RequestBody User user) {
    userRepo.save(user);
    return "Saved user";
  }
}
