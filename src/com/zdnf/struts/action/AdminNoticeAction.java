package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zdnf.model.Notice;
import com.zdnf.service.IAdminDocumentService;
import com.zdnf.struts.form.NoticeForm;
import com.zdnf.util.PageModel;

public class AdminNoticeAction extends AdminBaseDispatchAction {
	
	

	private IAdminDocumentService adminDocumentService;
	


	public void setAdminDocumentService(IAdminDocumentService adminDocumentService) {
		this.adminDocumentService = adminDocumentService;
	}


	public ActionForward addNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		NoticeForm noticeForm = (NoticeForm) form;
		String title = noticeForm.getTitle();
		String content = noticeForm.getContent();
		adminDocumentService.saveNotice(title, content);
		return mapping.findForward("success");
	}
	
	
	public ActionForward deleteNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		    NoticeForm noticeForm = (NoticeForm) form;		
			adminDocumentService.deleteNotice(noticeForm.getId());
			return mapping.findForward("success");
	}
	
	
	public ActionForward modifyNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 NoticeForm noticeForm = (NoticeForm) form;
		 String title = noticeForm.getTitle();
		 String content = noticeForm.getContent();
		 int id = noticeForm.getId();
		adminDocumentService.updateNotice(id,title,content);
		return mapping.findForward("success");
	}
	
	
	public ActionForward findNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 NoticeForm noticeForm = (NoticeForm) form;
		 int id = noticeForm.getId();
		 Notice notice = adminDocumentService.getNotice(id);
		 request.setAttribute("notice", notice);
		return new ActionForward("/WEB-INF/jsp/admin/notice/modifyNotice.jsp");
	}
	
	public ActionForward listNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		  NoticeForm noticeForm = (NoticeForm) form;
		  PageModel pageModel = adminDocumentService.queryNotice(noticeForm.getPageNo(),noticeForm.getPageSize(),noticeForm.getQueryStr());
		  request.setAttribute("pagemodel", pageModel);
         return new ActionForward("/WEB-INF/jsp/admin/notice/listNotices.jsp");
     

	}

}
