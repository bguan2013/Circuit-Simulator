import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;



public abstract class Component {

    public static final Integer UNDEF = new Integer(-1);

    /**
     * name of the componnt
     */
    protected String name;
    
    protected String type;

    /**
     * holds input values
     */
    protected ArrayList<Integer> inPins;

    /**
     * holds output values
     */
    protected ArrayList<Integer> outPins;

    /**
     * propagation delay for this component
     */
    protected double delay;

    /**
     * used to specify trace of simulation events
     */
    protected boolean trace;

    Component() {
	// initialize all fields
        name = null;
        type = null;
        inPins = null;
        outPins = null;
        delay = 0.0;
        trace = false;
    }
    /** constructor to create component
     * @param name a component has a name
     * @param name a component has a type
     * @param numInputs the number of inputs into this component
     * @param numOutputs the number of outputs from this component
     */
    Component(String name, String type, int numInputs, int numOutputs,
	      double propagation_delay, boolean trace) {
	this.trace = trace;
	this.name = name;
	this.type = type;
	this.delay = propagation_delay;
	inPins = new ArrayList<Integer>(numInputs);
	outPins = new ArrayList<Integer>(numOutputs);
	for (int i=0; i<numInputs; ++i) {
	    inPins.add(i,Component.UNDEF);
	}	
	for (int i=0; i<numOutputs; ++i) {
	    outPins.add(i,Component.UNDEF);
	}
    }

    public void setDelay(double delay) {	this.delay = delay;
    }
    public String getName() { 
	return name;
    }
    
    public String getType() {
	return type;
    }

    public int getInput(int pin) {
	return inPins.get(pin);
    }

    public void setInput(int pin, int v) {
	inPins.set(pin,v);
    }

    public int getOutput(int pin) {
	return outPins.get(pin);
    }

    public void  setOutput(int pin, int v){
	outPins.set(pin,v);
    }

    /**
     * constructs a string representation of this component suitable for trace
     * @return string representation of the component
     */
    public  String toString() {
	// WRITE ME!!

        String inp = "";
        String outp = "";
        for(int i = 0; i < inPins.size(); i++){

            inp = inp + " "+ inPins.get(i);

        }
        for (int j = 0;j < outPins.size(); j++) {
            
            outp = outp + " " + outPins.get(j); 

        }


	return  "Gate " + name + " of type " + type + "\nInput: " + inp + "\nPropergates to \nOutput: " + outp;
    }
    
    /**Propagate the signal from inputs (inPins) to outputs (outPins).
     * Create an event for every component connected to outputs (outPins)
     * at currentTime + component delay time.
     * @pre. We assume this is called as the result of an event occurring.
     * @param currentTime the current simulation time
     */
    // Y!!!!
    public void propagate(double currentTime) {

        if(currentTime < 0){

            System.out.println("The current time is " + currentTime + ", we can't process anything.");

        }
        else{



            if(this.inPins.isEmpty()){

                System.out.println("There is no input for component: " + "("+this.type+")"+this.name + ".");

            }

            else{


                if(this.compute()){

                    
                    ArrayList<Wire> temp = DS.pinList.get(this);

                    for(int x = 0; x < temp.size(); x++){



                        temp.get(x).getDestination().getComponent().setInput(temp.get(x).getDestination().getPin(), outPins.get(0));

                        if(temp.get(x).getDestination().getComponent().inputsPresent() && temp.get(x).getDestination().getComponent().outPins.get(0) == -1){

                            DS.eventList.add(new Event(temp.get(x).getDestination().getComponent(),currentTime+delay));
                        }
                    }




                }
                else{

                    System.out.println("Cannot compute due to insufficient inputs.");

                    




                }

            }



        }

        
	// WRITE ME!!
	   
    }
    
    /**
     * Computes the output value of the component
     * Compute must check that all inputs are defined before computing the
     * output and updating the output pins.
     * If it can compute an output, then for every component its outputs are
     * attached to, it adds a new Event on the eventList with the eventTime
     * as currentTime + the component propagation time.  
     */  
    public abstract boolean compute();
    public abstract boolean inputsPresent();
    
}
    