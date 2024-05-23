package com.example.crudtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudtest.entity.Title;
import com.example.crudtest.entity.TitleId;

@Repository
public interface TitleRepository extends JpaRepository<Title, TitleId> {
}
