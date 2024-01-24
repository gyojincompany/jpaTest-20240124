<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원리스트</h2>
	<hr>
	<c:forEach items="${memberlist}" var="member">
		회원번호 : ${member.membernum} /
		회원아이디 : ${member.memberid} /
		회원비밀번호 : ${member.memberpw} /
		회원이름 : ${member.membername} /
		회원나이 : ${member.memberage} / <br><br>
		
	</c:forEach>
	
</body>
</html>