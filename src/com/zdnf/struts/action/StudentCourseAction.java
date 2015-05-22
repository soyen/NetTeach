package com.zdnf.struts.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ModuleException;

import com.zdnf.model.Course;
import com.zdnf.service.IStudentDocumentService;
import com.zdnf.struts.form.CourseForm;
import com.zdnf.struts.form.NoticeForm;
import com.zdnf.util.PageModel;

public class StudentCourseAction extends StudentBaseDispatchAction {
	
	private IStudentDocumentService studentDocumentService;

	public void setStudentDocumentService(
			IStudentDocumentService studentDocumentService) {
		this.studentDocumentService = studentDocumentService;
	}


	public ActionForward findCourse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CourseForm courseForm = (CourseForm)form;
		int courseId = courseForm.getId();
		Course course = studentDocumentService.getCourse(courseId);
		request.setAttribute("course", course);
		return new ActionForward("/WEB-INF/jsp/student/course/showCourse.jsp");
	}
	
	public ActionForward listCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 HttpSession session = request.getSession();
		 int studentId = (Integer)session.getAttribute("studentId");
		 Set courseSet = studentDocumentService.getOwnCourse(studentId);
		 request.setAttribute("courseSet", courseSet);
     return new ActionForward("/WEB-INF/jsp/student/course/ownCourses.jsp");
 

	}
	public ActionForward deleteCourse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CourseForm courseForm = (CourseForm)form;
		HttpSession session = request.getSession();
		int studentId = (Integer)session.getAttribute("studentId");
		int courseId = courseForm.getId();
		String result = studentDocumentService.deleteCourse(studentId, courseId);
		request.setAttribute("result", result);
		return new ActionForward("/student/course/studentCourse.do?method=listCourse");
	}
	public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws ModuleException
	{
		   CourseForm courseForm = (CourseForm)form;
		   int id = courseForm.getId();
		   String fileName = studentDocumentService.getCourseFileName(id);
		   try
			 {
			 response.setContentType("application/x-msdownload");
			 response.setHeader("Content-Disposition",
			 "attachment;" + " filename="+
			 new String(fileName.getBytes(), "ISO-8859-1"));
			 studentDocumentService.writeCourse(response.getOutputStream(), courseForm.getId());
			 }
			 catch (Exception e)
			 {
				 throw new ModuleException(e.getMessage());
			 }
			 return null;
	  }

}
