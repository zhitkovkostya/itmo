package com;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ClosestNumberServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");

		String var1 = req.getParameter("var1");
		double num1 = Double.parseDouble(var1);

		String var2 = req.getParameter("var2");
		double num2 = Double.parseDouble(var2);

		double numToCompare = 10;
		if (Math.abs(numToCompare - num1) != Math.abs(numToCompare - num2)) {
			if (Math.abs(numToCompare - num1) < Math.abs(numToCompare - num2)) {
				resp.getWriter().println(
						Double.toString(num1) + " ближе к " + numToCompare + ", чем " + Double.toString(num2));
			} else
				resp.getWriter().println(
						Double.toString(num2) + " ближе к " + numToCompare + ", чем " + Double.toString(num1));
		} else {
			resp.getWriter()
					.println(
							Double.toString(num1) + " и " + Double.toString(num2) + " одинаково близки к "
									+ numToCompare);
		}

	}

}
