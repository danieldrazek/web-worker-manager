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

@WebServlet("/update-worker")
public class UpdateWorkerController extends HttpServlet {

    @Resource(name = "web-worker-manager-db")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Worker worker = WorkersDBUtils.getWorkerById(id, dataSource);
        request.setAttribute("worker", worker);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/worker/update-worker.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Worker worker = new Worker(id, firstName, lastName, salary);

        WorkersDBUtils.updateWorker(worker, dataSource);

        List<Worker> workers = WorkersDBUtils.getWorkers(dataSource);
        request.setAttribute("workers", workers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/worker/list.jsp");
        dispatcher.forward(request, response);
    }
}