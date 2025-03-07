package com.bootcamp.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.dscatalog.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
