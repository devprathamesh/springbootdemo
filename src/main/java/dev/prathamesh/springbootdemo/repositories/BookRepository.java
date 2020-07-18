package dev.prathamesh.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.prathamesh.springbootdemo.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
