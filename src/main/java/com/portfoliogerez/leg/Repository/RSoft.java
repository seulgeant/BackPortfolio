
package com.portfoliogerez.leg.Repository;

import com.portfoliogerez.leg.Entity.Soft;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RSoft extends JpaRepository <Soft, Integer> {
    public Optional<Soft> findByTituloS(String tituloS);
    public boolean existsByTituloS(String tituloS);
    
}
