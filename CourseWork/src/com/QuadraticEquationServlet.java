package com;

import java.io.IOException;

import javax.servlet.http.*;
@SuppressWarnings("serial")
public class QuadraticEquationServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		String var1 = req.getParameter("var1");
		double a = Double.parseDouble(var1);

		String var2 = req.getParameter("var2");
		double b = Double.parseDouble(var2);
		
		String var3 = req.getParameter("var3");
		double c = Double.parseDouble(var3);
		
		double d, x1, x2;
		
		resp.getWriter().println("<p>Найдем дискриминант квадратного уравнения:</p>");
		d = b * b - 4 * a * c;
		resp.getWriter().println("<p>D = b<sup>2</sup> - 4 · a · c"
				+ " = " + var2 + "<sup>2</sup> - 4 · " + var1 + " · " + var3 
				+ " = " + Double.toString(b*b) + " - 4 · " + var1 + " · " + var3 + " = " + d + "</p>");
		
		if (d > 0) {
			x1 = (-b + Math.sqrt(d)) / (2 * a);
			x2 = (-b - Math.sqrt(d)) / (2 * a);
			resp.getWriter().println("<p>Так как дискриминант больше нуля, то квадратное уравнение имеет два действительных корня:</p>");
			resp.getWriter().println("<p>x<sub>1</sub> = " + Double.toString(x1) + ";</p>");
			resp.getWriter().println("<p>x<sub>2</sub> = " + Double.toString(x2) + ".</p>");
		}
		else if (d == 0) {
			x1 = (-b) / (2 * a);
			resp.getWriter().println("<p>Так как дискриминант равен нулю, то квадратное уравнение имеет один действительный корень:</p>");
			resp.getWriter().println("<p>x<sub>1</sub> = " + Double.toString(x1) + ".</p>");
		}
		else if (d < 0) {
			resp.getWriter().println("<p>Так как дискриминант меньше нуля, то уравнение не имеет действительных решений..</p>");
		}

	}

}
