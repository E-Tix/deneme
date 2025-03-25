package com.example.demo.Repository;


import com.example.demo.Entity.KoltukEntity;
import com.example.demo.Entity.SalonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KoltukRepository extends JpaRepository<KoltukEntity, Long> {

    Optional<KoltukEntity> findByKoltukID(Long koltukID);

    //Optional<Koltuk> findBySalon_SalonID(Long salonID);

    List<KoltukEntity>findBySalon_SalonID(Long salonID);

    //Belli bir salondaki bütün koltukları bulmak için
    Optional<List<KoltukEntity>> findBySalon(SalonEntity salon);
}
