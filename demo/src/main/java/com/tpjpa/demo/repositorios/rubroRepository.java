package com.tpjpa.demo.repositorios;
import com.tpjpa.demo.entidades.rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rubroRepository extends JpaRepository<rubro,Long> {
}
