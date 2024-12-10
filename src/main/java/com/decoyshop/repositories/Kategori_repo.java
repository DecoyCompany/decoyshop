package com.decoyshop.repositories;

import com.decoyshop.entities.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Kategori_repo extends JpaRepository<Kategori,Integer>
{
    
}
