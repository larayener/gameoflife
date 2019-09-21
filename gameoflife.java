
public class GameOfLife {
	private boolean[][] state;
	private int n;
	private int gen;
	
	public GameOfLife(boolean[][] initial, int n) {
		state = new boolean[n][n];
		this.n = n;
		if (n < 2) {
			System.out.println("The Game of Life isn't valid for these dimensions. We've set n to 2 instead.");
			n = 2;
		}
		for (int i = 0; i < n; i++) {
			for (int c = 0; c < n; c++) {
				state[i][c] = initial[i][c];
			}
		}
		gen = 0;
	}
	
	private int neighborno(int x, int y) {
		int komsusayisi = 0;
		if (x > 0) {
			if (state[x-1][y]) {
				komsusayisi++;
			}
		}
		if (x < n - 1) {
			if (state[x+1][y]) {
				komsusayisi++;
			}
		}
		if (y > 0) {
			if (state[x][y-1]) {
				komsusayisi++;
			}
		}
		if (y < n - 1) {
			if (state[x][y+1]) {
				komsusayisi++;
			}
		}
		if (x > 0 && y > 0) {
			if (state[x-1][y-1]) {
				komsusayisi++;
			}
		}
		if ((x < n - 1) && (y < n - 1)) {
			if (state[x+1][y+1]) {
				komsusayisi++;
			}
		}
		if ((y > 0) && (x < n - 1)) {
			if (state[x+1][y-1]) {
				komsusayisi++;
			}
		}
		if ((x > 0) && (y < n - 1)) {
			if (state[x-1][y+1]) {
				komsusayisi++;
			}
		}
		return komsusayisi;
	}
	
	public void NextGen() {
		boolean[][] nextstate = new boolean[n][n];
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				int ks = neighborno(x,y);
				if (!state[x][y]) {
					if (ks == 3) {
						nextstate[x][y] = true;
					}
					else {
						nextstate[x][y] = false;
					}
				}
				if (state[x][y]) {
					if (ks == 2 || ks == 3) {
						nextstate[x][y] = true;
					}
					else {
						nextstate[x][y] = false;
					}
				}
			}
		}
		state = nextstate;
	}
	
	public void display() {
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (state[x][y]) {
					System.out.print("o ");
				}
				else {
					System.out.print("_ ");
				}
			}
			System.out.println();
	}
		System.out.println();
}
}
