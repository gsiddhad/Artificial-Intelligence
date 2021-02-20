/*
 *  Sender.java / Send Message
 *  Author : Gourav Siddhad
 */

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class Sender extends Agent {
	protected void setup() {
		addBehaviour(new OneShotBehaviour() {
			public void action() {
				System.out.println(" Sending Message ");
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.setContent("Send");
				msg.addReceiver(new AID("Receiver", AID.ISLOCALNAME));
				send(msg);
			}
		});
	}
}
