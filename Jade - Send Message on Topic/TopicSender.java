/*
 *  TopicSender.java / Send Message on Topic
 *  Author : Gourav Siddhad
 */

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.messaging.TopicManagementHelper;
import jade.core.messaging.TopicManagementService;
import jade.lang.acl.ACLMessage;

public class TopicSender extends Agent {
	protected void setup() {
		try {
			TopicManagementHelper topicHelper = (TopicManagementHelper) getHelper(TopicManagementHelper.SERVICE_NAME);
			final AID topic = topicHelper.createTopic("ping");

			addBehaviour(new TickerBehaviour(this, 10000) {
				public void onTick() {
					System.out.println(" Agent " + myAgent.getLocalName() + " : Sending message about topic - "
						+ topic.getLocalName());
					ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
					msg.addReceiver(topic);
					msg.setContent(String.valueOf(getTickCount()));
					myAgent.send(msg);
				}
			});
		} catch (Exception e) {
			System.err.println("Agent " + getLocalName() + " : ERROR creating topic \"ping\"");
			e.printStackTrace();
		}
	}
}
