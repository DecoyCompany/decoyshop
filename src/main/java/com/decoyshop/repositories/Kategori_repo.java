package com.decoyshop.repositories;

import com.decoyshop.entities.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Kategori_repo extends JpaRepository<Kategori,Integer>
{
    List<Kategori> findByustKategoriIsNull();
}
