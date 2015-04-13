import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class CircuitOr{

    CircuitOr(int a, int b) {   
    //simulate a RS f/f as a nor latch
	DS.pinList = new HashMap<Component, ArrayList<Wire>>();
	DS.eventList = new Heap<Event>();
	
	// inputs
	Input m = new Input("M",1,1,true);
	Input n = new Input("N",1,1,true);
	// gates
	Or or = new Or("Or1",2,1,true);
	
	//outputs
	Output o = new Output("O",1,1,true);
	
	
	// pin list
	
	DS.pinList.put(m, new ArrayList<Wire>());
	DS.pinList.put(n, new ArrayList<Wire>());
	DS.pinList.put(or,new ArrayList<Wire>());
	DS.pinList.put(o,new ArrayList<Wire>());
	
	
	ArrayList<Wire> al;
	
	// make all the connections
	
	al = DS.pinList.get(m);
	al.add(new Wire(new Pin(m,0),new Pin(or,0)));
	
	al = DS.pinList.get(n);
	al.add(new Wire(new Pin(n,0),new Pin(or,1)));
	
	al = DS.pinList.get(or);
	al.add(new Wire(new Pin(or,0),new Pin(o,0)));
	
	
	
	
	// initialize state
	// requirement:  SR = 0
	
	m.setInput(0,0);
	n.setInput(0,0);
	
	
	
	double startTime = 0.0;
	double endTime;
	boolean trace = true;

	
	
	
	// constraint:  rs=0  (r and s can't both be 1)
	
	//q(t)  s(t)  r(t) | q(t+1)
	//-----------------|-------
	// 0     0     0       0
	// 0     0     1       0
	// 0     1     1      ???
	// 0     1     0       1
	// 1     1     0       1
	// 1     1     1      ??? 
	// 1     0     1       0
	// 1     0     0       1
	
	
	
	// start simulation
	DS ds = new DS();
	
	
	
	
	DS.eventList.clear(); 
	m.setInput(0, a);
	n.setInput(0, b);
	DS.eventList.add(new Event(m,startTime));
	DS.eventList.add(new Event(n,startTime));
	endTime = ds.go(trace);
	ds.report();
    }
    

    // yes, I could have defined a Main class.  Do whatever you like
    
}