/*
 *	ThirdAgent.java / Active Agents Info 2
 *	Author : Gourav Siddhad
 */

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

@SuppressWarnings("serial")
public class ThirdAgent extends Agent {
	@Override
	protected void setup() {

		addBehaviour(new OneShotBehaviour() {
			@Override
			public void action() {
				System.out.println("Third Agent - Requesting Information");
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.setContent("Name");
				msg.addReceiver(new AID("FirstAgent", AID.ISLOCALNAME));
				msg.addReceiver(new AID("SecondAgent", AID.ISLOCALNAME));
				msg.addReceiver(new AID("FourthAgent", AID.ISLOCALNAME));
				send(msg);
			}
		});

		addBehaviour(new CyclicBehaviour() {
			@Override
			public void action() {
				ACLMessage msg = receive();
				if (msg != null && msg.getContent().equalsIgnoreCase("Name")) {
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent("ThirdAgent");
					send(reply);
				} else if (msg != null)
					System.out.println(" Message Received in Third Agent from " + msg.getSender().getName()
							+ ", Message : " + msg.getContent());
				else
					block();
			}
		});
	}
}
