package com.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Service;

@Service
public class TestMqttService {

    public void init() {

        var topic = "MQTT Examples";
        var content = "Message from MqttPublishSample";
        var qos = 2;
        var broker = "tcp://172.100.10.101:1883";
        var clientId = "charles";
        var persistence = new MemoryPersistence();

        try {
            var sampleClient = new MqttClient(broker, clientId, persistence);
            var connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName("charles");
            connOpts.setPassword("123".toCharArray());
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: " + content);
            var message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
//            sampleClient.disconnect();
//            System.out.println("Disconnected");
//            new Ouvinte(sampleClient);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

}
