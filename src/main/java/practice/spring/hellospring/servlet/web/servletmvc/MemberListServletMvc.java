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
import java.util.List;

@WebServlet(name="memberListServletMvc", urlPatterns = "/servlet-mvc/members")
public class MemberListServletMvc extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MemberData> memberDataList = memberRepository.findAll();
        request.setAttribute("memberDataList", memberDataList);

        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
