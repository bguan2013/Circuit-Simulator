import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class CircuitSeq{

    CircuitSeq(int a) {   
     //simulate a RS f/f as a nor latch
	DS.pinList = new HashMap<Component, ArrayList<Wire>>();
	DS.eventList = new Heap<Event>();
	
	// inputs
	Input in = new Input("Input",1,1,true);
	
	// gates
	Not n1 = new Not("N1",1,1,true);
	Not n2 = new Not("N2",1,1,true);
	//outputs
	Output out = new Output("Output",1,1,true);
	
	
	// pin list
	
	DS.pinList.put(in, new ArrayList<Wire>());
	DS.pinList.put(n1, new ArrayList<Wire>());
	DS.pinList.put(n2, new ArrayList<Wire>());
	DS.pinList.put(out,new ArrayList<Wire>());
	
	
	ArrayList<Wire> al;
	
	// make all the connections
	
	al = DS.pinList.get(in);
	al.add(new Wire(new Pin(in,0),new Pin(n1,0)));
	
	al = DS.pinList.get(n1);
	al.add(new Wire(new Pin(n1,0),new Pin(n2,0)));


	al = DS.pinList.get(n2);
	al.add(new Wire(new Pin(n2,0),new Pin(out,0)));
	
	

	
	//in.setInput(0,0);
	
	
	
	double startTime = 0.0;
	double endTime;
	boolean trace = true;

	
	
	
	
	
	
	
	
	// start simulation
	DS ds = new DS();
	
	
	
	DS.eventList.clear(); 
	in.setInput(0,a);
	DS.eventList.add(new Event(in,startTime));
	endTime = ds.go(trace);
	ds.report();   

    }
    

    
    
}