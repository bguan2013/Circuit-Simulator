import java.lang.Comparable;




public class Event implements Comparable<Event> {



    Component c;
    double time;

    Event() {
	   c = null;
	   time = 0.0;
    }

    /**
     * An event should be created for a component only
     * when that component has had a change of input
     * @param c the component with a change of input
     * @param t the time at which the event is to be scheduled
     */
    Event(Component c, double t) {
	     this.c = c;
	     time = t;
    }

    public Component getComponent() { return c; }
    public double getTime() { return time; }

    public void setComponent(Component c) { this.c = c; }
    public void setTime(double time) {this.time = time; }


    public String toString() {
	     
       String name = c.getName();
	     return name + " at time "+time;
    }

    public int compareTo(Event e2) {
	// WRITE ME!!
        if(Double.valueOf(this.time).compareTo(Double.valueOf(e2.time)) > 0){
            return 1;
        }
        else if(Double.valueOf(this.time).compareTo(Double.valueOf(e2.time)) < 0){

              return (-1);
        }
	    else{
        return 0;
    }
    }


}