package com.tpjpa.demo.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class domicilio extends baseEntidad{
    private String calle;
    private String numero;
    private String localidad;

}
