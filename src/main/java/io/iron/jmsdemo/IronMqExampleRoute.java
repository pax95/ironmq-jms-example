package io.iron.jmsdemo;

import org.apache.camel.builder.RouteBuilder;

public class IronMqExampleRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("activemq:queue:toironmq").routeId("ironmq-producer-route").convertBodyTo(String.class)
				.to("ironmq://{{queue}}?projectId={{projectid}}&token={{token}}&preserveHeaders=true");

		from("ironmq://{{queue}}?projectId={{projectid}}&token={{token}}&maxMessagesPerPoll=50&preserveHeaders=true")
				.routeId("ironmq-subscriber-route").convertBodyTo(String.class).to("activemq:queue:fromironmq");
	}

}
