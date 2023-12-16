<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="practice.spring.hellospring.servlet.domain.member.MemberRepository" %>
<%@ page import="practice.spring.hellospring.servlet.domain.member.MemberData" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();

    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    MemberData memberData = new MemberData(username, age);
    memberRepository.save(memberData);
%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=<%=memberData.getId()%></li>
    <li>username=<%=memberData.getUsername()%></li>
    <li>age=<%=memberData.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>