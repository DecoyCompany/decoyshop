package com.decoyshop.repositories;

import com.decoyshop.entities.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Urun_repo extends JpaRepository<Urun,Integer>
{

}
