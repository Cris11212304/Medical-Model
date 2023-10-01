import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class MedicalTranscriptionProducer {

    public static void main(String[] args) {

        // Configurar las propiedades del productor
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Crear el productor
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Crear un registro con un mensaje
        ProducerRecord<String, String> record = new ProducerRecord<>("medical_transcriptions", "symptoms", "headache, fever");

        // Enviar el mensaje
        producer.send(record);

        // Cerrar el productor
        producer.close();
    }
}
