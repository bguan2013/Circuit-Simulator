public class Not extends Component {


    Not(String name, int nInputs, int nOutputs, boolean trace) {
	super(name,"Not",nInputs,nOutputs,0.2,trace);
    }


    public boolean inputsPresent() {
	for (int i=0; i<inPins.size();i++) {
	    if (inPins.get(i) == Component.UNDEF) return false;
	}
	return true;
    }

    public boolean compute() {
	if (inputsPresent()){
	    int acc = inPins.get(0);
	    if(acc == 0){
	    outPins.set(0,1);

		}
		else{
			outPins.set(0,0);
		}
	    return true;
	} 
	else {
	    return false;
	}
    }

}