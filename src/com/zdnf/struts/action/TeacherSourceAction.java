package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ModuleException;

import com.zdnf.model.Source;
import com.zdnf.service.ITeacherDocumentService;
import com.zdnf.struts.form.SourceForm;
import com.zdnf.util.PageModel;

public class TeacherSourceAction extends TeacherBaseDispatchAction {
	
	private ITeacherDocumentService teacherDocumentService;
	
	

	public void setTeacherDocumentService(
			ITeacherDocumentService teacherDocumentService) {
		this.teacherDocumentService = teacherDocumentService;
	}

	//Ôö¼Ó
	public ActionForward addSource(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		SourceForm sourceForm = (SourceForm) form;		
		String fileName= sourceForm.getFileContent().getFileName();
		byte [] fileData = sourceForm.getFileContent().getFileData();
		teacherDocumentService.saveSource(fileName,fileData);
		return mapping.findForward("success");
	}
	
	
	//·ÖÒ³
	public ActionForward listSource(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		SourceForm sourceForm = (SourceForm) form;
		  PageModel pageModel = teacherDocumentService.querySourse(sourceForm.getPageNo(),sourceForm.getPageSize(),sourceForm.getQueryStr());
		  request.setAttribute("pagemodel", pageModel);
         return new ActionForward("/WEB-INF/jsp/teacher/source/listSources.jsp");
     

	}
    
	public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws ModuleException
	{
		SourceForm sourceForm = (SourceForm) form;
		   int id = sourceForm.getId();
		   String fileName = teacherDocumentService.getSourceFileName(id);
		   try
			 {
			 response.setContentType("application/x-msdownload");
			 response.setHeader("Content-Disposition",
			 "attachment;" + " filename="+
			 new String(fileName.getBytes(), "ISO-8859-1"));
			 teacherDocumentService.writeSource(response.getOutputStream(), sourceForm.getId());
			 }
			 catch (Exception e)
			 {
				 throw new ModuleException(e.getMessage());
			 }
			 return null;
	  }

}
