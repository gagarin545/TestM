package ru.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "incident", schema = "public", catalog = "chel")
public class IncidentEntity {
    @Id
    @Basic
    @Column(name = "n_incident", unique = true)    //№ инцидента
    private long n_incident;
    public long getN_incident() {        return n_incident;    }
    public void setN_incident(long n_incident) {        this.n_incident = n_incident;    }
    @Basic
    @Column(name = "typeincident") //Тип инцидента
    private int typeincident = 1;
    public int getTypeincident() {        return typeincident;    }
    public void setTypeincident(int typeincident) {        this.typeincident = typeincident;    }
    @Basic
    @Column(name = "idcity")   // Код города
    private int idcity;
    public int getIdcity() {        return idcity;    }
    public void setIdcity(int idcity) {        this.idcity = idcity;    }
    @Basic
    @Column(name = "service", nullable = false)   // Услуга
    private long service;
    public long getService() {        return service;    }
    public void setService(long service) {        this.service = service;    }
    @Basic
    @Column(name = "declared", columnDefinition = "text")  // Заявлено
    private String declared;
    public String getDeclared() { return declared;    }
    public void setDeclared(String declared) {        this.declared = declared;    }
    @Basic
    @Column(name = "controlterm")  // Контрольное время
    private Timestamp controlterm;
    public Timestamp getControlterm() {        return controlterm;    }
    public void setControlterm(Timestamp controlterm) {        this.controlterm = controlterm;    }
    @Basic
    @Column(name = "controltermsla")  // Контрольное время Sla
    private String controltermsla;
    public String getControltermsla() {        return controltermsla;    }
    public void setControltermsla(String controltermsla) {        this.controltermsla = controltermsla;    }
    @Basic
    @Column(name = "controltermtask")  // Контрольное время Задачи
    private String controltermtask;
    public String getControltermtask() {        return controltermtask;    }
    public void setControltermtask(String controltermtask) {        this.controltermtask = controltermtask; }
    @Basic
    @Column(name = "createtime")    // Время создания наряда
    private Timestamp createtime;
    public Timestamp getCreatetime() {        return createtime;    }
    public void setCreatetime(Timestamp createtime) {        this.createtime = createtime;    }
    @Basic
    @Column(name = "clazz") // Кл.
    private String clazz;
    public String getClazz() {        return clazz; }
    public void setClazz(String clazz) {        this.clazz = clazz;    }
    @Basic
    @Column(name = "repet") // Повторность.
    private int repet = 0;
    public int getRepet() {        return repet;    }
    public void setRepet(int repet) {        this.repet = repet;    }
    @Basic
    @Column(name = "yield") // Доходность
    private int yield;
    public int getYield() {        return yield;    }
    public void setYield(int yield) {        this.yield = yield;    }
    @Basic
    @Column(name = "decisiontime") // Время Визита
    private Timestamp decisiontime;
    public Timestamp getDecisiontime() {        return decisiontime;    }
    public void setDecisiontime(Timestamp decisiontime) {        this.decisiontime = decisiontime;    }
    @Basic
    @Column(name = "nameclient") // Клиент
    private String nameclient;
    public String getNameclient() {        return nameclient;    }
    public void setNameclient(String nameclient) {        this.nameclient = nameclient;    }
    @Basic
    @Column(name = "labelofservice") // Уровень обслуживания
    private int labelofservice;
    public int getLabelofservice() {       return labelofservice;    }
    public void setLabelofservice(int labelofservice) {        this.labelofservice = labelofservice;    }
    @Basic
    @Column(name = "address", length = 100)   //Адрес
    private String address;
    public String getAddress() {        return address;    }
    public void setAddress(String address) {        this.address = address;    }
    @Basic
    @Column(name = "room", length = 10) //Помещение
    private String room;
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    @Basic
    @Column(name = "phone") // Телефон
    private long phone;
    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
    @Basic
    @Column(name = "techdata", columnDefinition = "text") // Тех. данные
    private String techdata;
    public String getTechdata() {        return techdata;    }
    public void setTechdata(String techdata) {        this.techdata = techdata;    }
    @Basic
    @Column(name = "comment", columnDefinition = "text")   // Комментарии
    private String comment;
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    @Basic
    @Column(name = "timeclose")    // Время закрытия
    private Timestamp timeclose;
    public Timestamp getTimeclose() {        return timeclose;    }
    public void setTimeclose(Timestamp timeclose) {        this.timeclose = timeclose;    }
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idworker", nullable = false)
    private WorkersEntity workersEntity;    //Работник
    public WorkersEntity getWorkersEntity() {        return workersEntity;    }
    public void setWorkersEntity(WorkersEntity workersEntity) {        this.workersEntity = workersEntity;    }
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "iddivision", nullable = false)
    private DivisionEntity divisionEntity;
    public DivisionEntity getDivisionEntity() {        return divisionEntity;    }
    public void setDivisionEntity(DivisionEntity divisionEntity) {        this.divisionEntity = divisionEntity;    }
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idtechnology", nullable = false)
    private TechnogyEntity technogyEntity ;
    public TechnogyEntity getTechnogyEntity() {        return technogyEntity;    }
    public void setTechnogyEntity(TechnogyEntity technogyEntity) {
        this.technogyEntity = technogyEntity;
    }

    public IncidentEntity() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncidentEntity that = (IncidentEntity) o;
        return typeincident == that.typeincident &&
                n_incident == that.n_incident &&
                idcity == that.idcity &&
                service == that.service &&
                repet == that.repet &&
                yield == that.yield &&
                labelofservice == that.labelofservice &&
                phone == that.phone &&
                Objects.equals(declared, that.declared) &&
                Objects.equals(controlterm, that.controlterm) &&
                Objects.equals(controltermsla, that.controltermsla) &&
                Objects.equals(controltermtask, that.controltermtask) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(clazz, that.clazz) &&
                Objects.equals(decisiontime, that.decisiontime) &&
                Objects.equals(nameclient, that.nameclient) &&
                Objects.equals(address, that.address) &&
                Objects.equals(room, that.room) &&
                Objects.equals(techdata, that.techdata) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(timeclose, that.timeclose) &&
                Objects.equals(workersEntity, that.workersEntity) &&
                Objects.equals(divisionEntity, that.divisionEntity) &&
                Objects.equals(technogyEntity, that.technogyEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeincident, n_incident, idcity, service, declared, controlterm, controltermsla, controltermtask, createtime, clazz, repet, yield, decisiontime, nameclient, labelofservice, address, room, phone, techdata, comment, timeclose, workersEntity, divisionEntity, technogyEntity);
    }
}
