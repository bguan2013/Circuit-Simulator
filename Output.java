

public class Output extends Component {

    Output(String name, int nInputs, int nOutputs, boolean trace) {
	super(name,"Output",nInputs,nOutputs,0.0,trace);
    }

    public boolean inputsPresent(){

    	if(inPins.get(0) != Component.UNDEF){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    public boolean compute() {
	if (this.inputsPresent()) {
	    outPins.set(0,inPins.get(0));
	    return true;
	}
	else {
	    return false;
	}
    }
}