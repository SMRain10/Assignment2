// ENSF 607 Assignment 2
// Sam Rainbow
// UCID: 30084292
// Note I only commented for the portions of code that I wrote.

import java.util.*;

class Polygon {
	private final LinkedHashSet <Line> polygon;
	private int objID;
	private static int classID;
	Iterator <Line> it;

	public Polygon(LinkedHashSet<Line> polygon) {
		 this.polygon = new LinkedHashSet<Line>();
		 for(Line l: polygon)
			 this.polygon.add (l);  
		 objID = ++ classID;
		 it = this.polygon.iterator();
	}
	
	public Iterator <Line> getLine() {
		it = polygon.iterator();
		return it;
	}
	
	public static int classID(){
		return classID;
	}

	// The toString method iterates through the lines in the polygon and calls Lines toString methods (which calls Points toString
	// method). After it gets the toString for each line it strips the square brackets at the beginning of LinkedHashSet
	// and also "," separating the LinkedHashSet elements. It then replaces the "." between the x and y coordinates
	// with a "," to get the same output as required.
	public String toString() {
		String s = "\nThe lines in polygon " + classID() + " are:\n";
		String s1 = null;
		for (Line l: polygon) {
			s1 = polygon.toString().replace("[","").replace("]","").
			replace(", ","").replace(".",",");
		}

		return s + s1;
    }
}


