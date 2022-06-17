package pl.pp.manager.controller;

import pl.pp.manager.model.Worker;
import pl.pp.manager.model.WorkersDBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class WorkersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Worker> workers = WorkersDBUtils.getWorkers();
        request.setAttribute("workers", workers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/worker/list.jsp");
        dispatcher.forward(request, response);
    }
}