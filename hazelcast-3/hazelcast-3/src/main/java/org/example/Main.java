package org.example;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class Main {
    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("localhost:5701");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap<Integer, Person> map = client.getMap("people");

        for (int i = 0; i < 10000; i++) {
            map.put(i, new Person("Person-" + i));
        }

        System.out.println("Put 10,000 Person objects.");

        for (int i = 0; i < 5; i++) {
            System.out.println("Got: " + map.get(i));
        }

        client.shutdown();
    }
}