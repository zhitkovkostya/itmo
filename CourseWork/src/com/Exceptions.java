package com;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.*;

import exc.StringException;
import exc.NumberException;
import exc.DateException;
import exc.SubStringException;

@SuppressWarnings("serial")
public class Exceptions extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		if (req.getParameter("task").equals("1")) {
			String enteredString = req.getParameter("var1");
			try {
				checkNumber(enteredString);
				resp.getWriter().print("��� ������������� ����");
			} catch (NumberException e) {
				resp.getWriter().print(e);
			}
		} else if (req.getParameter("task").equals("2")) {
			String enteredString = req.getParameter("var1");
			try {
				checkDate(enteredString);
				resp.getWriter().print("��� ������������� ����");
			} catch (DateException e) {
				resp.getWriter().print(e);
			}
		} else if (req.getParameter("task").equals("3")) {
			Task substr = new Task(String.valueOf(Math.PI));
			String enteredString = req.getParameter("var1");
			try {
				checkSubString(substr.getAnswer(), enteredString);
				resp.getWriter().print("� PI ������������ ��������� ���������� ����");
			} catch (SubStringException e) {
				resp.getWriter().print(e);
			}
		} else if (req.getParameter("task").equals("4")) {
			Task captcha = new Task("CaPtChA");
			String enteredString = req.getParameter("var1");
			try {
				checkString(enteredString, captcha.getAnswer());
				resp.getWriter().print("��� ������������� �����");
			} catch (StringException e) {
				resp.getWriter().print(e);
			}
		}

	}

	static void checkNumber(String str) throws NumberException {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException eDef) {
			NumberException e = new NumberException("��� �� �����");
			throw e;
		}
	}

	static void checkDate(String str) throws DateException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(str.trim());
		} catch (ParseException eDef) {
			DateException e = new DateException("��� �� ����");
			throw e;
		}
	}

	static void checkString(String str, String ans) throws StringException {
		if (!(str.equals(ans))) {
			StringException e = new StringException(
					"�� ���������. ��������� �������");
			throw e;
		}
	}
	
	static void checkSubString(String str, String substr)
			throws SubStringException {
		if (!(str.contains(substr))) {
			SubStringException e = new SubStringException("� PI ��������� ���������� ���� �����������");
			throw e;
		}
	}

}