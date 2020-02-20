package ru.test;

import org.snmp4j.smi.OID;
import ru.entity.ViewTest;
import ru.utils.SnmpCommand;
import java.io.IOException;

public class TestEthernetSwitch extends SnmpCommand implements TestInterface {
    private ViewTest viewTest;

    public TestEthernetSwitch(ViewTest viewTest) {
        this.viewTest = viewTest;
    }

    @Override
    public ViewTest test() throws IOException {
        String ont = viewTest.getPort();
        setAddress("udp:" + viewTest.getIp_address() + "/161");
        viewTest.setStatus(getAsString(new OID("1.3.6.1.2.1.2.2.1.7." + ont))); //Состояние
        viewTest.setDescription(getAsString(new OID("1.3.6.1.2.1.2.2.1.8." + ont))); // Адм состояние
        viewTest.setSn(getAsString(new OID("1.3.6.1.2.1.16.1.1.1.5." + ont)));   // Пакетов
        viewTest.setInit_count(getAsString(new OID("1.3.6.1.2.1.16.1.1.1.8." + ont)));    // CRC ошибки
        viewTest.setStatus_port1(getAsString(new OID("1.3.6.1.2.1.2.2.1.14." + ont)));  // InError
        viewTest.setStatus_port2(getAsString(new OID("1.3.6.1.2.1.2.2.1.20." + ont)));    // outError
        viewTest.setMacAddress(getAsString(new OID("1.3.6.1.2.1.10.7.2.1.16." + ont)));   // Mac address
        return viewTest;
    }
}
