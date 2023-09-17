package com.tpjpa.demo.repositorios;
import com.tpjpa.demo.entidades.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteRepository extends JpaRepository<cliente,Long> {
}
