package com.decoyshop.repositories;

import com.decoyshop.entities.Yorum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Yorum_repo extends JpaRepository<Yorum,Integer>
{
    
}
