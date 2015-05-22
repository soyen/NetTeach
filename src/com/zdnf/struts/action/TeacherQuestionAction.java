package com.zdnf.struts.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ModuleException;

import com.zdnf.model.Answer;
import com.zdnf.model.Course;
import com.zdnf.service.ITeacherHomeworkService;
import com.zdnf.struts.form.CourseForm;
import com.zdnf.struts.form.QuestionForm;

public class TeacherQuestionAction extends TeacherBaseDispatchAction {
	
	private ITeacherHomeworkService teacherHomeworkService;
	
	
	
	public void setTeacherHomeworkService(
			ITeacherHomeworkService teacherHomeworkService) {
		this.teacherHomeworkService = teacherHomeworkService;
	}



	//取得课程
	public ActionForward listCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  HttpSession session = request.getSession();
		  int teacherId = (Integer)session.getAttribute("teacherId");
		 
		  Set courseSet = teacherHomeworkService.getTeacherCourse(teacherId);
		  
		  request.setAttribute("courseSet", courseSet);
         return new ActionForward("/WEB-INF/jsp/teacher/homework/listCourses.jsp");
     

	}
	//添加作业
	public ActionForward addListCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  HttpSession session = request.getSession();
		  int teacherId = (Integer)session.getAttribute("teacherId");		 
		  Set courseSet = teacherHomeworkService.getTeacherCourse(teacherId);		  
		  request.setAttribute("courseSet", courseSet);
         return new ActionForward("/WEB-INF/jsp/teacher/homework/addListCourses.jsp");
     

	}
	//取得问题
	public ActionForward listQuestion(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  int courseId = Integer.parseInt(request.getParameter("courseId"));
		  
		  request.setAttribute("courseId",courseId);
		 
		  Set questionSet = teacherHomeworkService.getQuestions(courseId);
		  request.setAttribute("questionSet", questionSet);
         return new ActionForward("/WEB-INF/jsp/teacher/homework/listQuestions.jsp");
     

	}
	//取得作业
	public ActionForward listAnswer(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  QuestionForm questionForm = (QuestionForm)form;
		  int id = questionForm.getId();
		  Set answerSet = teacherHomeworkService.getAnswers(id);
		  request.setAttribute("answerSet", answerSet);
		  request.setAttribute("questionId", id);
         return new ActionForward("/WEB-INF/jsp/teacher/homework/listAnswers.jsp");
     

	}
	public ActionForward beforeAddQuestion(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  request.setAttribute("courseID",request.getParameter("courseId"));
          return new ActionForward("/WEB-INF/jsp/teacher/homework/addQuestion.jsp");
   

	}
	public ActionForward addQuestion(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		 QuestionForm questionForm = (QuestionForm)form;
		 String title = questionForm.getTitle();
		 String content = questionForm.getContent();
		 String score = questionForm.getScore();
		 int courseId = Integer.parseInt(request.getParameter(("courseID")));
	     teacherHomeworkService.saveQuestion(title, content, score, courseId);
         return new ActionForward("/teacher/homework/teacherQuestion.do?method=listQuestion&courseId="+courseId);

	}
	//取得课程
	public ActionForward deleteQuestion(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  QuestionForm questionForm = (QuestionForm)form;
		  int id = questionForm.getId();	
		  int courseId = Integer.parseInt(request.getParameter("courseId"));
		  teacherHomeworkService.deleteQuestion(id);
         return new ActionForward("/teacher/homework/teacherQuestion.do?method=listQuestion&id="+courseId);
     

	}
	
	//打分
	public ActionForward score(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		
		  int answerId = Integer.parseInt(request.getParameter("answerId"));		  
		  int questionId = Integer.parseInt(request.getParameter("questionId"));
		  String score = request.getParameter("score");
		  teacherHomeworkService.saveScore(answerId, score);
          return new ActionForward("/teacher/homework/teacherQuestion.do?method=listAnswer&id="+questionId);
      
	}

}
