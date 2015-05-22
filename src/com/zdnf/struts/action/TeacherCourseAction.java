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
import com.zdnf.service.ITeacherDocumentService;
import com.zdnf.struts.form.CourseForm;


public class TeacherCourseAction extends TeacherBaseDispatchAction {
	
	private ITeacherDocumentService teacherDocumentService;

	public void setTeacherDocumentService(
			ITeacherDocumentService teacherDocumentService) {
		this.teacherDocumentService = teacherDocumentService;
	}
	
	//增加
	public ActionForward addCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		CourseForm courseForm = (CourseForm) form;
		String courseName = courseForm.getCourseName();
		String info = courseForm.getInfo();
		String remark = courseForm.getRemark();
		String fileName= courseForm.getFileContent().getFileName();
		HttpSession session = request.getSession();
		int teacherId = (Integer)session.getAttribute("teacherId");
		byte [] fileData = courseForm.getFileContent().getFileData();
		
		teacherDocumentService.saveCourse(courseName,info,fileName,fileData,teacherId);
		return mapping.findForward("success");
	}
	//删除
	public ActionForward deleteCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		    CourseForm courseForm = (CourseForm) form;
		    int id = courseForm.getId();
		    teacherDocumentService.deleteCourse(id);
			return mapping.findForward("success");
	}
	//修改
	public ActionForward modifyCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		CourseForm courseForm = (CourseForm) form;
		 int id = courseForm.getId();
		 String courseName = courseForm.getCourseName();
		 String info = courseForm.getInfo();
		 String remark = courseForm.getRemark();
		 String fileName= courseForm.getFileContent().getFileName();
		 byte [] fileData = courseForm.getFileContent().getFileData();
		
		 teacherDocumentService.updateCourse(id,courseName,info,fileName,fileData,remark);
		return mapping.findForward("success");
	}
	//查找
	public ActionForward findCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 CourseForm courseForm = (CourseForm) form;
		 int id = courseForm.getId();
		 Course course = teacherDocumentService.getCourse(id);
		 request.setAttribute("course", course);
		return new ActionForward("/WEB-INF/jsp/teacher/course/modifyCourse.jsp");
	}
	//取得全部课程
	public ActionForward listCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  HttpSession session = request.getSession();
		  int teacherId = (Integer)session.getAttribute("teacherId");
		 
		  Set courseSet = teacherDocumentService.getTeacherCourse(teacherId);
		  
		  request.setAttribute("courseSet", courseSet);
         return new ActionForward("/WEB-INF/jsp/teacher/course/listCourses.jsp");
     

	}
	//取得选课信息
	public ActionForward listStudentCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  HttpSession session = request.getSession();
		  int teacherId = (Integer)session.getAttribute("teacherId");		 
		  Set courseSet = teacherDocumentService.getTeacherCourse(teacherId);		  
		  request.setAttribute("courseSet", courseSet);
         return new ActionForward("/WEB-INF/jsp/teacher/course/listStudentCourses.jsp");
     

	}
	
	public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws ModuleException
	{
		   CourseForm courseForm = (CourseForm)form;
		   int id = courseForm.getId();
		   String fileName = teacherDocumentService.getCourseFileName(id);
		   try
			 {
			 response.setContentType("application/x-msdownload");
			 response.setHeader("Content-Disposition",
			 "attachment;" + " filename="+
			 new String(fileName.getBytes(), "ISO-8859-1"));
			 teacherDocumentService.writeCourse(response.getOutputStream(), courseForm.getId());
			 }
			 catch (Exception e)
			 {
				 throw new ModuleException(e.getMessage());
			 }
			 return null;
	  }
	public ActionForward listStudent(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		   CourseForm courseForm = (CourseForm)form;
		   int id = courseForm.getId();
		   Set studentSet = teacherDocumentService.getCourseStudent(id);
		   request.setAttribute("studentSet", studentSet);
		   return new ActionForward("/WEB-INF/jsp/teacher/course/listStudent.jsp");
	}

}
