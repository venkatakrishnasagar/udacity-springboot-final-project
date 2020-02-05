package com.example.demo;
import com.splunk.*;
import java.util.HashMap;
import java.util.Map;

public class SplunkSDKConnector {
    public static Receiver sendLogsToSplunk(String main, String event) {
        HttpService.setSslSecurityProtocol(SSLSecurityProtocol.TLSv1_2);
        Map<String, Object> connectionArgs = new HashMap<String, Object>();
        connectionArgs.put("host", "DESKTOP-HCTONNJ");
        connectionArgs.put("username", "sagaryvk");
        connectionArgs.put("password", "Sagar.9014");
        connectionArgs.put("port", 8089);
        connectionArgs.put("scheme", "https");
        Service splunkService = Service.connect(connectionArgs);
        System.out.println("Auth Token : " + splunkService.getToken());
        Receiver receiver = splunkService.getReceiver();
        Args logArgs = new Args();
        logArgs.put("sourcetype", "E-Commerce Application");
//        receiver.log("main",logArgs,"Hello Splunk Event");
        receiver.log(main, logArgs, event);
        return receiver;
    }
}

