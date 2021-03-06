package ru.test;

import org.snmp4j.smi.OID;
import ru.entity.IncidentEntity;
import ru.entity.ViewTest;
import ru.utils.SnmpCommand;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StoreTest extends SnmpCommand implements TestInterface {
    private IncidentEntity incident;

    public StoreTest(IncidentEntity incident) {
        this.incident = incident;
    }

    @Override
    public ViewTest test() throws IOException {
        ViewTest viewTest = new ViewTest();
        viewTest.setService(incident.getService());
        String s = incident.getTechdata();
        //System.out.println(s);
        System.out.println("Тестирую ->" + incident.getService());

        if (s.contains("[") && !s.contains("[КСА")) {
            if ((s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]")).length() < 15)) {
                viewTest.setIp_address(s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]")));
                setAddress("udp:" + viewTest.getIp_address() + "/161");
            }
            switch ((int) incident.getTechnogyEntity().getIdTechnology()) {
                case 1:
                case 2:
                case 4:
                case 8:
                    if (s.contains("DSL")) {
                        try {
                            viewTest.setSlotPort(Arrays.stream(s.substring(s.lastIndexOf("]")).replace(")", "").split("-"))
                                    .skip(1)
                                    .limit(3)
                                    .dropWhile(x -> x.contains("DSL"))
                                    .limit(2)
                                    .map(x ->
                                            Arrays.stream(x.trim().split(""))
                                                    .takeWhile(k -> !k.equals(" ") && !k.equals(";"))
                                                    .reduce((a, b) -> a + b)
                                                    .get()
                                    )
                                    .collect(Collectors.toList()));

                          //  System.out.println(getAsString(new OID(".1.3.6.1.2.1.1.1.0")));
                            if ("ECI telecom HiFOCuS broadband access system".equals(getAsString(new OID(".1.3.6.1.2.1.1.1.0")))) {
                                switch (getAsString(new OID(SMI + "1286.1.3.3.1.1.2.131072"))) {
                                    case "IPNI_APP_2.52.35":
                                        new TestCuFocus(viewTest).test();   // комманды
                                        break;
                                    case "mini_ge_9.01.48":
                                        new TestCuFocus2(viewTest).test();
                                        break;
                                    case "IPNI_HB_APP_2.00.73":
                                    case "se_10.01.64":
                                    case "se_10.01.65":
                                        new TestCuFocus(viewTest).test();  // комманды
                                        break;
                                    default:
                                        System.out.println(getAsString(new OID(SMI + "1286.1.3.3.1.1.2.131072")));
                                }
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            System.out.println("    Ex-> " + s + "tech=" + incident.getTechnogyEntity().getMameTechnology());
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Errors --->" + s);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Errors Index --->" + s + "|" + s.substring(s.lastIndexOf("]")).replace(")", "").split("-").length);
                        }
                    }

                    break;
                case 3: // PON
                    try {
                        viewTest.setSlotPortOnt(Arrays.stream((new GetResultPage("http://10.183.116.238/cgi-bin/getTechData.php?svc=" + incident.getService()).getResultTest().readLine()).split(";"))
                                .collect(Collectors.toList()));
                        switch (getAsString(new OID(".1.3.6.1.2.1.1.1.0"))) {
                            case "ECI telecom HiFOCuS broadband access system":
                                new TestEciOptic(viewTest, String.valueOf(incident.getService())).test();
                                break;
                            case "Huawei Integrated Access Software":
                                new TestOpticHuawei(viewTest).test();
                                break;
                            default:
                                System.out.println(getAsString(new OID(".1.3.6.1.2.1.1.1.0")));
                        }
                    } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("    Ex-> " + incident.getService() + "tech=" + incident.getTechnogyEntity().getMameTechnology());
                    }
                    break;
                case 5: // FTTx
                   // System.out.println(incident.getTechnogyEntity().getMameTechnology() + "|" + incident.getTechdata());
                    viewTest.setPort(Arrays.stream(s.substring(s.lastIndexOf("]") + 1).replace("-", "").trim().split(" ")).findFirst().get());
                    System.out.println("ip-" + viewTest.getIp_address() + " port=" + viewTest.getPort());
                    new TestEthernetSwitch(viewTest).test();
                    break;
            }
        }
        System.out.print(viewTest.toString());
        return viewTest;
    }
}
