package com.blockbuster.repository;

import com.blockbuster.model.DetalleAlquiler;
import com.blockbuster.model.DetalleAlquilerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleAlquilerRepository extends JpaRepository<DetalleAlquiler, DetalleAlquilerId> {

}
