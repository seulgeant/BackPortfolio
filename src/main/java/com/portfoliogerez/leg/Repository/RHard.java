/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliogerez.leg.Repository;

import com.portfoliogerez.leg.Entity.Hard;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RHard extends JpaRepository<Hard, Integer> {
    public Optional<Hard> findByTituloH(String tituloH);
    public boolean existsByTituloH(String tituloH);
}
