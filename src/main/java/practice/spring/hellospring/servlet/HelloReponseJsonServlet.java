package practice.spring.hellospring.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice.spring.hellospring.vo.HelloVO;

import java.io.IOException;

@WebServlet(name = "helloReponseJsonServlet", urlPatterns = "/response-json")
public class HelloReponseJsonServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloVO helloVO = new HelloVO();
        helloVO.setName("mbpark");
        helloVO.setAge(35);

        //Object mapper 를 활용한 json 형식의 String 만들기
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonHelloVo = objectMapper.writeValueAsString(helloVO);

        response.getWriter().println(jsonHelloVo);
    }
}
