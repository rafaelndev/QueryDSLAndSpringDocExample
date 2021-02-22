package com.example.springdoc.querydsl.demo.resource;

import com.example.springdoc.querydsl.demo.data.jpa.User;
import com.example.springdoc.querydsl.demo.data.repository.UserRepository;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class TesteResource {
    private final UserRepository repository;

    @GetMapping("/")
    public Page<User> testeQueryDslAndSpringDoc(@QuerydslPredicate(root = User.class) Predicate predicate, Pageable pageable) {
        return repository.findAll(predicate, pageable);
    }
}
