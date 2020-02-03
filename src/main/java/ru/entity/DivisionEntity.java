package ru.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "division", schema = "public", catalog = "chel")
public class DivisionEntity {

    @Id
    @Column(name = "iddivision")
    private long iddivision;
    @Column(name = "namedivision", length = 150)
    private String namedivision ;
    @Column(name = "idcity", length = 8)
    private Integer idcity;
    public DivisionEntity() {} // Конструктор

    public long getIddivision() {        return iddivision;    }
    public void setIddivision(long iddivision) {        this.iddivision = iddivision;    }
    public String getNamedivision() {        return namedivision;    }
    public void setNamedivision(String namedivision) {        this.namedivision = namedivision;    }
    public Integer getIdcity() {        return idcity;    }
    public void setIdcity(Integer idcity) {        this.idcity = idcity;    }
}

