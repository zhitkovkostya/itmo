package com;

import java.io.IOException;
import java.lang.reflect.Field;

import cla.CityClass;
import cla.HotelClass;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class BookingServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		if (req.getParameter("flag").equals("1")) {
			HotelClass[] spbhotels = {
					new HotelClass("Астория", "5", "Большая Морская ул.", "39",
							"+7 (812) 494-57-57",
							"http://www.theastoriahotel.ru/"),
					new HotelClass("Гранд Отель Европа", "5", "Михайловская ул.",
							"1/7", "+7 (812) 329-60-00",
							"http://grand-hotel-europe.com/") };
			HotelClass[] mschotels = {
					new HotelClass("Метрополь", "5", "Театральный пр.", "2",
							"+7 (499) 501 78 00",
							"http://www.metropol-moscow.ru/"),
					new HotelClass("Националь", "5", "Моховая ул.", "15/1",
							"+7 (812) 329-60-00", "http://www.national.ru/") };
			CityClass[] cities = { new CityClass(spbhotels), new CityClass(mschotels) };

			resp.getWriter().print("<table class=\"type2\">");
			resp.getWriter().print("<tr>");
			for (Field field : cities[Integer
					.parseInt(req.getParameter("city"))].hotels[0].getClass()
					.getDeclaredFields()) {
				resp.getWriter().print("<th>" + field.getName().toUpperCase() + "</th>");
			}
			resp.getWriter().print("</tr>");
			for (int i = 0; i < cities[Integer.parseInt(req
					.getParameter("city"))].hotels.length; i++) {
				resp.getWriter().print("<tr>");
				for (Field field : cities[Integer.parseInt(req
						.getParameter("city"))].hotels[i].getClass()
						.getDeclaredFields()) {
					try {
						resp.getWriter()
								.print("<td>"
										+ field.get(cities[Integer.parseInt(req
												.getParameter("city"))].hotels[i])
										+ "</td>");
					} catch (IllegalArgumentException | IllegalAccessException e) {
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
