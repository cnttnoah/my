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
지폐금액		<INPUT TYPE="number" NAME="T" size="17" min="1" max="10000"><br>
동전의 가지 수		<input type="submit" value="+" name="action"/>  <input type="submit" value="-" name="action"/><br>
			동전금액	개수
</pre>

<%
int K=1;
String aaa = (String)request.getAttribute("KK");
if(aaa != null){
	K = Integer.parseInt(aaa);
}

String str_P="P";
String str_N="N";
for(int i=0;i<K;i++){
	str_P="P"+i;
	str_N="N"+i;
	out.print("<pre>			");
	out.print("<INPUT TYPE=\"number\" NAME="+str_P+" min=\"1\" max=\"10000\">	<INPUT TYPE=\"number\" NAME="+str_N+" min=\"1\" max=\"10000\"><br>");
	out.print("</pre>");
}
%>

<pre>		<input type="submit" value="계산" size="5" name="action"></pre>
</form>
<HR>
${result}<br>
${str}
</body>
</html>