package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zdnf.model.Department;
import com.zdnf.service.IAdminDeptService;
import com.zdnf.struts.form.DepartmentForm;
import com.zdnf.util.PageModel;


public class AdminDepartmentAction extends AdminBaseDispatchAction {
	
	private IAdminDeptService adminDeptService;

	public void setAdminDeptService(IAdminDeptService adminDeptService) {
		this.adminDeptService = adminDeptService;
	}
	
	public ActionForward addDepartment(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		DepartmentForm departmentForm = (DepartmentForm) form;
		String departmentName = departmentForm.getDepartmentName();
		String introduce = departmentForm.getIntroduce();
		adminDeptService.saveDepartment(departmentName, introduce);
		return mapping.findForward("success");
	}
	
	public ActionForward deleteDepartment(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		DepartmentForm departmentForm = (DepartmentForm) form;
	    adminDeptService.deleteDepartment(departmentForm.getId());
		return mapping.findForward("success");
    }
	
	public ActionForward modifyDepartment(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 DepartmentForm departmentForm = (DepartmentForm) form;
		 String departmentName = departmentForm.getDepartmentName();
		 String introduce = departmentForm.getIntroduce();
		  int id = departmentForm.getId();
		 adminDeptService.updateDepartment(id,departmentName,introduce);
		return mapping.findForward("success");
	}
	public ActionForward findDepartment(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		DepartmentForm departmentForm = (DepartmentForm) form;
		 int id = departmentForm.getId();
		 Department department = adminDeptService.getDepartment(id);
		 request.setAttribute("department", department);
		return new ActionForward("/WEB-INF/jsp/admin/department/modifyDepartment.jsp");
	}
	
	public ActionForward listDepartment(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		  DepartmentForm departmentForm = (DepartmentForm) form;
		  PageModel pageModel = adminDeptService.queryDepartment(departmentForm.getPageNo(),departmentForm.getPageSize(),departmentForm.getQueryStr());
		  request.setAttribute("pagemodel", pageModel);
        return new ActionForward("/WEB-INF/jsp/admin/department/listDepartments.jsp");
    

	}
	

}
