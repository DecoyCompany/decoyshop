package com.decoyshop.repositories;

import com.decoyshop.entities.Urun;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface Urun_repo extends JpaRepository<Urun,Integer>
{
    List<Urun> findByurunKategorisi_Id(int categoryId);

    List<Urun> findByurunKategorisi_IdIn(List<Integer> categoryIds);

    Page<Urun> findByOrderByUrunPuaniDesc(Pageable pageable);

}
