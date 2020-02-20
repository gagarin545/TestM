package ru.test;

import org.snmp4j.smi.OID;
import ru.entity.ViewTest;
import ru.utils.SnmpCommand;

import java.io.IOException;


public class TestCuFocus extends SnmpCommand implements TestInterface {
    private ViewTest viewTest;
    public TestCuFocus(ViewTest viewTest) {
        this.viewTest = viewTest;
    }

    @Override
    public ViewTest test() throws IOException {
        String ifindex = String.valueOf(Nport(viewTest.getPort(), viewTest.getSlot(), "00"));
        String chindex = String.valueOf(Nport(viewTest.getPort(), viewTest.getSlot(), "01"));
        setAddress("udp:" + viewTest.getIp_address() + "/161");
        viewTest.setStatus(getAsString(new OID(SMI + "1286.1.3.9.2.1.1.1.7." + ifindex))); //состояние линии
        viewTest.setProfil(getAsString(new OID(SMI + "1286.1.3.9.1.5.1.1.1.2." + ifindex))); //тек. профиль
        viewTest.setInit_count(getAsString(new OID(SMI + "1286.1.3.9.1.4.1.2.1.6." + ifindex))); // инициализации
        viewTest.setSnr_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.13." + ifindex))) / 10); // сигнал шум к клиент
        viewTest.setSnr_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.14." + ifindex))) / 10); // сигнал шум от клиента
        viewTest.setL_Attenuation_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.9." + ifindex))) / 10); // затухание линии к клиент
        viewTest.setL_Attenuation_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.10." + ifindex))) / 10); // затухание линии от клиента
        viewTest.setS_Attenuation_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.11." + ifindex))) / 10); // затухание сигнала к клиента
        viewTest.setS_Attenuation_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.12." + ifindex))) / 10); // затухание сигнала от клиента
        viewTest.setPower_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.19." + ifindex))) / 10); // вых. мощность к клиента
        viewTest.setPower_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.20." + ifindex))) / 10); // вых. мощность от клиента
        viewTest.setV_previous_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.2.1.4." + chindex + ".1"))) / 1000); // v предыдущая к клиента
        viewTest.setV_previous_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.2.1.4." + chindex + ".2"))) / 1000); // v предыдущая от клиента
        viewTest.setV_current_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.2.1.3." + chindex + ".1"))) / 1000); // v текущая к клиента
        viewTest.setV_current_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.2.1.3." + chindex + ".2"))) / 1000); // v текущая от клиента
        viewTest.setV_max_out(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.15." + ifindex))) / 1000); // v max к клиента
        viewTest.setV_max_in(Float.parseFloat(getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.16." + ifindex))) / 1000); // v max от клиента
        return viewTest;
    }
}
