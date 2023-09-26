public class NBody {
	public static double readRadius(String src) {
		In in = new In(src);
		in.readInt();
		return in.readDouble();
	}

	public static Planet[] readPlanets(String src) {
		In in = new In(src);
		int N = in.readInt();
		in.readDouble();
		Planet[] p = new Planet[N];
		for(int i = 0; i < N; i++) {
			p[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
				in.readDouble(), in.readDouble(), in.readString());
		}
		return p;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double Radius = readRadius(filename);
		Planet[] p = readPlanets(filename);
		StdDraw.setXscale(-Radius, Radius);
        StdDraw.setYscale(-Radius, Radius);
        StdDraw.enableDoubleBuffering();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for(int i = 0; i < p.length; i++) {
			p[i].draw();
		}
		double[] xForce = new double[p.length];
		double[] yForce = new double[p.length];
		for(double i = 0; i < T; i = i + dt) {
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for(int j = 0; j < p.length; j++) {
				xForce[j] = p[j].calcNetForceExertedByX(p);
				yForce[j] = p[j].calcNetForceExertedByY(p);
			}
			for(int j = 0; j < p.length; j++) {
				p[j].update(dt, xForce[j], yForce[j]);
			}
			for(int j = 0; j < p.length; j++) {
				p[j].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			StdDraw.clear();
		}
		StdOut.printf("%d\n", p.length);
		StdOut.printf("%.2e\n", Radius);
		for (int i = 0; i < p.length; i++) {
   		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  p[i].xxPos, p[i].yyPos, p[i].xxVel,
                  p[i].yyVel, p[i].mass, p[i].imgFileName);   
		}
	}
}