package com;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RandomArrayMaxServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		if (req.getParameter("flag").equals("1")) {
			Random rand = new Random();
			int rows = 5;
			int cols = 8;

			int max = 99;
			int min = -99;

			int maxNum = min;

			resp.getWriter().println("<table>");
			for (int i = 0; i < rows; i++) {
				resp.getWriter().println("<tr>");
				for (int j = 0; j < cols; j++) {
					int randomNum = rand.nextInt((max - min) + 1) + min;
					if (randomNum > maxNum) {
						maxNum = randomNum;
					}
					String iStr = Integer.toString(randomNum);
					resp.getWriter().println("<td>" + iStr + "</td>");
				}
				resp.getWriter().println("</tr>");
			}
			resp.getWriter().println("</table>");
			resp.getWriter().println("<p>Максимальный элемент: " + maxNum + "</p>");
		} else if (req.getParameter("flag").equals("0")) {
			resp.getWriter().println("");
		}
	}

}
