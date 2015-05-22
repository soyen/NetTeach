package com.zdnf.struts.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ModuleException;


import com.zdnf.model.Source;

import com.zdnf.service.IAdminSourceService;

import com.zdnf.struts.form.SourceForm;
import com.zdnf.util.PageModel;

public class AdminSourceAction extends AdminBaseDispatchAction {
	
	private IAdminSourceService adminSourceService;

	public void setAdminSourceService(IAdminSourceService adminSourceService) {
		this.adminSourceService = adminSourceService;
	}
	//增加
	public ActionForward addSource(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		SourceForm sourceForm = (SourceForm) form;
		String fileName= sourceForm.getFileContent().getFileName();
		byte [] fileData = sourceForm.getFileContent().getFileData();
	    adminSourceService.saveSource(fileName,fileData);
		return mapping.findForward("success");
	}
	
	//删除
	public ActionForward deleteSource(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		   SourceForm sourceForm = (SourceForm) form;
		    int id = sourceForm.getId();
		    adminSourceService.deleteSource(id);
			return mapping.findForward("success");
	}	
		
	//查找
	public ActionForward findSource(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		SourceForm sourceForm = (SourceForm) form;
		 int id = sourceForm.getId();
		 Source source = adminSourceService.getSource(id);
		 request.setAttribute("source", source);
		return new ActionForward("/WEB-INF/jsp/admin/source/modifySource.jsp");
	}
	
	//分页
	public ActionForward listSource(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws ModuleException{
		SourceForm sourceForm = (SourceForm) form;
		  PageModel pageModel = adminSourceService.querySourse(sourceForm.getPageNo(),sourceForm.getPageSize(),sourceForm.getQueryStr());
		  request.setAttribute("pagemodel", pageModel);
         return new ActionForward("/WEB-INF/jsp/admin/source/listSources.jsp");
     

	}
    
	public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws ModuleException
	{
		SourceForm sourceForm = (SourceForm) form;
		   int id = sourceForm.getId();
		   String fileName = adminSourceService.getFileName(id);
		   try
			 {
			 response.setContentType("application/x-msdownload");
			 response.setHeader("Content-Disposition",
			 "attachment;" + " filename="+
			 new String(fileName.getBytes(), "ISO-8859-1"));
			 adminSourceService.write(response.getOutputStream(), sourceForm.getId());
			 }
			 catch (Exception e)
			 {
				 throw new ModuleException(e.getMessage());
			 }
			 return null;
	  }

}
