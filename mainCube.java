
public class mainCube {
	// hereinafter follow this order (WYBGRO)
	// --------------------------defining all squares of the cube in the order outlined above---------------------------------------------
	
	// defining all white faces
	private Square w00 = new Square("w");
	private Square w01 = new Square("w");
	private Square w02 = new Square("w");
	private Square w10 = new Square("w");
	private Square w11 = new Square("w");
	private Square w12 = new Square("w");
	private Square w20 = new Square("w");
	private Square w21 = new Square("w");
	private Square w22 = new Square("w");
	// defining all yellow faces
	private Square y00 = new Square("y");
	private Square y01 = new Square("y");
	private Square y02 = new Square("y");
	private Square y10 = new Square("y");
	private Square y11 = new Square("y");
	private Square y12 = new Square("y");
	private Square y20 = new Square("y");
	private Square y21 = new Square("y");
	Square y22 = new Square("y");
	// defining all blue faces
	private Square b00 = new Square("b");
	private Square b01 = new Square("b");
	private Square b02 = new Square("b");
	private Square b10 = new Square("b");
	private Square b11 = new Square("b");
	private Square b12 = new Square("b");
	private Square b20 = new Square("b");
	private Square b21 = new Square("b");
	private Square b22 = new Square("b");
	// defining all green faces
	private Square g00 = new Square("g");
	private Square g01 = new Square("g");
	private Square g02 = new Square("g");
	private Square g10 = new Square("g");
	private Square g11 = new Square("g");
	private Square g12 = new Square("g");
	private Square g20 = new Square("g");
	private Square g21 = new Square("g");
	private Square g22 = new Square("g");
	// defining all red faces
	private Square r00 = new Square("r");
	private Square r01 = new Square("r");
	private Square r02 = new Square("r");
	private Square r10 = new Square("r");
	private Square r11 = new Square("r");
	private Square r12 = new Square("r");
	private Square r20 = new Square("r");
	private Square r21 = new Square("r");
	private Square r22 = new Square("r");
	// defining all orange sides
	private Square o00 = new Square("o");
	private Square o01 = new Square("o");
	private Square o02 = new Square("o");
	private Square o10 = new Square("o");
	private Square o11 = new Square("o");
	private Square o12 = new Square("o");
	private Square o20 = new Square("o");
	private Square o21 = new Square("o");
	private Square o22 = new Square("o");
	
	private Side w = new Side("w",w00,w01,w02,w10,w11,w12,w20,w21,w22);
	private Side y = new Side("y",y00,y01,y02,y10,y11,y12,y20,y21,y22);
	private Side b = new Side("b",b00,b01,b02,b10,b11,b12,b20,b21,b22);
	private Side g = new Side("g",g00,g01,g02,g10,g11,g12,g20,g21,g22);
	private Side r = new Side("r",r00,r01,r02,r10,r11,r12,r20,r21,r22);
	private Side o = new Side("o",o00,o01,o02,o10,o11,o12,o20,o21,o22);
	
	Side currentSide = w;
	Side baSide = y;
	Side tSide = b;
	Side boSide = g;
	Side lSide = o;
	Side rSide = r;
	
	public void rotate4(int aY, int aX, Side aS, int bY, int bX, Side bS, int cY, int cX, Side cS, int dY, int dX, Side dS) {
		Square temp = aS.position[aY][aX];
		aS.position[aY][aX] = dS.position[dY][dX];
		dS.position[dY][dX] = cS.position[cY][cX];
		cS.position[cY][cX] = bS.position[bY][bX];
		bS.position[bY][bX] = temp;
	}
	
