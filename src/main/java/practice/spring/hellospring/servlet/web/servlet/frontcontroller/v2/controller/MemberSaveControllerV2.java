package practice.spring.hellospring.servlet.web.servlet.frontcontroller.v2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice.spring.hellospring.servlet.domain.member.MemberData;
import practice.spring.hellospring.servlet.domain.member.MemberRepository;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.MyView;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v1.ControllerV1;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v2.ControllerV2;

import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        MemberData memberData = new MemberData(username, age);
        memberData = memberRepository.save(memberData);

        request.setAttribute("memberData", memberData);
        return new MyView("/WEB-INF/views/save.jsp");
    }
}
