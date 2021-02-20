/*
 *  Receiver.java / Send Message
 *  Author : Gourav Siddhad
 */

import javax.swing.JOptionPane;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Receiver extends Agent {
	protected void setup() {
		addBehaviour(new CyclicBehaviour() {
			public void action() {
				ACLMessage msg = receive();
				if (msg != null) {
					System.out.println(" Message Received, Message : " + msg.getContent());
					JOptionPane.showMessageDialog(null, "Message Received, Message : " + msg.getContent());
				} else
					block();
			}
		});
	}
}
