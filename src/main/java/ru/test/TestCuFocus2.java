package ru.test;

import org.snmp4j.smi.OID;
import ru.entity.ViewTest;
import ru.utils.SnmpCommand;

import java.io.IOException;

public class TestCuFocus2 extends SnmpCommand implements TestInterface {
    private String ifindex, chindex;

    public TestCuFocus2() {
        this.ifindex = String.valueOf(Nport(viewTest.getSlot(), viewTest.getPort(), "00"));
        this.chindex = String.valueOf(Nport(viewTest.getSlot(),viewTest.getPort(),  "01"));
        setAddress("udp:" + viewTest.getIp_address() + "/161");
    }

    @Override
    public ViewTest test() throws IOException {
        viewTest.setStatus(getAsString(new OID(SMI + "1286.1.3.18.2.1.1.1.7." + ifindex)));   //состояние линии
        viewTest.setProfil(getAsString(new OID(SMI + "1286.1.3.18.1.5.1.1.1.2." + ifindex)));   //тек. профиль
        viewTest.setInit_count(getAsString(new OID(SMI + "1286.1.3.18.1.4.1.2.1.6." + ifindex)));   // инициализации
        viewTest.setSnr_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.6." + ifindex + ".1.1")))); // сигнал шум к клиента
        viewTest.setSnr_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.6." + ifindex + ".2.1")))); // сигнал шум от клиента
        viewTest.setL_Attenuation_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.4." + ifindex + ".1.1")))); // затухание линии к клиента
        viewTest.setL_Attenuation_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.4." + ifindex + ".2.1")))); // затухание линии от клиента
        viewTest.setS_Attenuation_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.5." + ifindex + ".1.1")))); // затухание сигнала к клиента
        viewTest.setS_Attenuation_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.5." + ifindex + ".2.1")))); // затухание сигнала от клиента
        viewTest.setPower_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.1.1.13." + ifindex)))); // вых. мощность к клиента
        viewTest.setPower_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.1.1.14." + ifindex)))); // вых. мощность от клиента
        viewTest.setV_previous_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.2.1.4." + chindex + ".1")))); // v предыдущая к клиента
        viewTest.setV_previous_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.2.1.4." + chindex + ".2")))); // v предыдущая от клиента
        viewTest.setV_previous_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.2.1.3." + chindex + ".1")))); // v текущая к клиента
        viewTest.setV_current_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.2.1.3." + chindex + ".2")))); // v текущая от клиента
        viewTest.setV_max_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.1.1.9." + ifindex)))); // v max к клиента
        viewTest.setV_max_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.18.1.1.1.1.10." + ifindex)))); // v max от клиента
        return viewTest;
    }
}
