package practice.spring.hellospring.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="helloJsonServlet", urlPatterns = "/request-json")
public class HelloJsonServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream sis = request.getInputStream();

        String json = StreamUtils.copyToString(sis, StandardCharsets.UTF_8);
        System.out.println("JSON DATA : " + json);
    }
}
