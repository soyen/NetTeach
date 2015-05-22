var teacherCache = {};
var courseCache = {};
var classCache = {};
var studentCache = {};
//显示部门下拉
function fillDepartment() {
	DwrService.findAllDepartment(callBackDept);
}

var callBackDept=function(deptList){
	dwr.util.removeAllOptions("selectDept");
	dwr.util.addOptions("selectDept",deptList);
};

//显示教师下拉
function displayTeacher(dept){
	fillTeacher(dept.value);
}

function fillTeacher(theDeptID){
	DwrService.findTeacher(theDeptID,callBackTeacher);
}
var callBackTeacher=function(teacherList){
	dwr.util.removeAllOptions("selectTeacher");
	dwr.util.addOptions("selectTeacher",teacherList);
};


//显示课程内容
function displayCourse(teacherId){
	fillCourse(teacherId.value);
}
function fillCourse(theTeacherId){
	DwrService.findCourse(theTeacherId,callBackCourse);
}
var callBackCourse=function(courseList){
	
	dwr.util.removeAllRows("coursebody", { filter:function(tr) {
	      return (tr.id != "pattern");}});
	
	var course,id;
	for(var i = 0;i<courseList.length;i++){
		
		course = courseList[i];
		  id = course.id;
		  dwr.util.cloneNode("pattern", { idSuffix:id });
		  
	      dwr.util.setValue("tableCourseName" + id, course.courseName);
	      
	      dwr.util.setValue("tableInfo" + id, course.info);
	     
	      $("pattern" + id).style.display = "";
	   
	      courseCache[id] = course;
	      
	}

}
//选课
function addCourseClicked(studentId,courseID){

	var id = courseID.substring(3);
	var result;
	if (confirm("确认添加")) {
	DwrService.addCourse(studentId,id,callBackAddCourse);
	}
		
}
var callBackAddCourse = function (result){
	alert(result);
}

//显示班级内容
function displayClasses(deptId){
	fillClass(deptId.value);
  }

function fillClass(theDeptId){
	DwrService.findClasses(theDeptId,callBackClass);
}

var callBackClass=function(classList){
	
	dwr.util.removeAllRows("classbody", { filter:function(tr) {
	      return (tr.id != "pattern");}});
	
	var classes,id;
	for(var i = 0;i<classList.length;i++){
		
		classes = classList[i];
		  id = classes.id;
		  dwr.util.cloneNode("pattern", { idSuffix:id });
		  
	      dwr.util.setValue("TableclassName" + id, classes.className);
	      
	      dwr.util.setValue("Tablecapacity" + id, classes.capacity);
	      
	      $("pattern" + id).style.display = "";
	   
	      classCache[id] = classes;
	      
	}

  }

//编辑班级
function editClassClicked(classId){
    var classes = classCache[classId.substring(4)];
    dwr.util.setValue("className",classes.className);
    dwr.util.setValue("id",classes.id);
     
   }
//修改班级
function writeClass() {
	  var id,className,deptId;
	  id = dwr.util.getValue("id");
	  className = dwr.util.getValue("className");
	  deptId = dwr.util.getValue("selectDept");
      dwr.engine.beginBatch();
	  DwrService.updateClass(id,className);
      fillClass(deptId);
      dwr.engine.endBatch();
      
}
//删除班级
function deleteClassClicked(classId){

	var id = classId.substring(6)
	var deptId = dwr.util.getValue("selectDept");
	if (confirm("确认删除")) {
	dwr.engine.beginBatch();
	DwrService.deleteClass(id);
	fillClass(deptId);
	dwr.engine.endBatch();
	alert("删除成功");
	
	}
	
}
//清除班级编辑框
function clearClass() {
	  
	  dwr.util.setValues({ id:-1, className:null});
}

//显示老师内容
function displayTeacherTable(deptId){
	fillTeacherSelect(deptId.value);
    
}
function fillTeacherSelect(theDeptID){
	DwrService.findTeacherSet(theDeptID,callBackTeacherSet);
}

var callBackTeacherSet = function (teacherList){
	dwr.util.removeAllRows("teacherbody", { filter:function(tr) {
	      return (tr.id != "pattern");}});
	
	var teacher,id;
	for(var i = 0;i<teacherList.length;i++){
		
		  teacher = teacherList[i];
		  
		  id = teacher.id;
		  dwr.util.cloneNode("pattern", { idSuffix:id });
		  
	      dwr.util.setValue("Tableusername" + id, teacher.username);
	      
	      dwr.util.setValue("Tablepassword" + id, teacher.password);
	      
	      dwr.util.setValue("TableteacherNo" + id, teacher.teacherNo);
	      
	      dwr.util.setValue("Tablename" + id, teacher.name);
	      
	      dwr.util.setValue("Tablesex" + id, teacher.sex);
	      
	      dwr.util.setValue("Tabletitle" + id, teacher.title);
	      
	      dwr.util.setValue("Tableinfo" + id, teacher.info);
	      
	      
	      $("pattern" + id).style.display = "";
	   
	      teacherCache[id] = teacher;
	      
	}

}
//编辑教师
function editTeacherClicked(classId){
    var teacher = teacherCache[classId.substring(4)];

    dwr.util.setValue("username", teacher.username);
    
    dwr.util.setValue("password", teacher.password);
    
    dwr.util.setValue("teacherNo", teacher.teacherNo);
    
    dwr.util.setValue("name", teacher.name);
    
    dwr.util.setValue("sex", teacher.sex);
    
    dwr.util.setValue("title", teacher.title);
    
    dwr.util.setValue("info", teacher.info);
    
    dwr.util.setValue("id", teacher.id);

     
   }
