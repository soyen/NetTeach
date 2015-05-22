package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ModuleException;

import com.zdnf.service.IStudentDocumentService;
import com.zdnf.struts.form.SourceForm;
import com.zdnf.util.PageModel;

public class StudentSourceAction extends StudentBaseDispatchAction {
	
	private IStudentDocumentService studentDocumentService;
	
	
	
	public void setStudentDocumentService(
			IStudentDocumentService studentDocumentService) {
		this.studentDocumentService = studentDocumentService;
	}

	//·ÖÒ³
	public ActionForward listSource(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		SourceForm sourceForm = (SourceForm) form;
		  PageModel pageModel = studentDocumentService.querySourse(sourceForm.getPageNo(),sourceForm.getPageSize(),sourceForm.getQueryStr());
		  request.setAttribute("pagemodel", pageModel);
         return new ActionForward("/WEB-INF/jsp/student/source/listSources.jsp");
     

	}
    
	public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws ModuleException
	{
		SourceForm sourceForm = (SourceForm) form;
		   int id = sourceForm.getId();
		   String fileName = studentDocumentService.getSourceFileName(id);
		   try
			 {
			 response.setContentType("application/x-msdownload");
			 response.setHeader("Content-Disposition",
			 "attachment;" + " filename="+
			 new String(fileName.getBytes(), "ISO-8859-1"));
			 studentDocumentService.writeSource(response.getOutputStream(), sourceForm.getId());
			 }
			 catch (Exception e)
			 {
				 throw new ModuleException(e.getMessage());
			 }
			 return null;
	  }

}
