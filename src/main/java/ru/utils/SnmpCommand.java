package ru.utils;

import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import java.io.IOException;

public abstract class SnmpCommand
{
    protected String SMI = ".1.3.6.1.4.1.";
    private Snmp snmp = null;
    private String address;
    private ResponseEvent event;

    protected void setAddress(String address) {
        this.address = address;
        try {
            TransportMapping transport = new DefaultUdpTransportMapping();
            snmp = new Snmp(transport);
            transport.listen();
        } catch ( IOException er) {
            er.printStackTrace();
            System.out.println("Errors address"); }
    }

    protected String getAsString(OID oid) throws IOException {
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(oid));
        pdu.setType(PDU.GET);
        event = snmp.send(pdu, target("public"));
        if(event.getResponse() == null) return "";
        return event.getResponse().get(0).getVariable().toString();
    }

    protected String getAsString(OID oid, Integer val) throws IOException {
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(oid, new Integer32(val)));
        pdu.setType(PDU.SET);
        snmp.set(pdu, target("private"));
        if(event.getResponse() == null) return "";
        return event.getResponse().get(0).getVariable().toString();
    }

    protected String getAsString(OID oid, String val) throws IOException {
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(oid, new OctetString(val)));
        pdu.setType(PDU.SET);
        event = snmp.set(pdu, target("private"));
        if(event.getResponse() == null) return "";
        return event.getResponse().get(0).getVariable().toString();
    }

    private Target target( String Type) {
        Address targetAddress = GenericAddress.parse(address);
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(Type));
        target.setAddress((Address) targetAddress);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        return target;
    }
    protected static int Nport(String p, String sl, String l){
        if(sl == null)  return 0;
        int i = Integer.parseInt(sl);
        if ( i < 32 )
            return Integer.parseInt(String.format("%4s%5s%2s%15s"
                    , Integer.toBinaryString(Integer.parseInt(p))
                    , Integer.toBinaryString(i)
                    , l
                    , ' ').replace(' ', '0') , 2);
        else
        if( i == 64 )
            return Integer.parseInt(String.format("%4s%5s%2s%8s%7s"
                    , Integer.toBinaryString(Integer.parseInt(p))
                    , Integer.toBinaryString(i - 64)
                    , l
                    ,'1'
                    ,' ').replace(' ', '0') , 2);
        else
            return Integer.parseInt(String.format("%4s%5s%2s%9s%6s"
                    , Integer.toBinaryString(Integer.parseInt(p))
                    , Integer.toBinaryString(i - 32)
                    , l
                    , '1'
                    , ' ').replace(' ', '0') , 2);
    }
}
