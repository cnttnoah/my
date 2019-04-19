<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>계산기</title>
<meta charset="utf-8" />
</head>

<body>
<H3>계산기</H3>
<HR>

<form name=form1 method=post>
<pre>
지폐금액		<INPUT TYPE="number" NAME="price" size="17" min="1" max="10000"><br>
동전의 가지 수		<input type="submit" value="+" name="btn"/>  <input type="submit" value="-" name="btn"/><br>
			동전금액	개수
</pre>

<%
int num=1;
String s=(String)request.getAttribute("number");
if(s != null){
	num = Integer.parseInt(s);
}

String str_P;
String str_N;
for(int i=0;i<num;i++){
	str_P="str_P["+i+"]";
	str_N="str_N["+i+"]";
	out.print("<pre>			");
	out.print("<INPUT TYPE=\"number\" NAME="+str_P+" min=\"1\" max=\"10000\">	<INPUT TYPE=\"number\" NAME="+str_N+" min=\"1\" max=\"10000\"><br>");
	out.print("</pre>");
}
%>

<pre>		<input type="submit" value="계산" size="5" name="btn"></pre>
</form>
<HR>
${Par.str}<br>
</body>
</html>