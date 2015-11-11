package io.iron.jmsdemo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;

public class IronMqExampleRoute extends RouteBuilder {
    private final String ironMqEndpoint = "ironmq:examplequeue?projectId={{projectid}}&token={{token}}&maxMessagesPerPoll=50&ironMQCloud=https://mq-aws-eu-west-1-1.iron.io";

    @Override
    public void configure() throws Exception {
        PropertiesComponent pc = new PropertiesComponent();
        pc.setLocation("classpath:ironmq.properties");
        getContext().addComponent("properties", pc);

        from("activemq:queue:toironmq").routeId("ironmq-producer-route")
            .convertBodyTo(String.class)
            .to(ironMqEndpoint);

        from(ironMqEndpoint).routeId("ironmq-subscriber-route")
            .convertBodyTo(String.class)
            .log("${body}")
            .to("activemq:queue:fromironmq");
    }

}
