package com.example.elarayax.naves.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.elarayax.naves.model.Nave;

@Repository
public interface NaveRepository extends JpaRepository<Nave, Integer> {

    List<Nave> findByFaccionId(Integer faccionId);

    List<Nave> findByUsuarioId(Integer usuarioId);

    @Query("SELECT n FROM Nave n WHERE n.faccion.id = :faccionId ORDER BY n.id DESC LIMIT 5")
    List<Nave> findTop5ByFaccionIdOrderByIdDesc(@Param("faccionId") Integer faccionId);
    
}