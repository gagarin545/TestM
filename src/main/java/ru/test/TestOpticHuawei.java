package ru.test;

import org.snmp4j.smi.OID;
import ru.entity.ViewTest;
import ru.utils.SnmpCommand;

import java.io.IOException;

public class TestOpticHuawei extends SnmpCommand implements TestInterface {
    private ViewTest viewTest;

    public TestOpticHuawei(ViewTest viewTest) {
        this.viewTest = viewTest;
    }

    @Override
    public ViewTest test() throws IOException {
        String ifindex = String.valueOf(4194304000L + 8192 * Integer.parseInt(viewTest.getSlot()) + 256 * Integer.parseInt(viewTest.getPort()));
        String chindex = viewTest.getPort();
        String ont =  viewTest.getOnt();
        setAddress("udp:" + viewTest.getIp_address() + "/161");
        viewTest.setStatus(getAsString(new OID(SMI + "2011.6.128.1.1.2.46.1.15." + ifindex + '.' + ont)));
        viewTest.setDescription(getAsString(new OID(SMI + "2011.6.128.1.1.2.43.1.9." + ifindex + '.' + ont)));     //  описание
        viewTest.setSn(getAsString(new OID(SMI + "2011.6.128.1.1.2.43.1.3." + ifindex + '.' + ont)));           //  sn
        viewTest.setPasswd(getAsString(new OID(SMI + "2011.6.128.1.1.2.43.1.4." + ifindex + '.' + ont)));    //  pass
        viewTest.setOntVersion(getAsString(new OID(SMI + "2011.6.128.1.1.2.45.1.5." + ifindex + '.' + ont)));    //  версия ont
        viewTest.setPower_in(Float.parseFloat(getAsString(new OID(SMI + "2011.6.128.1.1.2.51.1.4." + ifindex + '.' + ont)))/100);    //  RxPower
        viewTest.setDistance(getAsString(new OID(SMI + "2011.6.128.1.1.2.46.1.20." + ifindex + '.' + ont)));    //  Distance
        viewTest.setStatus_port1(getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".1")));  //состояние порта 1
        viewTest.setV_port1(getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".1")));  // скорость порта 1
        viewTest.setStatus_port2(getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".2")));  //состояние порта 2
        viewTest.setV_port2(getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".2")));  //скорость порта 1
        viewTest.setStatus_port3(getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".3")));  //состояние порта 3
        viewTest.setV_port3(getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".3")));  //скорость порта 1
        viewTest.setStatus_port4(getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".4")));  //состояние порта 4
        viewTest.setV_port4(getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".4")));  //скорость порта 1
        return viewTest;
    }
}
