package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.ResultEntity;

import java.util.List;

public interface ResultEntityRepository extends JpaRepository<ResultEntity, Long> {
    @Query(value="select * from result  where iddivision in :iddivision order by iddivision, timeclose", nativeQuery = true)
    List<ResultEntity> findByOnDivision(@Param("iddivision") Integer[] iddivision);

}
