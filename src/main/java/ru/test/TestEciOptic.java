package ru.test;

import ru.entity.ViewTest;

import java.io.IOException;

public class TestEciOptic implements TestInterface {
    private String service;
    private ViewTest viewTest;

    public TestEciOptic(ViewTest viewTest, String service) {
        this.viewTest = viewTest;
        this.service = service;
    }

    @Override
    public ViewTest test() throws IOException {
        String url = "http://10.183.116.238/cgi-bin/getline.cgi?uslogin=";
       // System.out.println( service);

        (new GetResultPage(url + service).getResultTest().lines())
                .forEach(x-> {
                    String[] s = x.split(":");
                    switch (s[0].trim()) {
                        case "ONT_SW_Version":
                            viewTest.setOntVersion(s[1]);
                            break;
                        case "MAC Address":
                            viewTest.setMacAddress(s[1]);
                            break;
                        case "Port_Profile":
                            viewTest.setProfil(s[1]);
                        case "ONT_distance":
                            viewTest.setDistance(s[1]);
                            break;
                        case "Rx":
                        case "Rx_Power":
                            if(s[0].contains("inf"))
                                viewTest.setPower_in(1.0f);
                            else
                                viewTest.setPower_in(Float.parseFloat(s[1]));
                            if( viewTest.getPower_in() != 0 ) viewTest.setStatus("1");
                            break;
                    }
                });
        return viewTest;
    }
}
