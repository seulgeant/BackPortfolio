
package com.portfoliogerez.leg.Repository;

import com.portfoliogerez.leg.Entity.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RObjetivo extends JpaRepository<Objetivo,Integer>{
    public boolean existsByid(String id);
}
