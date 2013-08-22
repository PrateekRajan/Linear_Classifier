import java.io.*;
public class LinearRegression { 

    public static void main(String[] args) { 
    	
    	
		int i = 0, j = 0;
		double[][] arr = new double[3][];
		arr[0] = new double[1000];
		arr[1] = new double[1000];
		arr[2] = new double[1000];

		try {
			FileInputStream fstream = new FileInputStream("Text.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String input;
			while ((input = br.readLine()) != null) {
				String[] str = input.split(",");
				Double x1 = new Double(str[0]);
				Double y1 = new Double(str[1]);

				arr[0][i] = x1;
				arr[1][j] = y1;
				i++;
				j++;
			}

		} catch (Exception e) {
			System.out.print(e.getLocalizedMessage());
		}
    	
        int MAXN = 1000;
        double[] x = arr[0];
        double[] y = arr[1];
        int n = j;

        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
        for (int count = 0; count < j; count++) {
            sumx  += x[count];
            sumx2 += x[count] * x[count];
            sumy  += y[count];
        }
        double xbar = sumx / n;
        double ybar = sumy / n;

        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for (i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
            yybar += (y[i] - ybar) * (y[i] - ybar);
            xybar += (x[i] - xbar) * (y[i] - ybar);
        }
        double beta1 = xybar / xxbar;
        double beta0 = ybar - beta1 * xbar;

        // print results
        System.out.println("y   = " + beta1 + " * x + " + beta0);

        // analyze results
        int df = n - 2;
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for (i = 0; i < n; i++) {
            double fit = beta1*x[i] + beta0;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }
        double R2    = ssr / yybar;
        double svar  = rss / df;
        double svar1 = svar / xxbar;
        double svar0 = svar/n + xbar*xbar*svar1;
        System.out.println("R^2                 = " + R2);
        System.out.println("std error of beta_1 = " + Math.sqrt(svar1));
        System.out.println("std error of beta_0 = " + Math.sqrt(svar0));
        svar0 = svar * sumx2 / (n * xxbar);
        System.out.println("std error of beta_0 = " + Math.sqrt(svar0));

        System.out.println("SSTO = " + yybar);
        System.out.println("SSE  = " + rss);
        System.out.println("SSR  = " + ssr);
    }
}