//修改教师
function writeTeacher() {
	  var id,username,password,teacherNo,sex,info,title,name,deptId;
	  id = dwr.util.getValue("id");
	  username = dwr.util.getValue("username");
	  password = dwr.util.getValue("password");
	  teacherNo = dwr.util.getValue("teacherNo");
	  sex = dwr.util.getValue("sex");
	  info = dwr.util.getValue("info");
	  title = dwr.util.getValue("title");
	  name = dwr.util.getValue("name");
	  deptId = dwr.util.getValue("selectDept");
      dwr.engine.beginBatch();
	  DwrService.updateTeacher(id,username,password,teacherNo,sex,title,info,name);
	  fillTeacherSelect(deptId);
      dwr.engine.endBatch();
      
}
//删除教师
function deleteTeacherClicked(classId){

	var id = classId.substring(6)
	var deptId = dwr.util.getValue("selectDept");
	if (confirm("确认删除")) {
	dwr.engine.beginBatch();
	DwrService.deleteTeacher(id);
	fillTeacher(deptId);
	dwr.engine.endBatch();
	alert("删除成功");
	
	}
	
}
//清除教师编辑框
function clearTeacher() {
	  
	  dwr.util.setValues({ id:-1, username:null,password:null,name:null, info:null, sex:null, title:null, teacherNo:null});
}
//显示班级下拉
function displayClassList(dept){
	fillClassList(dept.value);
	
}
function fillClassList(theDeptId){
	DwrService.findClass(theDeptId,callBackClassList);
}

var callBackClassList = function (classList){
	dwr.util.removeAllOptions("selectClass");
	dwr.util.addOptions("selectClass",classList);
};



//显示学生内容
function displayStudentTable(classId){
	fillStudent(classId.value);
}
function fillStudent(theClassId){
	DwrService.findStudent(theClassId,callBackStudentTable);
}
var callBackStudentTable=function(studentList){
	
	dwr.util.removeAllRows("studentbody", { filter:function(tr) {
	      return (tr.id != "pattern");}});
	
	var student,id;
	for(var i = 0;i<studentList.length;i++){
		
		  student = studentList[i];
		  id = student.id;
          dwr.util.cloneNode("pattern", { idSuffix:id });
		  
	      dwr.util.setValue("Tableusername" + id, student.username);
	      
	      dwr.util.setValue("Tablepassword" + id, student.password);
	      
	      dwr.util.setValue("TablestudentNo" + id, student.studentNo);
	      
	      dwr.util.setValue("Tablename" + id, student.name);
	      
	      dwr.util.setValue("Tablesex" + id, student.sex);
	      
	      dwr.util.setValue("Tablemajor" + id, student.major);
	      
	      dwr.util.setValue("Tableinfo" + id, student.info);
	     
	      $("pattern" + id).style.display = "";
	   
	      studentCache[id] = student;
	      
	}

}
//编辑学生
function editStudentClicked(studentId){
    var student = studentCache[studentId.substring(4)];
    dwr.util.setValue("username", student.username);
    dwr.util.setValue("password", student.password);   
    dwr.util.setValue("studentNo", student.studentNo);   
    dwr.util.setValue("name", student.name);    
    dwr.util.setValue("sex", student.sex);   
    dwr.util.setValue("major", student.major);   
    dwr.util.setValue("info", student.info);
    dwr.util.setValue("id", student.id);
   }
//修改学生
function writeStudent() {
	  var id,username,password,studentNo,sex,info,major,name,classId;
	  id = dwr.util.getValue("id");
	  username = dwr.util.getValue("username");
	  password = dwr.util.getValue("password");
	  studentNo = dwr.util.getValue("studentNo");
	  sex = dwr.util.getValue("sex");
	  info = dwr.util.getValue("info");
	  major = dwr.util.getValue("major");
	  name = dwr.util.getValue("name");
	  classId = dwr.util.getValue("selectClass");
      dwr.engine.beginBatch();
	  DwrService.updateStudent(id,username,password,studentNo,sex,major,info,name);
      fillStudent(classId);
      dwr.engine.endBatch();
      
}
//清除学生编辑框
function clearStudent() {
	  
	  dwr.util.setValues({ id:-1, username:null,password:null,name:null, info:null, sex:null, major:null, studentNo:null});
}
//删除学生
function deleteStudentClicked(studentId){

	var id = studentId.substring(6)
	var classId = dwr.util.getValue("selectClass");
	if (confirm("确认删除")) {
	dwr.engine.beginBatch();
	DwrService.deleteStudent(id);
	fillStudent(classId);
	dwr.engine.endBatch();
	alert("删除成功");
	
	}
	
}



