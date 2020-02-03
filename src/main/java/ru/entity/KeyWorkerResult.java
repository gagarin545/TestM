package ru.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Embeddable
public class KeyWorkerResult implements Serializable {
    private Date timeclose;
    private Integer idworker;
    public KeyWorkerResult() {}
    public KeyWorkerResult(Date timeclose, Integer idworker) {
        this.timeclose = timeclose;
        this.idworker = idworker;
    }

    public Date getTimeclose() {        return timeclose;    }
    public void setTimeclose(Date timeclose) {        this.timeclose = timeclose;    }
    public Integer getIdworker() {        return idworker;    }
    public void setIdworker(Integer idworker) {        this.idworker = idworker;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyWorkerResult that = (KeyWorkerResult) o;
        return Objects.equals(timeclose, that.timeclose) &&
                Objects.equals(idworker, that.idworker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeclose, idworker);
    }
}
