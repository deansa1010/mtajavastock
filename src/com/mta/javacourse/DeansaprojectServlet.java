package com.mta.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class DeansaprojectServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		int radius = 50;
		double area = radius * radius * Math.PI;
		
		String line1 = new String("calculation 1: Area of circle with radius "+radius+" is "+area+" squere cm");
		
		double angleB;
		double hypotenuse = 50;
		double opposite;
	    angleB = 30 * (	Math.PI/180);
	    opposite = hypotenuse * Math.sin(angleB);
	    
	    String line2 = new String("calculation 2: Length of opposite where angle b is 30 degrees and hypotenuse is "+hypotenuse+" cm is "+opposite+"cm");
	    
	    double base = 20;
	    double exp = 13;
	    double res = 1;
	    
	    res = Math.pow(base, exp);
	    
	    
	    String line3 = new String("calculation 3: Power of "+base+" with exp of "+exp+" is "+res+"");
	    
	    String resultStr = line1 + "<br>" + line2 + "<br>" +line3;
	    		
		resp.getWriter().println(resultStr);
		
			
	
		
	}
}
