
package com.portfoliogerez.leg.Repository;

import com.portfoliogerez.leg.Entity.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REstudio extends JpaRepository<Estudio,Integer>{
        public Optional<Estudio> findByInstitucion(String institucion);
    public boolean existsByInstitucion(String institucion);
}
