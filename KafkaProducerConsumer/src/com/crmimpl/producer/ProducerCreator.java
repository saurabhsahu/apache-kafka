package com.crmimpl.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import com.crmimpl.intf.IKafkaConstants;
import com.crmimpl.producer.partion.CustomPartitioner;

public class ProducerCreator {

	public static Producer<Long, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.KAFKA_BROKERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, IKafkaConstants.CLIENT_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class.getName());
        return new KafkaProducer<>(props);
    }
}


/*
 * BOOTSTRAP_SERVERS_CONFIG: The Kafka broker's address. If Kafka is running in a cluster 
 * then you can provide comma (,) seperated addresses.
 * 
 * CLIENT_ID_CONFIG: Id of the producer so that the broker can determine the source of the request.
 * 
 * KEY_SERIALIZER_CLASS_CONFIG: The class that will be used to serialize the key object. 
In our example, our key is Long, so we can use the LongSerializer class to serialize the key. 
If in your use case you are using some other object as the key then you can create your custom 
serializer class by implementing the Serializer interface of Kafka and overriding the serialize method.

VALUE_SERIALIZER_CLASS_CONFIG: The class that will be used to serialize the value object. 
In our example, our value is String, so we can use the StringSerializer class to serialize the key. 
If your value is some other object then you create your custom serializer class.

*PARTITIONER_CLASS_CONFIG: The class that will be used to determine the partition in which the record will go. 
*In the demo topic, there is only one partition, so I have commented this property. 
*You can create your custom partitioner by implementing the CustomPartitioner interface.:
*
*
*/
	
	