package ru.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(KeyWorkerResult.class)
public class WorkerResultEntity {
    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "idworker",
                    column = @Column(name = "idworker")),
            @AttributeOverride(name = "timeclose",
                    column =  @Column(name = "timeclose"))
    })
    @Column(name = "idworker")
    private Integer idworker;
    @Column(name = "name")
    private String name;
    @Column(name = "timeclose")
    private Date timeclose;
    @Column(name = "count")
    private Integer count;

    public WorkerResultEntity() {}

    public Integer getIdworker() {        return idworker;    }
    public void setIdworker(Integer idworker) {        this.idworker = idworker;    }
    public Date getTimeclose() {        return timeclose;    }
    public void setTimeclose(Date timeclose) {        this.timeclose = timeclose;    }
    public Integer getCount() {        return count;    }
    public void setCount(Integer count) {        this.count = count;    }
    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerResultEntity that = (WorkerResultEntity) o;
        return Objects.equals(idworker, that.idworker) &&
                Objects.equals(name, that.name) &&
                Objects.equals(timeclose, that.timeclose) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idworker, name, timeclose, count);
    }
}
