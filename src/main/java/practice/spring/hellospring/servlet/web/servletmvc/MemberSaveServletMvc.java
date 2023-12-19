package practice.spring.hellospring.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice.spring.hellospring.servlet.domain.member.MemberData;
import practice.spring.hellospring.servlet.domain.member.MemberRepository;

import java.io.IOException;

@WebServlet(name="memberSaveServletMvc", urlPatterns = "/servlet-mvc/members/save")
public class MemberSaveServletMvc extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        MemberData memberData = new MemberData(username, age);
        memberData = memberRepository.save(memberData);

        String viewPath = "/WEB-INF/views/save.jsp";
        request.setAttribute("memberData", memberData);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
