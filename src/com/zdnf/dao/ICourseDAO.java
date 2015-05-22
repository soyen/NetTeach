package com.zdnf.dao;

import java.util.List;
import com.zdnf.model.Course;
import com.zdnf.util.PageModel;

public interface ICourseDAO {
	
	    public void saveCourse(Course course);
		
		public void deleteCourse(Course course);
		
		public Course getCourseById(int id);
		
		public void updateCourse(Course course);
		
		public List<Course> findAllCourse();
		
		public PageModel findCourseByPage(final int pageNo,final int pageSize,final String queryStr);
		
		

}
