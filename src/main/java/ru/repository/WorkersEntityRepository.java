package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.WorkersEntity;

public interface WorkersEntityRepository extends JpaRepository<WorkersEntity, Long> {
    @Query(value = "select * from Workers b where lower( replace(b.name,' ','')) = :name", nativeQuery = true)
    WorkersEntity findByName(@Param("name") String name);
    @Query("select b from WorkersEntity b where b.imei = :imei")
    WorkersEntity findByimei(@Param("imei") String imei);
    @Query("select b from WorkersEntity b where b.idworker = :idworker")
    WorkersEntity findById(@Param("idworker") int idworker);
}
