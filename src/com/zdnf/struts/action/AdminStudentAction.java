package com.zdnf.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zdnf.model.Department;
import com.zdnf.model.Student;
import com.zdnf.service.IAdminDeptService;
import com.zdnf.service.IAdminUserService;
import com.zdnf.struts.form.StudentForm;
import com.zdnf.util.PageModel;

public class AdminStudentAction extends AdminBaseDispatchAction {
	
	private IAdminUserService adminUserService;
	
	private IAdminDeptService adminDeptService;
	
	

	public void setAdminUserService(IAdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}



	public void setAdminDeptService(IAdminDeptService adminDeptService) {
		this.adminDeptService = adminDeptService;
	}
	
	public ActionForward beforeAddStudent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List deptList = adminDeptService.findAllDepartment();
		Department department = new Department();
		department.setId(0);
		department.setDepartmentName("«Î—°‘Ò..");
		deptList.add(0, department);
		request.setAttribute("deptList", deptList);
		
		return new ActionForward("/WEB-INF/jsp/admin/student/addStudent.jsp");
	
	}
	public ActionForward addStudent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {	   
		   StudentForm studentForm = (StudentForm)form;
		   String username = studentForm.getUsername();
		   String password = studentForm.getPassword();
		   String name = studentForm.getName();
		   String sex = studentForm.getSex();
		   String info = studentForm.getInfo();
		   String major = studentForm.getMajor();
		   String studentNo = studentForm.getStudentNo();
		   int classesId = Integer.parseInt(studentForm.getSelectClass());
		   adminUserService.saveStudent(username, password, name, sex, info, studentNo, major, classesId);		   
		   return new ActionForward("/admin/student/listStudent.do");
	}
	public ActionForward deleteStudent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   StudentForm studentForm = (StudentForm)form;
		    int id = studentForm.getId();
		    adminUserService.deleteStudent(id);
		    return new ActionForward("/admin/student/listStudent.do");
		
	}
	public ActionForward modifyStudent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    StudentForm studentForm = (StudentForm)form;
		    int id = studentForm.getId();
		    String username = studentForm.getUsername();
			String password = studentForm.getPassword();
			String name = studentForm.getName();
			String sex = studentForm.getSex();
		    String info = studentForm.getInfo();
		    String major = studentForm.getMajor();
			String studentNo = studentForm.getStudentNo();		
		    adminUserService.updateStudent(id, username, password, name, sex, info, studentNo, major);
		    return new ActionForward("/admin/student/listStudent.do");
	}
	public ActionForward findStudent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   StudentForm studentForm = (StudentForm)form;
		   int id = studentForm.getId();
		   Student student = adminUserService.getStudent(id);
		   request.setAttribute("student", student);
		   return new ActionForward("/WEB-INF/jsp/admin/student/modifyStudent.jsp");
		   
	}
	public ActionForward listStudent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 StudentForm studentForm = (StudentForm)form;
		 int pageNo = studentForm.getPageNo();
		 int pageSize = studentForm.getPageSize();
		 String queryStr = studentForm.getQueryStr();
		 PageModel pageModel = adminUserService.queryStudent(pageNo, pageSize, queryStr);
		 request.setAttribute("pagemodel", pageModel);
		 return new ActionForward("/WEB-INF/jsp/admin/student/listStudents.jsp");
	
	}

}
