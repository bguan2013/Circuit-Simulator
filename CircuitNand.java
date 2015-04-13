import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;




public class CircuitNand{

    CircuitNand(int m, int n){

    //simulate a RS f/f as a nor latch
	DS.pinList = new HashMap<Component, ArrayList<Wire>>();
	DS.eventList = new Heap<Event>();
	
	// inputs
	Input in1 = new Input("In1",1,1,true);
	Input in2 = new Input("In2",1,1,true);
	
	// gates
	Nand nand1 = new Nand("nand1",2,1,true);

	//outputs
	Output out = new Output("Output",1,1,true);
	
	
	// pin list
	
	DS.pinList.put(in1, new ArrayList<Wire>());
	DS.pinList.put(in2, new ArrayList<Wire>());
	DS.pinList.put(nand1, new ArrayList<Wire>());
	DS.pinList.put(out,new ArrayList<Wire>());
	
	
	ArrayList<Wire> al;
	
	// make all the connections
	
	al = DS.pinList.get(in1);
	al.add(new Wire(new Pin(in1,0),new Pin(nand1,0)));



	al = DS.pinList.get(in2);
	al.add(new Wire(new Pin(in2,0),new Pin(nand1,1)));


	
	al = DS.pinList.get(nand1);
	al.add(new Wire(new Pin(nand1,0),new Pin(out,0)));
	
	
	
	// initialize state
	// requirement:  SR = 0
	
	in1.setInput(0,0);
	in2.setInput(0,0);

	
	
	
	double startTime = 0.0;
	double endTime;
	boolean trace = true;

	
	
	
	
	
	
	// start simulation
	DS ds = new DS();
	
	
	
	DS.eventList.clear(); 
	in1.setInput(0,m);
	in2.setInput(0,n);
	DS.eventList.add(new Event(in1,startTime));
	DS.eventList.add(new Event(in2,startTime));
	endTime = ds.go(trace);
	ds.report();   




    }




}
