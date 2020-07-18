package dev.prathamesh.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.prathamesh.springbootdemo.domain.Auther;

public interface AutherRepository extends JpaRepository<Auther, Long> {

}
