


public class Nor extends Component {


    Nor(String name, int nInputs, int nOutputs, boolean trace) {
	super(name,"Nor",nInputs,nOutputs,0.7,trace);
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
	    int cnt = 0;
	    for (Integer v : inPins) {
		if (cnt !=0) {
		    acc = (acc == 0 && v ==0)? 1 : 0;
		}
		cnt++;
	    }
	    outPins.set(0,acc);
	    return true;
	} 
	else {
	    return false;
	}
    }

}