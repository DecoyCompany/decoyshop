package com.decoyshop.repositories;

import com.decoyshop.entities.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Kullanici_repo extends JpaRepository<Kullanici,Integer>
{
    Kullanici findByemail(String email);

}
