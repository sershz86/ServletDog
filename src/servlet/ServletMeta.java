package servlet;

import data.Dog;
import data.DogManage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletMeta extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        int id = Integer.parseInt(req.getParameter("id"));
        if (id == -1) {
            req.setAttribute("ListOfDogs", DogManage.getInstance().getDogs());
        } else {
            Dog dog;
            if ((dog = DogManage.getInstance().getDogById(id)) != null)
                req.setAttribute("dog", dog);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        if (req.getMethod().equals("POST")) {
            DogManage.getInstance().update(id, name, type);
            req.setAttribute("dog", "Dog was changed");
        } else doPut(req, resp);
        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        DogManage.getInstance().add(name, type);
    }

}

