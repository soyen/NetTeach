package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zdnf.model.Classes;
import com.zdnf.service.IAdminDeptService;
import com.zdnf.struts.form.ClassesForm;
import com.zdnf.util.PageModel;

public class AdminClassesAction extends AdminBaseDispatchAction {

	     private IAdminDeptService adminDeptService;
    
	public void setAdminDeptService(IAdminDeptService adminDeptService) {
			this.adminDeptService = adminDeptService;
		}

	public ActionForward beforeAddClasses(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("deptList", adminDeptService.findAllDepartment());
		return new ActionForward("/WEB-INF/jsp/admin/classes/addClasses.jsp");
		
	}
	public ActionForward addClasses(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   ClassesForm classesForm = (ClassesForm)form;
		   String className = classesForm.getClassName();
		   int departmentId = Integer.parseInt(classesForm.getDeptList());
		   adminDeptService.saveClasses(className,departmentId);		
		   return new ActionForward("/admin/classes/listClass.do");
	}
	
	public ActionForward deleteClasses(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    ClassesForm classesForm = (ClassesForm)form;
		    int id = classesForm.getId();
		    adminDeptService.deleteClasses(id);
		    return new ActionForward("/admin/classes/listClass.do");
		
	}
	public ActionForward modifyClasses(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    ClassesForm classesForm = (ClassesForm)form;
		    int id = classesForm.getId();
		    String className = classesForm.getClassName();
			String maxCapacity = classesForm.getMaxCapacity();
		    adminDeptService.updateClasses(id, className, maxCapacity);
		    return new ActionForward("/admin/classes/listClass.do");
	}
	public ActionForward findClasses(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   ClassesForm classesForm = (ClassesForm)form;
		   int id = classesForm.getId();
		   Classes classes = adminDeptService.getClasses(id);
		   request.setAttribute("classes", classes);
		   return new ActionForward("/WEB-INF/jsp/admin/classes/modifyClasses.jsp");
		   
	}
	public ActionForward listClasses(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ClassesForm classesForm = (ClassesForm)form;
		 PageModel pageModel = adminDeptService.queryClasses(classesForm.getPageNo(),classesForm.getPageSize(),classesForm.getQueryStr());
		 request.setAttribute("pagemodel", pageModel);
		 return new ActionForward("/WEB-INF/jsp/admin/classes/listClasses.jsp");
	
	}
	
	
	
	
}
