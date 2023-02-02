// ENSF 607 Assignment 2
// Sam Rainbow
// UCID: 30084292
// Note I only commented for the portions of code that I wrote.
class Line {

	Point start, end;
	private static int classID = 0;
	private int objID;

	public Line(Point a, Point b) {
	start = a;
	end = b; 
	 objID = ++ classID;
	}
	
   
	public double distance(){
	    return Point.distance(start, end);
    }

	// toString method that returns the information associated with the line. Start and end toString method calls
	// Point's toString method and returns the x and y coordinates of the point (start and end).
    public String toString()
    {

    	String s =" Line " + objID + ": starts at " + start.toString() + " and ends at " + end.toString() + "\n";
    	return s;
    }
}
