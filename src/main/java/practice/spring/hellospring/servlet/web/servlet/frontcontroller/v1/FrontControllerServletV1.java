package practice.spring.hellospring.servlet.web.servlet.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v1.controller.MemberFormControllerV1;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v1.controller.MemberListControllerV1;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v1.controller.MemberSaveControllerV1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    Map<String, ControllerV1> controller = new HashMap<>();

    public FrontControllerServletV1() {
        controller.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controller.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controller.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ControllerV1 controllerV1 =  controller.get(request.getRequestURI());
        controllerV1.process(request, response);
    }
}
