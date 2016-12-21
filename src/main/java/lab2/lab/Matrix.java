package lab2.lab;

public class Matrix extends Thread {
	private static int n = 8;
	private static int m = 8;
	private volatile static int[][] Mat = new int[n][m];
	private volatile static int[][] tMat = new int[m][n];
	private static int a = 0;
	private static int b = 0;

	public Matrix(int[][] Mat, int[][] tMat, int a, int b) {
		Matrix.Mat = Mat;
		Matrix.tMat = tMat;
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		// System.out.println(a);
		// System.out.println(b);
		long startTime = System.currentTimeMillis();
		for (int i = a; i < b; i++) {
			for (int j = 0; j < (tMat[i].length); j++) {

				tMat[i][j] = Mat[j][i];
			}
		}
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("поток выполнялся " + timeSpent + " миллисекунд");
	}

	public static void main(String[] args) {

		for (int i = 0; i < Mat.length; i++) {
			Mat[i] = new int[m];
			for (int j = 0; j < Mat[i].length; j++) {
				Mat[i][j] = (int) Math.round(Math.random() * 100);
				// System.out.print(Mat[i][j]+ " ");
			}

		}
		int count = 4;
		long startTime = System.currentTimeMillis();
		for (int i = (count - 1) * m / count; i < m; i++) {
			for (int j = 0; j < (tMat[i].length); j++) {

				tMat[i][j] = Mat[j][i];
			}
		}
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("главный поток выполнялся " + timeSpent
				+ " миллисекунд");
		a = (int) (a - Math.round(m / count + 0.5));
		for (int i = 1; i < count; i++) {
			
			Matrix thread = new Matrix(Mat, tMat, a, b);
			thread.start();
			b = (int) (b + Math.round(m / count + 0.5));
			a = (int) (a + Math.round(m / count + 0.5));

		}

		for (int i = 0; i < Mat.length; i++) {
			for (int j = 0; j < (Mat[i].length); j++) {
				 System.out.print(Mat[i][j]+ " ");
			}
			 System.out.println();
		}

		 System.out.println();
		for (int i = 0; i < tMat.length; i++) {
			for (int j = 0; j < (tMat[i].length); j++) {

				 System.out.print(tMat[i][j]+ " ");
			}
			 System.out.println();
		}

	}

}
