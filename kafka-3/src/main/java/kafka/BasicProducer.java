package main.java.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.google.gson.Gson;

public class BasicProducer {
    public static final String TOPIC = "hello-world-topic";

    public static void main(String[] args) {
        System.out.println("*** Starting Basic Producer ***");

        Properties settings = new Properties();
        settings.put("client.id", "basic-producer");
        settings.put("bootstrap.servers", "localhost:29092");
        settings.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        settings.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(settings);
        Gson gson = new Gson();

        for (int i = 1; i <= 5; i++) {
            Student student = new Student(i, "Student" + i);
            String json = gson.toJson(student);
            System.out.println("### Sending: " + json);
            producer.send(new ProducerRecord<>(TOPIC, "student-" + i, json));
        }

        producer.close();
    }
}
