package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zdnf.model.Notice;
import com.zdnf.service.IStudentDocumentService;
import com.zdnf.struts.form.NoticeForm;
import com.zdnf.util.PageModel;

public class StudentNoticeAction extends StudentBaseDispatchAction {
	
	private IStudentDocumentService studentDocumentService;
	
	

	public void setStudentDocumentService(
			IStudentDocumentService studentDocumentService) {
		this.studentDocumentService = studentDocumentService;
	}

	public ActionForward listNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		  NoticeForm noticeForm = (NoticeForm) form;
		  PageModel pageModel = studentDocumentService.queryNotice(noticeForm.getPageNo(),noticeForm.getPageSize(),noticeForm.getQueryStr());
		  request.setAttribute("pagemodel", pageModel);
       return new ActionForward("/WEB-INF/jsp/student/notice/listNotices.jsp");
   

	}
   
	public ActionForward findNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 NoticeForm noticeForm = (NoticeForm) form;
		 int id = noticeForm.getId();
		 Notice notice = studentDocumentService.getNotice(id);
		 request.setAttribute("notice", notice);
		return new ActionForward("/WEB-INF/jsp/student/notice/showNotice.jsp");
	}

}
