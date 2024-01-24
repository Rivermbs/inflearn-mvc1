package practice.spring.hellospring.servlet.web.servlet.frontcontroller.v2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v1.ControllerV1;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v1.controller.MemberFormControllerV1;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v1.controller.MemberListControllerV1;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v1.controller.MemberSaveControllerV1;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v2.controller.MemberFormControllerV2;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v2.controller.MemberListControllerV2;
import practice.spring.hellospring.servlet.web.servlet.frontcontroller.v2.controller.MemberSaveControllerV2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    Map<String, ControllerV2> controller = new HashMap<>();

    public FrontControllerServletV2() {
        controller.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controller.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controller.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ControllerV2 controllerV2 =  controller.get(request.getRequestURI());
        controllerV2.process(request, response);
    }
}
