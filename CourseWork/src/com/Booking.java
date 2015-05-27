package com;

import java.io.IOException;
import java.lang.reflect.Field;

import com.City;
import com.Hotel;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Booking extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		if (req.getParameter("flag").equals("1")) {
				Hotel[] spbhotels = {
						new Hotel("Астория", "5", "50", "Большая Морская ул.", "39",
								"+7 (812) 494-57-57",
								"http://www.theastoriahotel.ru/"),
						new Hotel("Гранд Отель Европа", "5", "23",
								"Михайловская ул.", "1/7",
								"+7 (812) 329-60-00",
								"http://grand-hotel-europe.com/") };
				Hotel[] mschotels = {
						new Hotel("Метрополь", "5", "Театральный пр.", "2", "52",
								"+7 (499) 501 78 00",
								"http://www.metropol-moscow.ru/"),
						new Hotel("Националь", "5", "133", "Моховая ул.", "15/1",
								"+7 (812) 329-60-00", "http://www.national.ru/") };
				City[] cities = { new City("Санкт-Петербург", spbhotels),
						new City("Санкт-Петербург", mschotels) };
				
				
				resp.getWriter().print("<table class=\"type2\">");
				resp.getWriter().print("<tr>");
				for (Field field : cities[Integer.parseInt(req.getParameter("city"))].hotels[0].getClass().getDeclaredFields()) {
					resp.getWriter().print("<th>" + field.getName() + "</th>");
				}
				resp.getWriter().print("</tr>");
				for (int i = 0; i < cities[Integer.parseInt(req.getParameter("city"))].hotels.length; i++) {
					resp.getWriter().print("<tr>");
					for (Field field : cities[Integer.parseInt(req.getParameter("city"))].hotels[i].getClass()
							.getDeclaredFields()) {
						try {
							resp.getWriter()
									.print("<td>" + field.get(cities[Integer.parseInt(req.getParameter("city"))].hotels[i])
											+ "</td>");
						} catch (IllegalArgumentException
								| IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					resp.getWriter().print("</tr>");
				}
				resp.getWriter().print("</table>");

		} else if (req.getParameter("flag").equals("0")) {
			resp.getWriter().println("");
		}
	}
}
