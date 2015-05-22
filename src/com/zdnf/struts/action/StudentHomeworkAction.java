package com.zdnf.struts.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.ForwardAction;
import org.apache.struts.util.ModuleException;

import com.zdnf.service.IStudentHomeworkService;
import com.zdnf.struts.form.AnswerForm;

public class StudentHomeworkAction extends StudentBaseDispatchAction {
	
	private IStudentHomeworkService studentHomeworkService;

	public void setStudentHomeworkService(
			IStudentHomeworkService studentHomeworkService) {
		this.studentHomeworkService = studentHomeworkService;
	}


	public ActionForward listQuestion(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int courseID = Integer.parseInt(request.getParameter("courseID"));
		Set questionSet = studentHomeworkService.getCourseQuestion(courseID);
		request.setAttribute("courseID",courseID);
		request.setAttribute("questionSet", questionSet);
		return new ActionForward("/WEB-INF/jsp/student/homework/listQuestions.jsp");
	}
	
	//取得课程
	public ActionForward listCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  HttpSession session = request.getSession();
		  int studentId = (Integer)session.getAttribute("studentId");
		  Set courseSet = studentHomeworkService.getStudentCourse(studentId);		  
		  request.setAttribute("courseSet", courseSet);
         return new ActionForward("/WEB-INF/jsp/student/homework/ownCourses.jsp");
     

	}
	
	public ActionForward doHomework(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  AnswerForm answerForm = (AnswerForm)form;
		  int questionID = Integer.parseInt(request.getParameter("questionID"));	
		  HttpSession session = request.getSession();
		  int studentId = (Integer)session.getAttribute("studentId");
		  int courseId = Integer.parseInt(request.getParameter("courseID"));
		  String content = answerForm.getContent();
		  String title = request.getParameter("title");
		  studentHomeworkService.saveAnswer(studentId,questionID,content,title);
       return new ActionForward("/student/homework/studentHomework.do?method=listQuestion&courseID="+courseId);
   

	}
	
	public ActionForward beforeDoHomework(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  String questionTitle = request.getParameter("questionTitle");
		  String questionID = request.getParameter("questionID");
		  int questionId = Integer.parseInt(questionID);
		  HttpSession session = request.getSession();
		  int studentId = (Integer)session.getAttribute("studentId");
		  int courseId = Integer.parseInt(request.getParameter("courseID"));
		  if(studentHomeworkService.isDone(studentId, questionId)){
			  request.setAttribute("isDone", "已完成");
			  return new ActionForward("/student/homework/studentHomework.do?method=listQuestion&courseID="+courseId);
		  }
		  request.setAttribute("questionTitle", questionTitle);
		  request.setAttribute("questionID", questionID);
		  request.setAttribute("courseID", courseId);
      return new ActionForward("/WEB-INF/jsp/student/homework/doHomework.jsp");

	}
	public ActionForward listAnswer(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		HttpSession session = request.getSession();
		int studentId = (Integer)session.getAttribute("studentId");
		Set answerSet = studentHomeworkService.getAnswers(studentId);
		request.setAttribute("answerSet", answerSet);
        return new ActionForward("/WEB-INF/jsp/student/homework/listAnswers.jsp");

	}
	
}
