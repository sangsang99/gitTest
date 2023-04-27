package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPA : Java Persistence API (자바 ORM 기술에 대한 API 표준 명세)
//Hibernate, EcipseLink, DataNucleus, OpenJPA, TopLink 등 같이 사용
@Repository
public interface RepoJPA extends JpaRepository<TblUser, Long>{
    
}
 