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
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MemberData> memberDataList = memberRepository.findAll();
        request.setAttribute("memberDataList", memberDataList);

        return new MyView("/WEB-INF/views/members.jsp", request, response);

    }
}
