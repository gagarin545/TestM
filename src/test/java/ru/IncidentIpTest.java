package ru;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.snmp4j.smi.OID;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.entity.IncidentEntity;
import ru.entity.ViewTest;
import ru.service.IncidentService;
import ru.test.*;
import ru.utils.SnmpCommand;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IncidentIpTest extends SnmpCommand {
    @Resource
    private IncidentService incidentService;

    @Test
    public void test() throws IOException {
        int[] id = {4};
        String url_get_page = "http://10.183.116.238/cgi-bin/getTechData.php?svc=";
        List<IncidentEntity> incidentEntities =  incidentService.incidentlist( id);
        final int[] i = {0};
        ViewTest viewTest = new ViewTest();

        incidentEntities.forEach( incident-> {
            String s = incident.getTechdata();
           //System.out.println(s);

            if(s.contains("[") && !s.contains("[КСА")) {
                   if((s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]")).length() < 15)) {
                       viewTest.setIp_address(s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]")));
                       setAddress("udp:" + viewTest.getIp_address() + "/161");
                   }
                   switch ((int) incident.getTechnogyEntity().getIdTechnology()) {
                       case 1:
                       case 2:
                       case 4:
                       case 8:
                           if(s.contains("DSL")) {
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

                                   System.out.println(getAsString(new OID(".1.3.6.1.2.1.1.1.0")));
                                   switch (getAsString(new OID(".1.3.6.1.2.1.1.1.0"))) {
                                       case "ECI telecom HiFOCuS broadband access system":
                                           System.out.println("!! >"  + getAsString(new OID(SMI + "1286.1.3.3.1.1.2.131072")));
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
                                                   //new TestCuFocus(String.valueOf(Binary.Nport(viewTest.getPort(),viewTest.getSlot(), "00")), String.valueOf(Binary.Nport(viewTest.getPort(),viewTest.getSlot(),  "01"))).test();  // комманды
                                                   new TestCuFocus(viewTest).test();  // комманды
                                                   break;
                                               default:
                                                   System.out.println(getAsString(new OID(SMI + "1286.1.3.3.1.1.2.131072")));
                                           }
                                           break;
                                   }
                               } catch (IOException e) {
                                       e.printStackTrace();
                               } catch (StringIndexOutOfBoundsException e) {
                                   System.out.println("    Ex-> " + s + "tech=" + incident.getTechnogyEntity().getMameTechnology());
                               } catch (ArrayIndexOutOfBoundsException e) {
                                   System.out.println("Errors --->" + s);
                               }
                               catch (IndexOutOfBoundsException e) {
                                   System.out.println("Errors Index --->" + s + "|" + s.substring(s.lastIndexOf("]")).replace(")", "").split("-").length);
                               }
                           }

                           break;
                       case 3: // PON
                           try {
                               viewTest.setSlotPortOnt(Arrays.stream((new GetResultPage(url_get_page + incident.getService()).getResultTest().readLine()).split(";"))
                                       .skip(4)
                                       .collect(Collectors.toList()));
                               System.out.println(getAsString(new OID(".1.3.6.1.2.1.1.1.0")));
                               switch (getAsString(new OID(".1.3.6.1.2.1.1.1.0"))) {
                                   case "ECI telecom HiFOCuS broadband access system":
                                       new TestEciOptic(viewTest, String.valueOf(incident.getService())).test();
                                       break;
                                   case "Huawei Integrated Access Software":
                                       new TestOpticHuawei(viewTest).test();
                                         //status = testing.test(String.valueOf(4194304000L + 8192 * Integer.parseInt(viewTest.getPort()) + 256 * Integer.parseInt(viewTest.getSlot()) ), viewTest.getSlot(), viewTest.getOnt(), 3);  // комманды;
                                       break;
                               }
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                           break;
                       case 5: // FTTx
                           System.out.println(incident.getTechnogyEntity().getMameTechnology() + "|" + incident.getTechdata());
                           viewTest.setPort(Arrays.stream(s.substring( s.lastIndexOf("]") + 1).replace("-", "").trim().split(" ")).findFirst().get());
                           try {
                               new TestEthernetSwitch(viewTest).test();
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                           break;
                   }
               System.out.println(viewTest.toString() );
               i[0]++;
           }
        });

        System.out.println("size=" + incidentEntities.size() + "|" + i[0]);

    }
    static Boolean isNumber(String s) {
        try{            Integer.parseInt(s.trim());        } catch (NumberFormatException e) {            return false;        }
        return true;
    }



 }