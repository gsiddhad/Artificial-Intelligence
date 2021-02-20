/*
 *  TopicReceiver.java / Send Message on Topic
 *  Author : Gourav Siddhad
 */

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.messaging.TopicManagementHelper;
import jade.core.messaging.TopicManagementService;

public class TopicReceiver extends Agent {
	protected void setup() {
		try {
			TopicManagementHelper topicHelper = (TopicManagementHelper) getHelper(TopicManagementHelper.SERVICE_NAME);
			final AID topic = topicHelper.createTopic("ping");
			topicHelper.register(topic);

			addBehaviour(new CyclicBehaviour(this) {
				public void action() {
					ACLMessage msg = myAgent.receive(MessageTemplate.MatchTopic(topic));
					if (msg != null)
						System.out.println(" Agent " + myAgent.getLocalName() + ": Message about topic - "
								+ topic.getLocalName() + " received. Content is " + msg.getContent());
					else
						block();
				}
			});
		} catch (Exception e) {
			System.err.println("Agent " + getLocalName() + " : ERROR registering to topic \"ping\"");
			e.printStackTrace();
		}
	}
}
