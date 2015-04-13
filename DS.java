import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

// DS is shorthand for DigitalSimulator

public class DS {

    //yes, I could have made this a class.  I was lazy.
    public static Map<Component, ArrayList<Wire> > pinList;
    public static PQ<Event> eventList;
 
    public static boolean eventTrace;
    


    DS() {}
    

   
    public static double go(boolean eventTrace) {
	Event e;
	double currentTime = -1.0; // no events yet
	while (eventList.sizeOf() > 0) {
	    e = eventList.poll();
	    currentTime=e.getTime();
	    if (eventTrace) {System.out.println("Event: " +e.toString());}

	    e.getComponent().propagate(currentTime);
	}
	return currentTime;
    }


    public static void report() {
	System.out.println("Simulation Results\n");
	Set<Component> set = new HashSet<Component>();
	set = DS.pinList.keySet();
	for(Iterator<Component> itr = set.iterator();
	    itr.hasNext();) {
	    Component c = itr.next();
	    System.out.println(c.toString());
	}
    }
}