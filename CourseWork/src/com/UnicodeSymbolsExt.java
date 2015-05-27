package com;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class UnicodeSymbolsExt extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		if (req.getParameter("flag").equals("1")) {
			String var1 = req.getParameter("var3");
			int symbolStart = Integer.parseInt(var1);
			String var2 = req.getParameter("var4");
			int symbolFinish = Integer.parseInt(var2);
			if ( ( symbolStart < 0 ) || ( symbolFinish > 65535)  || ( symbolFinish < symbolStart ) ) {
				resp.getWriter().println("ќшибка. ¬веденные данные не корректны.");
			} else {
				int br = 1;
				resp.getWriter().println("<table><tr>");
				for (int i = symbolStart; i < symbolFinish; i++) {
					String iStr = Integer.toString(i);
					String hStr = Integer.toHexString(Integer.parseInt(iStr));
					while (hStr.length() < 4)
						hStr = "0" + hStr;
					resp.getWriter().println(
							"<td class=\"symInfo\">&#" + iStr + "<span><p style=\"font-size:3rem;text-align:center;\">&#" + iStr
									+ "</p><p>Hex: U+" + hStr + "</p><p>Dec: " + iStr
									+ "</p></span></td>");
					if (br % 10 == 0)
						resp.getWriter().println("</tr><tr>");
					br++;
				}
				resp.getWriter().println("</tr></table>");
			}
		} else if (req.getParameter("flag").equals("0")) {
			resp.getWriter().println("");

		}
	}

}
