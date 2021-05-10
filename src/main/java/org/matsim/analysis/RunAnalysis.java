package org.matsim.analysis;

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class RunAnalysis {
    public static void main(String[] args) throws IOException {

        EventsManager manager = EventsUtils.createEventsManager();
        LinkEventsHandler handler = new LinkEventsHandler();
        manager.addHandler(handler);

        var traffic = handler.getTraffic();
        //Pfad der Input-Datei
        EventsUtils.readEvents(manager, "C:\\Users\\anton\\IdeaProjects\\serengeti-park-v1.0-run1.output_events.xml");

        //Pfad der Output-Datei
        PrintWriter pWriter = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\anton\\IdeaProjects\\matsim-serengeti-park-hodenhagen-master\\scenarios\\serengeti-park-v1.0\\output\\output-serengeti-park-v1.0-run1\\linkleave2.csv")));

    for (Integer key : traffic.keySet()) {
        System.out.println(key+","+traffic.get(key));
        pWriter.println(key+","+traffic.get(key));
    }

    }
}
