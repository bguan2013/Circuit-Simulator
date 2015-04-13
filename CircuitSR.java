import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class CircuitSR{

	DS ds;
	Input r;
	Input s;
	Nor g1;
	Nor g2;
	Output q;
	Output qnot;
	double startTime;
	boolean trace;

    CircuitSR() {   
    //simulate a RS f/f as a nor latch
	DS.pinList = new HashMap<Component, ArrayList<Wire>>();
	DS.eventList = new Heap<Event>();
	
	// inputs
	r = new Input("R",1,1,true);
	s = new Input("S",1,1,true);
	// gates
	g1 = new Nor("G1",2,1,true);
	g2 = new Nor("G2",2,1,true);
	//outputs
	q = new Output("Q",1,1,true);
	qnot = new Output("Qnot",1,1,true);
	
	// pin list
	
	DS.pinList.put(r, new ArrayList<Wire>());
	DS.pinList.put(s, new ArrayList<Wire>());
	DS.pinList.put(g1,new ArrayList<Wire>());
	DS.pinList.put(g2,new ArrayList<Wire>());
	DS.pinList.put(q, new ArrayList<Wire>());
	DS.pinList.put(qnot, new ArrayList<Wire>());
	
	ArrayList<Wire> al;
	
	// make all the connections
	
	al = DS.pinList.get(r);
	al.add(new Wire(new Pin(r,0),new Pin(g1,0)));
	
	al = DS.pinList.get(s);
	al.add(new Wire(new Pin(s,0),new Pin(g2,1)));
	
	al = DS.pinList.get(g1);
	al.add(new Wire(new Pin(g1,0),new Pin(g2,0)));
	al.add(new Wire(new Pin(g1,0),new Pin(q,0)));
	
	al = DS.pinList.get(g2);
	al.add(new Wire(new Pin(g2,0),new Pin(g1,1)));
	al.add(new Wire(new Pin(g2,0), new Pin(qnot,0)));
	
	// initialize state
	// requirement:  SR = 0
	
	r.setInput(0,0);
	s.setInput(0,0);
	
	g2.setInput(0,1);
	
	
	startTime = 0.0;
	//double endTime;
	trace = true;

	
	
	
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
	//Holding......
	ds = new DS();
	//endTime = ds.go(trace);
	//ds.report();
	
	
    }
    public void simulate(int a, int b){

		DS.eventList.clear(); 
		s.setInput(0,a);
		r.setInput(0,b);
		DS.eventList.add(new Event(s,startTime));
		DS.eventList.add(new Event(r,startTime));
		startTime = ds.go(trace);
		ds.report();
		g1.setOutput(0,-1);
		g2.setOutput(0,-1);
		r.setOutput(0,-1);
		s.setOutput(0,-1);
		g2.setInput(0,q.getOutput(0));
		q.setOutput(0,-1);
		qnot.setOutput(0,-1);

		

		}
    

    
    
}