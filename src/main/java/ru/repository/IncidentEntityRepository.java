package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.IncidentEntity;

import java.util.List;

public interface IncidentEntityRepository extends JpaRepository<IncidentEntity, Long> {
    @Query("select b from IncidentEntity b where b.n_incident = :n_incident")
    IncidentEntity findByNumer(@Param("n_incident") long n_incident);

    @Query(value="select * from incident b where timeclose + time'00:20' > (select max(timeclose) from incident) and iddivision in :iddivision", nativeQuery = true)
    List<IncidentEntity> findByallontime(@Param("iddivision") int[] iddivision);

    @Query(value="select * from incident b where timeclose > current_date - 1 and iddivision in :iddivision and timeclose + time'00:20' > (select max(timeclose) from incident) and controlterm between current_timestamp and current_timestamp + time'04:00'", nativeQuery = true)
    List<IncidentEntity> findByallPeriod4(@Param("iddivision") int[] iddivision);

    @Query(value="select * from incident b where iddivision in :iddivision and timeclose + time'00:20' > (select max(timeclose) from incident)  and ( clazz ~ 'ЮЛ' OR (controlterm < current_timestamp + time'04:00')) order by clazz DESC, controlterm DESC", nativeQuery = true)
    List<IncidentEntity> findByallburning(@Param("iddivision") int[] iddivision);

    @Query(value="select * from incident b where decisiontime > current_date - :days and iddivision in :iddivision ORDER by iddivision, typeincident, decisiontime", nativeQuery = true)
    List<IncidentEntity> findByAllTillThisDay(@Param("iddivision") int[] iddivision, @Param("days") int days);

    @Query(value="select * from incident b where decisiontime > (current_date - 30) and iddivision in :iddivision and repet > 0 ORDER by iddivision, typeincident, decisiontime", nativeQuery = true)
    List<IncidentEntity> findByAllRepet(@Param("iddivision") int[] iddivision);

    @Query(value="select * from incident b where timeclose > current_date - :days and iddivision in :iddivision and (controltermtask ~ 'СКВ' OR controlterm < current_timestamp OR controltermsla ~ 'СКВ')", nativeQuery = true)
    List<IncidentEntity> findByallOverdueonDay(@Param("iddivision") int[] iddivision, @Param("days") int days);


}
