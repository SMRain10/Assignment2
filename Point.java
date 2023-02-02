// ENSF 607 Assignment 2
// Sam Rainbow
// UCID: 30084292
// Note I only commented for the portions of code that I wrote.
class Point {
	private int x, y;

	public Point(int x, int y) {
	this.x = x;
	this.y = y;
	}
	
	static public double distance(Point a, Point b){
		double diffx = a.x - b.x;
		double diffy = a.y - b.y;
		return Math.sqrt(diffx * diffx + diffy * diffy);
	}

	// toString method that returns the x and y coordinates of that point. Note a period is used so that it can later be
	// replaced with comma after stripping of other commas is complete as we want this comma (x, y) to remain.
	public String toString(){

        return "(" + x + ". " + y + ")";
	}
}
