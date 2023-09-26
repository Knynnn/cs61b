public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV,
				  double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) + 
			(yyPos - p.yyPos) * (yyPos - p.yyPos));
	}

	public double calcForceExertedBy(Planet p) {
		return G * mass * p.mass / calcDistance(p) / calcDistance(p);
	}

	public double calcForceExertedByX(Planet p) {
		return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
	}

	public double calcForceExertedByY(Planet p) {
		return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double X = 0;
		for(int i = 0; i < allPlanets.length; i++)
		{
			if(this.equals(allPlanets[i])) {
				continue;
			}
			X += calcForceExertedByX(allPlanets[i]);
		}
		return X;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double Y = 0;
		for(int i = 0; i < allPlanets.length; i++)
		{
			if(this.equals(allPlanets[i])) {
				continue;
			}
			Y += calcForceExertedByY(allPlanets[i]);
		}
		return Y;
	}

	public void update(double dt, double fX, double fY) {
		double dx = fX / mass;
		double dy = fY / mass;
		xxVel += dt * dx;
		yyVel += dt * dy;
		xxPos += dt * xxVel;
		yyPos += dt * yyVel;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}
}

