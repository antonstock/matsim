package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;
import org.matsim.api.core.v01.network.Link;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LinkEventsHandler implements LinkLeaveEventHandler {

    private static final Id<Link> myLink = Id.createLinkId("908198570004f");

    public LinkEventsHandler() throws IOException {
        System.out.println("Error 21");
    }
    int time=0;
    int counter=0;
    int lastTime=0;
    HashMap<Integer, Integer> traffic = new HashMap<Integer, Integer>();

    public Map<Integer, Integer> getTraffic() {
        return traffic;
    }
    public Integer getTime() {
        return time;
    }

    public void handleEvent(LinkLeaveEvent event) {
        if (event.getLinkId() == myLink) {
            time = (int) (event.getTime()/3600);
            if(time == lastTime || lastTime==0) {
                counter++;
                traffic.put(time, counter);
            }
            else {
                counter=1;
                traffic.put(time, counter);
            }
            lastTime=time;
        }
    }
}
