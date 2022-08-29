
package com.portfoliogerez.leg.Repository;

import com.portfoliogerez.leg.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Rpersona extends JpaRepository <Persona, Integer>{
   public Optional<Persona> findByDni(String dni);
}
