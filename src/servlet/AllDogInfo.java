package servlet;

import data.DogManage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllDogInfo extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ListOfDogs", DogManage.getInstance().getDogs());
        forward("/index.jsp", req, resp);
    }
}
