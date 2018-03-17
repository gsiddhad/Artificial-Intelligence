/*
 *	First.java / Exchange Arguments
 *  15 - Nov - 2016
 * 	Author : Gourav Siddhad
 */

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

@SuppressWarnings("serial")
public class First extends Agent {
	@Override
	protected void setup() {

		Object args[] = getArguments();
		final int narg = args.length;
		String sarg[] = new String[narg];

		for(int i=0; i<narg; i++)
			sarg[i] = args[i].toString();

		addBehaviour(new OneShotBehaviour() {
			@Override
			public void action() {
				// Send args to other agent
				System.out.println("Sending Arguments to Second Agent");
				for(int i=0; i<narg; i++) {
					ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
					msg.setContent(sarg[i]);
					msg.addReceiver(new AID("Second", AID.ISLOCALNAME));
					send(msg);
				}
			}
		});

		addBehaviour(new CyclicBehaviour() {
			@Override
			public void action() {
				//Receive message
				ACLMessage msg = receive();
				if(msg != null)
					System.out.println("Message Received in First Agent : " + msg.getContent().toString());
				else
					block();
			}
		});
	}
}
