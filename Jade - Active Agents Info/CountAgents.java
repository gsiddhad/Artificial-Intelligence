/*
 *  CountAgents.java / Active Agents Info
 *  Author : Gourav Siddhad
 */

import jade.core.Agent;
import jade.core.AID;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;

public class CountAgents extends Agent {
    protected void setup() {
        AMSAgentDescription[] agents = null;
        try {
            SearchConstraints c = new SearchConstraints();
            c.setMaxResults(new Long(-1));
            agents = AMSService.search(this, new AMSAgentDescription(), c);
        } catch (Exception e) {
            System.out.println("Problem searching AMS: " + e);
            e.printStackTrace();
        }

        AID myID = getAID();
        for (int i = 0; i < agents.length; i++) {
            AID agentID = agents[i].getName();
            if (agentID.equals(myID))
                System.out.println(" -> ");
            else
                System.out.println("    ");
            System.out.println("" + i + " : " + agentID.getName());
        }
    }
}
