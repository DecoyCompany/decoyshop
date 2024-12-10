package com.decoyshop.repositories.weak;

import com.decoyshop.entities.weak.Siparis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Siparis_repo extends JpaRepository<Siparis,Integer>
{
    
}
