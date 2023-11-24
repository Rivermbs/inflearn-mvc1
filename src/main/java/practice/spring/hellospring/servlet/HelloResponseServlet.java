package practice.spring.hellospring.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="helloResponseServlet", urlPatterns = "/response-servlet")
public class HelloResponseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setStatus(HttpServletResponse.SC_OK);
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        response.setHeader("Content-Type", "text/plain;charset=utf8;");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        setContent(response);
        setCookie(response);
        setRedirect(response);
    }

    private void setContent(HttpServletResponse response) {
        response.setContentLength(5);
    }

    private void setCookie(HttpServletResponse response) {

        Cookie cookie = new Cookie("aaa", "bbb");
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    private void setRedirect(HttpServletResponse response) {
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
