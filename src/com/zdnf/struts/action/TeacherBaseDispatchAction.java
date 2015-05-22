package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.RedirectingActionForward;
import org.apache.struts.actions.DispatchAction;

import com.zdnf.model.Teacher;

public class TeacherBaseDispatchAction extends DispatchAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		Teacher teacher = (Teacher)session.getAttribute("user");
		if(teacher!=null){
		return super.execute(mapping, form, request, response);
		}else{
			
			return new RedirectingActionForward("/index.jsp");
		}
		
	}

	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return new RedirectingActionForward("/index.jsp");
	}
}
