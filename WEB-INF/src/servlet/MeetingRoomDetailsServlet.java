package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.MeetingRoomManager;
import model.MeetingRoom;
import model.User;

@WebServlet(name = "MeetingRoomDetailsServlet", urlPatterns = { "/MeetingRoomDetailsServlet" })
public class MeetingRoomDetailsServlet extends HttpServlet {

//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		doMain(req, res);
//	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doMain(req, res);
	}

	public void doMain(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession();

		String Room = req.getParameter("Room");

		MeetingRoomManager mrm = new MeetingRoomManager();
		MeetingRoom meetingRoom = mrm.getMeetingRoom(Room);

		req.setAttribute("MeetingRoom", meetingRoom);
		req.getRequestDispatcher("MeetingRoomDetails.jsp").forward(req, res);

	}
}
