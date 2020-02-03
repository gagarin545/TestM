package ru.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Embeddable
public class ResultKey implements Serializable {
    private Date timeclose;
    private int iddivision;
    ResultKey(){}
    public ResultKey(Date timeclose, int iddivision ) {
        this.iddivision = iddivision;
        this.timeclose = timeclose;
    }

    public int getIddivision() {        return iddivision;    }
    public void setIddivision(int iddivision) {        this.iddivision = iddivision;    }
    public Date getTimeclose() {        return timeclose;    }
    public void setTimeclose(Date timeclose) {        this.timeclose = timeclose;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultKey resultKey = (ResultKey) o;
        return iddivision == resultKey.iddivision &&
                Objects.equals(timeclose, resultKey.timeclose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeclose, iddivision);
    }
}
