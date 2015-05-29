package com.zdnf.android.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;

import com.zdnf.dao.INoticeDAO;
import com.zdnf.model.Notice;
import com.zdnf.struts.form.NoticeForm;

public class AndroidNoticeAction extends DispatchAction {
	
	
	private INoticeDAO noticeDAO;	
	
	public void setNoticeDAO(INoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	


//	public ActionForward addNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
//		NoticeForm noticeForm = (NoticeForm) form;
//		String title = noticeForm.getTitle();
//		String content = noticeForm.getContent();
//		adminDocumentService.saveNotice(title, content);
//		return mapping.findForward("success");
//	}
//	
//	
//	public ActionForward deleteNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
//		    NoticeForm noticeForm = (NoticeForm) form;		
//			adminDocumentService.deleteNotice(noticeForm.getId());
//			return mapping.findForward("success");
//	}
//	
//	
//	public ActionForward modifyNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
//		 NoticeForm noticeForm = (NoticeForm) form;
//		 String title = noticeForm.getTitle();
//		 String content = noticeForm.getContent();
//		 int id = noticeForm.getId();
//		adminDocumentService.updateNotice(id,title,content);
//		return mapping.findForward("success");
//	}
//	
//	
//	public ActionForward findNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
//		 NoticeForm noticeForm = (NoticeForm) form;
//		 int id = noticeForm.getId();
//		 Notice notice = adminDocumentService.getNotice(id);
//		 request.setAttribute("notice", notice);
//		return new ActionForward("/WEB-INF/jsp/admin/notice/modifyNotice.jsp");
//	}

	public ActionForward listNotice(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)throws Exception{
		  List<Notice> noticeList = noticeDAO.findAllNotice();
		  JSONArray jsonArray = new JSONArray(noticeList);
		  response.setContentType("text/html; charset=UTF-8");	
		  response.getWriter().println(jsonArray.toString());
          return null;

	}

}
