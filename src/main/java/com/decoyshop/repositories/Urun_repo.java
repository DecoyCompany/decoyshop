package com.decoyshop.repositories;

import com.decoyshop.entities.Kategori;
import com.decoyshop.entities.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Urun_repo extends JpaRepository<Urun,Integer>
{
    List<Urun> findByURUN_KATEGORISI_Id(int categoryId);

    List<Urun> findByURUN_KATEGORISI_IdIn(List<Integer> categoryIds);
}
