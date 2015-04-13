import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class CircuitSpecial{

    CircuitSpecial(int a) {   
    //simulate a RS f/f as a nor latch
	DS.pinList = new HashMap<Component, ArrayList<Wire>>();
	DS.eventList = new Heap<Event>();
	
	// inputs
	Input in = new Input("In",1,1,true);
	
	// gates
	Not not1 = new Not("Not1",1,1,true);
	Nand nand1 = new Nand("Nand1",2,1,true);
	//outputs
	Output out = new Output("Out",1,1,true);
	
	
	// pin list
	
	DS.pinList.put(in, new ArrayList<Wire>());
	DS.pinList.put(not1, new ArrayList<Wire>());
	DS.pinList.put(nand1,new ArrayList<Wire>());
	DS.pinList.put(out,new ArrayList<Wire>());
	
	
	ArrayList<Wire> al;
	
	// make all the connections
	
	al = DS.pinList.get(in);
	al.add(new Wire(new Pin(in,0),new Pin(not1,0)));
	al.add(new Wire(new Pin(in,0),new Pin(nand1,1)));
	
	
	
	al = DS.pinList.get(not1);
	al.add(new Wire(new Pin(not1,0),new Pin(nand1,0)));
	
	
	al = DS.pinList.get(nand1);
	al.add(new Wire(new Pin(nand1,0),new Pin(out,0)));
	
	
	// initialize state
	// requirement:  SR = 0
	
	
	
	
	double startTime = 0.0;
	double endTime;
	boolean trace = true;

	DS.eventList.add(new Event(in,startTime));
	
	
	
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
	/*
	endTime = ds.go(!trace);
	ds.report();
	*/
	//??????
	DS.eventList.clear(); 
	in.setInput(0,a);
	DS.eventList.add(new Event(in,startTime));
	
	endTime = ds.go(trace);
	ds.report();
    }
    

    // yes, I could have defined a Main class.  Do whatever you like
    
}