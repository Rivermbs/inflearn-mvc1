package practice.spring.hellospring.servlet.web.servlet.frontcontroller.v2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.MyView;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v1.ControllerV1;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v2.ControllerV2;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp", request, response);
    }
}
