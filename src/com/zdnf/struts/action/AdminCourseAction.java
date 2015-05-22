package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ModuleException;

import com.zdnf.model.Course;
import com.zdnf.service.IAdminDocumentService;
import com.zdnf.struts.form.CourseForm;
import com.zdnf.util.PageModel;

public class AdminCourseAction extends AdminBaseDispatchAction {
	
	private IAdminDocumentService adminDocumentService;

	public void setAdminDocumentService(IAdminDocumentService adminDocumentService) {
		this.adminDocumentService = adminDocumentService;
	}
	
	//É¾³ý
	public ActionForward deleteCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		    CourseForm courseForm = (CourseForm) form;
		    int id = courseForm.getId();
            adminDocumentService.deleteCourse(id);
			return mapping.findForward("success");
	}
	
		
	//ÐÞ¸Ä
	public ActionForward modifyCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		CourseForm courseForm = (CourseForm) form;
		 int id = courseForm.getId();
		 String courseName = courseForm.getCourseName();
		 String info = courseForm.getInfo();
		 String remark = courseForm.getRemark();
		 String fileName= courseForm.getFileContent().getFileName();
		 byte [] fileData = courseForm.getFileContent().getFileData();
		
		adminDocumentService.updateCourse(id,courseName,info,fileName,fileData);
		return mapping.findForward("success");
	}
	
	//²éÕÒ
	public ActionForward findCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 CourseForm courseForm = (CourseForm) form;
		 int id = courseForm.getId();
		 Course course = adminDocumentService.getCourse(id);
		 request.setAttribute("course", course);
		return new ActionForward("/WEB-INF/jsp/admin/course/modifyCourse.jsp");
	}
	//·ÖÒ³
	public ActionForward listCourse(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		  CourseForm courseForm = (CourseForm) form;
		  PageModel pageModel = adminDocumentService.queryCourse(courseForm.getPageNo(),courseForm.getPageSize(),courseForm.getQueryStr());
		  request.setAttribute("pagemodel", pageModel);
         return new ActionForward("/WEB-INF/jsp/admin/course/listCourses.jsp");
     

	}
	
	public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws ModuleException
	{
		   CourseForm courseForm = (CourseForm)form;
		   int id = courseForm.getId();
		   String fileName = adminDocumentService.getFileName(id);
		   try
			 {
			 response.setContentType("application/x-msdownload");
			 response.setHeader("Content-Disposition",
			 "attachment;" + " filename="+
			 new String(fileName.getBytes(), "ISO-8859-1"));
			 adminDocumentService.write(response.getOutputStream(), courseForm.getId());
			 }
			 catch (Exception e)
			 {
				 throw new ModuleException(e.getMessage());
			 }
			 return null;
	  }

}
