<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.Date" %>
<html>
<head>
<link rel = "stylesheet"
	href = "http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/
	bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<%! String greeting = "경영 철칙 : 강아지가 왕이다 인간은 신하에 불과하다";
		String tagline = "강아지 앞에서 머리를 조아리도록해라.";
	%>
	<div class = "jumbotron">
		<div class = "container">
			<h1 class = display-3>
				<p style= "font-family:'궁서체'";>
				<%= greeting %>
				</p>
			</h1>
		</div>
	</div>
	<div class = "container">
		<div class = "text-center">
				<h3><%= tagline %></h3>
				<% 
				response.setIntHeader("Refresh", 1);
				Date day = new java.util.Date();
				String am_pm;
				
				int hour = day.getHours();
				int minute = day.getMinutes();
				int second = day.getSeconds();
				if(hour / 12 == 0) {
					am_pm = "AM";
				} else {
					am_pm = "PM";
					hour = hour - 12;
				}
				String CT =  am_pm + " " + hour + "시 " + minute + "분 " + second + "초";
				out.println("현재 시간은 다음과 같읍니더 ^^ : " + CT + "\n");
				%>
				
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>

