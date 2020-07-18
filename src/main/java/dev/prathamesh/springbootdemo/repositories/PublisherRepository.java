package dev.prathamesh.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.prathamesh.springbootdemo.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
