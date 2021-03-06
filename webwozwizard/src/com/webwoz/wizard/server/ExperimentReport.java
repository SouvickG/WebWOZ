package com.webwoz.wizard.server;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ExperimentReport extends HttpServlet {

	private Database db = new Database();
	private String[][] data;
	private String output;
	private String sql;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		output = "<html><head><meta http-equiv=\"content-type\" content=\"text/html; charset=ISO-8859-1\"><title>WebWOZ Report</title><script type=\"text/javascript\" language=\"javascript\">function printpage(){window.print();}</script></head><body onload=\"printpage()\">";

		if (request.getParameter("p1") != null) {
			if (request.getParameter("p1").equals("experiment")) {
				sql = "Select * from output where experiment = "
						+ request.getParameter("p2") + " order by id";
			} else {
				if (request.getParameter("p1").equals("user")) {
					sql = "Select * from output where experiment = "
							+ request.getParameter("p2") + " and user = "
							+ request.getParameter("p3") + " order by id";
				}
			}
		} else {
			sql = "Select * from output";
		}

		data = db.retrieveData(sql);

		output = output
				+ "<table style=\"font-family:verdana, sans-serif; font-size:small; border-collapse:separate;\"><tr style=\"background-color:#CCCCCC;\"><th style=\"border: 1px solid #000000;\">Experiment ID</th><th style=\"border: 1px solid #000000;\">User ID</th><th style=\"border: 1px solid #000000;\">Timestamp</th><th style=\"border: 1px solid #000000;\">Sent</th><th style=\"border: 1px solid #000000;\">Original</th style=\"border: 1px solid #000000;\"><th style=\"border: 1px solid #000000;\">Translation Text Flag</th><th style=\"border: 1px solid #000000;\">Original Text Flag</th><th style=\"border: 1px solid #000000;\">Translation Audio Flag</th><th style=\"border: 1px solid #000000;\">Original Audio Flag</th><th style=\"border: 1px solid #000000;\">Translation MM Flag</th><th style=\"border: 1px solid #000000;\">Original MM Flag</th></tr>";
		if (data != null) {
			for (int i = 0; i < data.length; i++) {
				output = output
						+ "<tr><td style=\"border: 1px solid #000000; text-align: center;\">"
						+ data[i][7]
						+ "</td><td style=\"border: 1px solid #000000; text-align: center;\">"
						+ data[i][17]
						+ "</td><td style=\"border: 1px solid #000000; text-align: center;\">"
						+ data[i][8]
						+ "</td><td style=\"border: 1px solid #000000;\">"
						+ data[i][4]
						+ "</td><td style=\"border: 1px solid #000000;\">"
						+ data[i][1]
						+ "</td><td style=\"border: 1px solid #000000; text-align: center;\">"
						+ data[i][10]
						+ "</td><td style=\"border: 1px solid #000000; text-align: center;\">"
						+ data[i][11]
						+ "</td><td style=\"border: 1px solid #000000; text-align: center;\">"
						+ data[i][12]
						+ "</td><td style=\"border: 1px solid #000000; text-align: center;\">"
						+ data[i][13]
						+ "</td><td style=\"border: 1px solid #000000; text-align: center;\">"
						+ data[i][14]
						+ "</td><td style=\"border: 1px solid #000000; text-align: center;\">"
						+ data[i][15] + "</td></tr>";
			}
		}
		output = output + "</table>";
		output = output + "</body></html>";
		PrintWriter out = response.getWriter();
		out.println(output);
	}

}
