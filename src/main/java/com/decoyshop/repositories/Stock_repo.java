package com.decoyshop.repositories;

import com.decoyshop.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stock_repo extends JpaRepository<Stock,Integer>
{
    
}
