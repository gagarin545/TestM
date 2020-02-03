package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.WorkerResultEntity;

import java.util.List;

public interface WorkerResultRepository extends JpaRepository<WorkerResultEntity, Long> {
    @Query(value="SELECT  date(timeclose) as timeclose, i.idworker, count(*), COALESCE(NULLIF(w.name,''), 'Неназначенно') as name from incident i, workers w where i.idworker = w.idworker and i.iddivision in :iddivision and EXTRACT(WEEK from current_date) - 1 = EXTRACT(WEEK from timeclose)  group by date(timeclose), i.idworker,  w.name order by timeclose", nativeQuery = true)
    List<WorkerResultEntity> findByallWorker(@Param("iddivision") int[] iddivision);
}
