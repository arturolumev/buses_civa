package com.prueba.app.BusesRepo;
import com.prueba.app.entity.Buses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
 
@EnableJpaRepositories
@Repository
public interface BusesRepo extends JpaRepository<Buses,Integer> {
}