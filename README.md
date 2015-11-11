ironmq-jms-example
==================

*	Download apache activemq from http://activemq.apache.org/download.html. Extract and run bin/activemq console (jdk 6 or 7 is required)
*	Clone git@github.com:pax95/camel-ironmq.git and run maven -> mvn clean install
*	Clone git@github.com:pax95/ironmq-jms-example.git
*	Edit the ironmq.properties file in src/main/resources and provide the ironmq token, projectid and queue (Project has to be created on Ironmq Cloud AWS US-East)
*	run mvn camel:run to start the jms <-> ironmq example
*	open the activemq web console at http://localhost:8161/admin and login with admin/admin
*	There should be 1 queue listet = toironmq
*	send a message to the queue using the gui link 'send to'. Provide a message body and press send
*	The jms message will be send to the ironmq queue, consumed and enqueued on another activemq queue = fromironmq.