	public void front() {
		this.currentSide.clockwise();
		
		this.rotate4(2,1,tSide,1,0,rSide,0,1,boSide,1,2,lSide);
		
		this.rotate4(2,0,tSide,0,0,rSide,0,2,boSide,2,2,lSide);
		
		this.rotate4(2,2,tSide,2,0,rSide,0,0,boSide,0,2,lSide);
	}
	public void right() {
		this.rSide.clockwise();
		
		this.rotate4(1,2,currentSide,1,2,tSide,1,0,baSide,1,2,boSide);
		
		this.rotate4(0,2,currentSide,0,2,tSide,2,0,baSide,0,2,boSide);
		
		this.rotate4(2,2,currentSide,2,2,tSide,0,0,baSide,2,2,boSide);
		
	}
	public void left() {
		this.lSide.clockwise();
		
		this.rotate4(1,0,currentSide,1,0,boSide,1,2,baSide,1,0,tSide);
		
		this.rotate4(0,0,currentSide,0,0,boSide,2,2,baSide,0,0,tSide);
		
		this.rotate4(2,0,currentSide,2,0,boSide,0,2,baSide,2,0,tSide);
		
	}
	public void bottom() {
		this.boSide.clockwise();
		
		this.rotate4(2,1,currentSide,2,1,rSide,2,1,baSide,2,1,lSide);
		
		this.rotate4(2,0,currentSide,2,0,rSide,2,0,baSide,2,0,lSide);
		
		this.rotate4(2,2,currentSide,2,2,rSide,2,2,baSide,2,2,lSide);
	}
	public void up() {
		this.tSide.clockwise();
		
		this.rotate4(0,1,currentSide,0,1,lSide,0,1,baSide,0,1,rSide);
		
		this.rotate4(0,0,currentSide,0,0,lSide,0,0,baSide,0,0,rSide);
		
		this.rotate4(0,2,currentSide,0,2,lSide,0,2,baSide,0,2,rSide);
	}
	public void back() {
		this.baSide.clockwise();
		
		this.rotate4(0,1,tSide,1,0,lSide,2,1,boSide,1,2,rSide);
	
		this.rotate4(0,0,tSide,2,0,lSide,2,2,boSide,0,2,rSide);
		
		this.rotate4(0,2,tSide,0,0,lSide,2,0,boSide,2,2,rSide);
		
	}
	public void frontinv() {
		this.currentSide.counterclockwise();
		
		this.rotate4(2,1,tSide,1,2,lSide,0,1,boSide,1,0,rSide);
		
		this.rotate4(2,0,tSide,2,2,lSide,0,2,boSide,0,0,rSide);
		
		this.rotate4(2,2,tSide,0,2,lSide,0,0,boSide,2,0,rSide);
	}
	public void rightinv() {
		this.rSide.counterclockwise();
		
		this.rotate4(1,2,currentSide,1,2,boSide,1,0,baSide,1,2,tSide);
		
		this.rotate4(0,2,currentSide,0,2,boSide,2,0,baSide,0,2,tSide);
		
		this.rotate4(2,2,currentSide,2,2,boSide,0,0,baSide,2,2,tSide);
		
	}
	public void leftinv() {
		this.lSide.counterclockwise();
		
		this.rotate4(1,0,currentSide,1,0,tSide,1,2,baSide,1,0,boSide);
		
		this.rotate4(0,0,currentSide,0,0,tSide,2,2,baSide,0,0,boSide);
		
		this.rotate4(2,0,currentSide,2,0,tSide,0,2,baSide,2,0,boSide);
		
	}
	public void bottominv() {
		this.boSide.counterclockwise();
		
		this.rotate4(2,1,currentSide,2,1,lSide,2,1,baSide,2,1,rSide);
		
		this.rotate4(2,0,currentSide,2,0,lSide,2,0,baSide,2,0,rSide);
		
		this.rotate4(2,2,currentSide,2,2,lSide,2,2,baSide,2,2,rSide);
	}
	public void upinv() {
		this.tSide.counterclockwise();
		
		this.rotate4(0,1,currentSide,0,1,rSide,0,1,baSide,0,1,lSide);
		
		this.rotate4(0,0,currentSide,0,0,rSide,0,0,baSide,0,0,lSide);
		
		this.rotate4(0,2,currentSide,0,2,rSide,0,2,baSide,0,2,lSide);
	}
	public void backinv() {
		this.baSide.counterclockwise();
		
		this.rotate4(0,1,tSide,1,2,rSide,2,1,boSide,1,0,lSide);
	
		this.rotate4(0,0,tSide,0,2,rSide,2,2,boSide,2,0,lSide);
		
		this.rotate4(0,2,tSide,2,2,rSide,2,0,boSide,0,0,lSide);
		
	}
	public void x() {
		this.rSide.clockwise();
		this.lSide.counterclockwise();
		
		this.tSide.clockwise();
		this.tSide.clockwise();
		
		this.baSide.clockwise();
		this.baSide.clockwise();
		
		Side temp = this.currentSide;
		this.currentSide = this.boSide;
		this.boSide = this.baSide;
		this.baSide = this.tSide;
		this.tSide = temp;
	}
	public void xprime() {
		this.lSide.clockwise();
		this.rSide.counterclockwise();
		this.boSide.clockwise();
		this.boSide.clockwise();
		this.baSide.clockwise();
		this.baSide.clockwise();

		Side temp = this.currentSide;
		this.currentSide = this.tSide;
		this.tSide = this.baSide;
		this.baSide = this.boSide;
		this.boSide = temp;

	}
	public void y() {
		Side temp = this.currentSide;
		this.currentSide = this.rSide;
		this.rSide = this.baSide;
		this.baSide = this.lSide;
		this.lSide = temp; 
		
		this.tSide.clockwise();
		this.boSide.counterclockwise();
	}
	public void yprime() {
		Side temp = this.currentSide;
		this.currentSide = this.lSide;
		this.lSide = this.baSide;
		this.baSide = this.rSide;
		this.rSide = temp; 
		
		this.tSide.counterclockwise();
		this.boSide.clockwise();
		
	}
	public void z() {
		Side temp = this.tSide;
		this.tSide = this.lSide;
		this.lSide = this.boSide;
		this.boSide = this.rSide;
		this.rSide = temp;
		
		currentSide.clockwise();
		baSide.counterclockwise();
	}
	public void zprime() {
		Side temp = this.tSide;
		this.tSide = this.rSide;
		this.rSide = this.boSide;
		this.boSide = this.lSide;
		this.lSide = temp;
		
		currentSide.counterclockwise();
		baSide.clockwise();
	}
	// used for testing
	public void printSide (Side s) {
		System.out.println("color: "+ s.color);
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 3; x++) {
				System.out.print(s.position[y][x].getColor() + " ");
			}
			System.out.println();
		}
		
	System.out.println();
	System.out.println();
	}
	
	public Side getCurrentSide() {
		return this.currentSide;
	}
		
		// main method for testing
		public static void main(String args[]) {
		}
}
