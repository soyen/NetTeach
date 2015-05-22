package com.zdnf.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zdnf.dao.IClassesDAO;
import com.zdnf.dao.ICourseDAO;
import com.zdnf.dao.IDepartmentDAO;
import com.zdnf.dao.IStudentDAO;
import com.zdnf.dao.ITeacherDAO;

import com.zdnf.model.Classes;
import com.zdnf.model.Course;
import com.zdnf.model.Department;
import com.zdnf.model.Student;
import com.zdnf.model.Teacher;
import com.zdnf.service.IDwrService;

public class DwrService implements IDwrService {
	
	private IDepartmentDAO departmentDAO;
	
	private ITeacherDAO teacherDAO;
	
	private ICourseDAO courseDAO;
	
	private IStudentDAO studentDAO;

	private IClassesDAO classesDAO;
	
	
	

	public void setClassesDAO(IClassesDAO classesDAO) {
		this.classesDAO = classesDAO;
	}



	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public void setTeacherDAO(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public void setDepartmentDAO(IDepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	
   //查找部门
	public Map<Integer, String> findAllDepartment() {
		int j = 0;
		Department department = null;
		Map<Integer, String> deptMap = new HashMap<Integer, String>();
		List<Department> deptList = departmentDAO.findAllDepartment();
		deptMap.put(0, "请选择...");
		for(int i =1;i<=deptList.size();i++){
			
			department = (Department)deptList.get(j);
			deptMap.put((Integer)department.getId(),department.getDepartmentName());
			j++;
			
			
		}
		return deptMap;
	}


   //查找教师
	@Override
	public Map<Integer, String> findTeacher(int deptId) {
		Map<Integer, String> teacherMap = new HashMap<Integer, String>();
		if(deptId!=0){
		Teacher teacher = null;
		
		Department department = departmentDAO.getDepartmentById(deptId);
		Set<Teacher> teacherSet = department.getTeachers();
	    Iterator<Teacher> iter = teacherSet.iterator();
	    teacherMap.put(0, "请选择...");
	    while(iter.hasNext()){
	    	
	    	teacher = (Teacher)iter.next();
	    	teacherMap.put(teacher.getId(),teacher.getName());
	    	
	    }
		}
		return teacherMap;
		
	}


   //查找课程
	@Override
	public Set findCourse(int teacherID) {
	    Set<Course> courseSet = new HashSet();
	    Set<Course> courseSetTemp = new HashSet();
	    if(teacherID!=0){
	    Teacher teacher = teacherDAO.getTeacherById(teacherID);  	  
	    courseSetTemp = teacher.getCourses();
	    }
	    Iterator<Course> iterator = courseSetTemp.iterator();
	    while(iterator.hasNext()){
	    	Course course = new Course();
	    	Course courseTemp = iterator.next();
	    	course.setId(courseTemp.getId());
	    	course.setCourseName(courseTemp.getCourseName());
	    	course.setInfo(courseTemp.getInfo());
	    	courseSet.add(course);
	    }
		return courseSet;
	    
	}


 //增加课程
	@Override
	public String addCourse(int studentId,int courseId) {
		String result = "添加失败或已添加该课程";
		Student student = studentDAO.getStudentById(studentId);
		Course course = courseDAO.getCourseById(courseId);
		Set<Course> courseSet = student.getCourses();	
			if(courseSet.add(course))
				result = "添加成功";	
		studentDAO.saveStudent(student);		
		return result;
	}


  



	@Override
	public Set findClasses(int deptID) {
		Set classSet = new HashSet();
	    if(deptID!=0){
	    Department department = departmentDAO.getDepartmentById(deptID);  
	    classSet = department.getClasses();
	    }
		return classSet;
	}

	@Override
	public void updateClass(int id,String className) {
		Classes classes = classesDAO.getClassesById(id);
		classes.setClassName(className);
		classesDAO.updateClasses(classes);
				
	}

	@Override
	public void deleteClass(int id) {
		classesDAO.deleteClasses(classesDAO.getClassesById(id));
		
	}

	@Override
	public Set findTeacherSet(int deptID) {
		Set teacherSet = new HashSet();
	    if(deptID!=0){
	    Department department = departmentDAO.getDepartmentById(deptID);  
	    teacherSet = department.getTeachers();
	    }
		return teacherSet;
	}

	@Override
	public void updateTeacher(int id, String username, String password,
			String teacherNo, String sex, String title, String info, String name) {
		Teacher teacher = teacherDAO.getTeacherById(id);
		teacher.setUsername(username);
		teacher.setPassword(password);
		teacher.setTeacherNo(teacherNo);
		teacher.setTitle(title);
		teacher.setSex(sex);
		teacher.setInfo(info);
		teacher.setName(name);
		teacherDAO.updateTeacher(teacher);
		
	}

	@Override
	public void deleteTeacher(int id) {
		teacherDAO.deleteTeacher(teacherDAO.getTeacherById(id));
		
	}

	@Override
	public Map<Integer, String> findClass(int deptId) {
		Map<Integer, String> classMap = new HashMap<Integer, String>();
		if(deptId!=0){
		Classes classes = null;
		classMap.put(0, "请选择...");
		Department department = departmentDAO.getDepartmentById(deptId);
		Set<Classes> classesSet = department.getClasses();
	    Iterator<Classes> iter = classesSet.iterator();
	    while(iter.hasNext()){
	    	
	    	classes = (Classes)iter.next();
	    	classMap.put(classes.getId(),classes.getClassName());
	    	
	    }
		}
		return classMap;
	}
	public Set findStudent(int classID) {
		Set studentSet = new HashSet();
	    if(classID!=0){
	    Classes classes = classesDAO.getClassesById(classID);
	    studentSet = classes.getStudents();
	    }
		return studentSet;
	}

	@Override
	public void updateStudent(int id, String username, String password,
			String studentNo, String sex, String major, String info, String name) {
		Student student = studentDAO.getStudentById(id);
		student.setUsername(username);
		student.setPassword(password);
		student.setStudentNo(studentNo);
		student.setMajor(major);
		student.setSex(sex);
		student.setInfo(info);
		student.setName(name);
		studentDAO.updateStudent(student);
		
	}

	@Override
	public void deleteStudent(int id) {
		Student student = studentDAO.getStudentById(id);
		Classes classes = student.getClasses();
		classes.setCapacity(classes.getCapacity()-1);
		studentDAO.deleteStudent(student);
		
	}
}
