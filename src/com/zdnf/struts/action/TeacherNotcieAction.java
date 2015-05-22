package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zdnf.model.Notice;
import com.zdnf.service.ITeacherDocumentService;
import com.zdnf.struts.form.NoticeForm;
import com.zdnf.util.PageModel;

public class TeacherNotcieAction extends TeacherBaseDispatchAction {
	
	private ITeacherDocumentService teacherDocumentService;

	public void setTeacherDocumentService(
			ITeacherDocumentService teacherDocumentService) {
		this.teacherDocumentService = teacherDocumentService;
	}



	public ActionForward listNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		  NoticeForm noticeForm = (NoticeForm) form;
		  PageModel pageModel = teacherDocumentService.queryNotice(noticeForm.getPageNo(),noticeForm.getPageSize(),noticeForm.getQueryStr());
		  request.setAttribute("pagemodel", pageModel);
       return new ActionForward("/WEB-INF/jsp/teacher/notice/listNotices.jsp");
   

	}
   
	public ActionForward findNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 NoticeForm noticeForm = (NoticeForm) form;
		 int id = noticeForm.getId();
		 Notice notice = teacherDocumentService.getNotice(id);
		 request.setAttribute("notice", notice);
		return new ActionForward("/WEB-INF/jsp/teacher/notice/showNotice.jsp");
	}
	
}
