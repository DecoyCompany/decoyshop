package com.decoyshop.repositories;

import com.decoyshop.entities.Sirket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Sirket_repo extends JpaRepository<Sirket,Integer>
{

}
