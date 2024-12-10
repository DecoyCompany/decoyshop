package com.decoyshop.repositories.weak;

import com.decoyshop.entities.weak.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stock_repo extends JpaRepository<Stock,Integer>
{
    
}
