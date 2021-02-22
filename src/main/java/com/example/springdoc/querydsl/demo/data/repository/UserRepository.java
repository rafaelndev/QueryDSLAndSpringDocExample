package com.example.springdoc.querydsl.demo.data.repository;

import com.example.springdoc.querydsl.demo.data.jpa.QUser;
import com.example.springdoc.querydsl.demo.data.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {

    @Override
    default void customize(QuerydslBindings bindings, QUser user) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(user.email);
        bindings.bind(user.firstName).as("name").withDefaultBinding();
    }
}
