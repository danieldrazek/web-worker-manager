package pl.pp.manager.controller;

import pl.pp.manager.model.Worker;
import pl.pp.manager.model.WorkersDBUtils;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/delete-worker")
public class DeleteWorkerController extends HttpServlet {

    @Resource(name = "web-worker-manager-db")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        WorkersDBUtils.deleteWorkerById(id, dataSource);

        response.sendRedirect(request.getContextPath() + "/list");
    }

}