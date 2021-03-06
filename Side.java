import java.util.TreeMap;
@SuppressWarnings("unused")
public class Side {
	private String color;
	
	// top to bottom, left to right (y coordinate before x coordinate)
	private Square[][] position;
	
	// constructor
	public Side(String color, Square a, Square b, Square c, Square d, Square e, Square f, Square g, Square h, Square i) {
		this.color = color;
		this.position = new Square[3][3]; // each side is a 3 x 3 array as the rubix cube is 3 x 3
		this.position[0][0] = a;
		this.position[0][1] = b;
		this.position[0][2] = c;
		this.position[1][0] = d;
		this.position[1][1] = e;
		this.position[1][2] = f;
		this.position[2][0] = g;
		this.position[2][1] = h;
		this.position[2][2] = i;
	}
	
	// rotates 4 squares, local to one side
	public void rotate4(int aY, int aX, int bY, int bX, int cY, int cX, int dY, int dX) {
		String temp = this.position[aY][aX].getColor();
		this.position[aY][aX].changeColor(this.position[dY][dX].getColor());;
		this.position[dY][dX].changeColor(this.position[cY][cX].getColor());
		this.position[cY][cX].changeColor(this.position[bY][bX].getColor());
		this.position[bY][bX].changeColor(temp);
	}
	
	
	public void clockwise() {
		// rotate four corners
		this.rotate4(0,0,0,2,2,2,2,0);
		// rotate four edges
		this.rotate4(0,1,1,2,2,1,1,0);
		
		// center stays the same
		
	}
	public void counterclockwise() {
		// rotate four corners
		this.rotate4(0,0,2,0,2,2,0,2);
		// rotate four edges
		this.rotate4(0,1,1,0,2,1,1,2);
		// center stays the same
	}
	public String[][] getFaceColors() {
		// used later to track colors to display on face
		String[][] faceColors = new String[3][3];
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 3; x++) {
				faceColors[y][x] = this.position[y][x].getColor();
			}
		}
		return faceColors;
	}
	
	public Square getSquare(int x, int y) {
		return this.position[x][y];
	}
	
	public void changeSquare(int x, int y, String color) {
		this.position[x][y].changeColor(color);
	}
	
	public String getColor() {
		return this.color;
	}
}
