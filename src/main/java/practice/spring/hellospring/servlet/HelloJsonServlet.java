package practice.spring.hellospring.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;
import practice.spring.hellospring.vo.HelloVO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="helloJsonServlet", urlPatterns = "/request-json")
public class HelloJsonServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream sis = request.getInputStream();

        String jsonParam = StreamUtils.copyToString(sis, StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();

        // json to String
        HelloVO helloVO = mapper.readValue(jsonParam, HelloVO.class);
        System.out.println(helloVO.getAge());
        System.out.println(helloVO.getName());
    }
}
