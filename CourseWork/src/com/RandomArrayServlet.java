package com;

import java.io.IOException;
import java.util.Random;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RandomArrayServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		if (req.getParameter("flag").equals("1")) {
			Random rand = new Random();
			int rows = 8;
			int cols = 5;
			int max = 99;
			int min = 10;
			resp.getWriter().println("<table>");
			for (int i = 0; i < rows; i++) {
				resp.getWriter().println("<tr>");
				for (int j = 0; j < cols; j++) {
					int randomNum = rand.nextInt((max - min) + 1) + min;
					String iStr = Integer.toString(randomNum);
					resp.getWriter().println("<td>" + iStr + "</td>");
				}
				resp.getWriter().println("</tr>");
			}
			resp.getWriter().println("</table>");
		} else if (req.getParameter("flag").equals("0")) {
			resp.getWriter().println("");
		}
	}

}
