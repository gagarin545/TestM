package ru.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;


@Entity
@Table(name="result")
@IdClass(ResultKey.class)
public class ResultEntity {
    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "iddivision",
                    column = @Column(name = "iddivision")),
            @AttributeOverride(name = "timeclose",
                    column =  @Column(name = "timeclose"))
    })
    private int iddivision;
    private Date timeclose;
    @Column(name="kvcount")
    private int kvcount;
    @Column(name="skvcount")
    private int skvcount;
    @Column(name = "namedivision")
    private String namedivision ;
    public ResultEntity() {}

    public Date getTimeclose() {       return timeclose;    }
    public void setTimeclose(Date timeclose) {        this.timeclose = timeclose;    }
    public int getIddivision() {        return iddivision;    }
    public void setIddivision(int iddivision) {        this.iddivision = iddivision;    }
    public String getNamedivision() {        return namedivision;    }
    public void setNamedivision(String namedivision) {        this.namedivision = namedivision;    }
    public int getKvcount() {        return kvcount;    }
    public void setKvcount(int kvcount) {        this.kvcount = kvcount;    }
    public int getSkvcount() {        return skvcount;    }
    public void setSkvcount(int skvcount) {        this.skvcount = skvcount;    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultEntity that = (ResultEntity) o;
        return Objects.equals(timeclose, that.timeclose) &&
                Objects.equals(iddivision, that.iddivision) &&
                Objects.equals(kvcount, that.kvcount) &&
                Objects.equals(skvcount, that.skvcount) &&
                Objects.equals(namedivision, that.namedivision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeclose, iddivision, kvcount, skvcount, namedivision);
    }
}