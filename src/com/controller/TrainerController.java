package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Trainer;
import com.service.Service;

/**
 * Servlet implementation class TrainerController
 */
@WebServlet("/TrainerController")
public class TrainerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println(action);
		if("addTrainer".equals(action))
		{
			Trainer T = new Trainer();
			T.setTrainerId(request.getParameter("trainerId"));
			T.setTrainerName(request.getParameter("trainerName"));
			T.setTrainerExp(request.getParameter("trainerExp"));
			T.setTrainerStream(request.getParameter("trainerStream"));
			T.setTrainerNum(request.getParameter("trainerNumb"));
			T.setTrainerAdd(request.getParameter("trainerAdd"));
			T.setTrainerStatus(request.getParameter("trainerStatus"));
			Service service = new Service ();
			int update = service.addTrainer(T);
			if(update == 1)
			{
				RequestDispatcher rd = request.getRequestDispatcher("Success.html");
				rd.forward(request,response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Failed.html");
				rd.forward(request,response);
			}
			
		}
		else if ("viewTrainer".equals(action))
		{
			String id = request.getParameter("trainerId");
			Service service = new Service ();
			ArrayList<Trainer> arrT = service.viewdetails(id);
			request.setAttribute("details", arrT);
			RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
			rd.forward(request,response);
		}
	}

}
