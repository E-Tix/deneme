package com.example.demo.Repository;

import com.example.demo.Entity.EtkinlikEntity;
import com.example.demo.Entity.EtkinlikSalonSeansEntity;
import com.example.demo.Entity.SalonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtkinlikSalonSeansRepository extends JpaRepository<EtkinlikSalonSeansEntity, Long> {

    @Query("""
    SELECT DISTINCT ess.salon FROM EtkinlikSalonSeansEntity ess
    WHERE ess.etkinlik.etkinlikID = :etkinlikId
    """)
    List<SalonEntity> findSalonlarByEtkinlik(@Param("etkinlikId") Long etkinlikId);

    @Query("""
    SELECT DISTINCT ess.etkinlik FROM EtkinlikSalonSeansEntity ess
    WHERE ess.salon.salonID = :salonId
    """)
    List<EtkinlikEntity> findEtkinliklerBySalon(@Param("salonId") Long salonId);


    @Query("""
    SELECT es.salon, es.seans FROM EtkinlikSalonSeansEntity es
    WHERE es.etkinlik.etkinlikID= :etkinlikId
""")
    List<Object[]> findSalonlarVeSeanslarByEtkinlik(@Param("etkinlikId") Long etkinlikId);

}
