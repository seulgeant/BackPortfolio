
package com.portfoliogerez.leg.Repository;

import com.portfoliogerez.leg.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia,Integer>{
    public Optional<Experiencia> findByEmpresaE(String empresaE);
    public boolean existsByEmpresaE(String empresaE);
}
