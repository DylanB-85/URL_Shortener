package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UrlShortenerModel;

@Repository
public interface DBRepo extends JpaRepository<UrlShortenerModel, String>{

}
