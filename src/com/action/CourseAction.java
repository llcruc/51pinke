package com.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.service.CourseTableService;
import com.service.RucCourseCheckService;
import com.service.RucCourseService;
import com.service.RucTeacherService;
import com.spring.entity.CourseName;
import com.spring.entity.CourseTable;
import com.spring.entity.RucCourse;
import com.spring.entity.RucCourseCheck;
import com.spring.entity.User;
import com.util.RucCourseGet;
import com.util.StringHandler;

/**
 * 课程操作Action
 * 
 * @author Flyaway
 * 
 */
@Component("course")
public class CourseAction {
	/**
	 * 
	 */
	private RucCourseService rucCourseService;
	private CourseTableService courseTableService;
	private RucCourseGet rucCourseGet;
	private RucTeacherService rucTeacherService;
	private RucCourseCheckService rucCourseCheckService;

	// 各种其他
	private String studentid;
	private String studentpassword;
	private ArrayList<CourseName> coursenamelist;
	private ArrayList<RucCourse> ruccourselist;
	private CourseTable mycourseTable;
	private CourseName mycoursename;
	private String courseid;
	private RucCourse rucCourse;
	
	private int cid;
	
	private String courseinfo;
	private String courseimg;
	private String coursetimeid;
	
	

	/**
	 * 显示用户课表
	 * @return
	 */
	public String execute(){
		int userid=26;
		
		List<CourseTable> list=new ArrayList<CourseTable>();
		list=courseTableService.getCourseByUser(userid);
		ArrayList<CourseName> courseNamelist1=new ArrayList<CourseName>();
		String flag="coursepage";
		try {
			for(int i=0;i<list.size();i++){
				CourseTable courseTable=new CourseTable();
				courseTable=list.get(i);
				CourseName courseName=new CourseName();
				courseName.setCoursenum(courseTable.getCoursenum());
				if(courseTable.getMon()!=null){
					courseName.setName1(rucCourseService.getCourseByTimeId(courseTable.getMon()).getCoursename());
					courseName.setMon(courseTable.getMon());
				}
				if(courseTable.getTues()!=null){
					courseName.setName2(rucCourseService.getCourseByTimeId(courseTable.getTues()).getCoursename());
					courseName.setTues(courseTable.getTues());
				}
				if(courseTable.getWed()!=null){
					courseName.setName3(rucCourseService.getCourseByTimeId(courseTable.getWed()).getCoursename());
					courseName.setWed(courseTable.getWed());
				}
				if(courseTable.getThur()!=null){
					courseName.setName4(rucCourseService.getCourseByTimeId(courseTable.getThur()).getCoursename());
					courseName.setThur(courseTable.getThur());
				}
				if(courseTable.getFri()!=null){
					courseName.setName5(rucCourseService.getCourseByTimeId(courseTable.getFri()).getCoursename());
					courseName.setFri(courseTable.getFri());
				}
				courseNamelist1.add(courseName);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag="error";
		}
		setCoursenamelist(courseNamelist1);
		return flag;
	}

	/**
	 * 获取用户课表
	 * @return
	 */
	public String coursetable() {
		int userid = 26;
		System.out.println(studentid + studentpassword);
		String flag = "success";
		try {
			List<String> list = rucCourseGet.getCourse(studentid,studentpassword, "2014-2015", "1");

			System.out.println(list.toString());
			if (courseTableService.getCourseByUser(userid).size() == 0) {
				for (int i = 0; i < 7; i++) {
					CourseTable courseTable=new CourseTable();
					courseTable.setCoursenum(i + 1);
					courseTable.setUserid(userid);
					courseTable.setMon(list.get(i * 7));
					courseTable.setTues(list.get(i * 7 + 1));
					courseTable.setWed(list.get(i * 7 + 2));
					courseTable.setThur(list.get(i * 7 + 3));
					courseTable.setFri(list.get(i * 7 + 4));
					courseTable.setSat(list.get(i * 7 + 5));
					courseTable.setSun(list.get(i * 7 + 6));
					try {
						courseTableService.saveCourse(courseTable);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						flag = "error";
					}
				}
				
			}else {
				for (int i = 0; i < 7; i++) {
					CourseTable courseTable = courseTableService.getCourseByUser(userid).get(i);
					courseTable.setCoursenum(i + 1);
					courseTable.setUserid(userid);
					courseTable.setMon(list.get(i * 7));
					courseTable.setTues(list.get(i * 7 + 1));
					courseTable.setWed(list.get(i * 7 + 2));
					courseTable.setThur(list.get(i * 7 + 3));
					courseTable.setFri(list.get(i * 7 + 4));
					courseTable.setSat(list.get(i * 7 + 5));
					courseTable.setSun(list.get(i * 7 + 6));
					
					try {
						courseTableService.updateCourse(courseTable);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						flag = "error";
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = "error";
		}
		return flag;
	}
	
	/**
	 * 课程详细信息
	 * @return
	 */
	public String info(){
		RucCourse rucCourse1=new RucCourse();
		try {
			rucCourse1=rucCourseService.getCourseByTimeId(courseid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		setRucCourse(rucCourse1);
		return "courseinfo";
	}
	
	public String info2(){
		RucCourse rucCourse=new RucCourse();
		try {
			rucCourse=rucCourseService.getCourseByTimeId(courseid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		this.setRucCourse(rucCourse);
		this.setCid(cid);
		return "courseinfo2";
	}
	
	public String editeinfo(){
		RucCourse rucCourse=new RucCourse();
		try {
			rucCourse=rucCourseService.getCourseByTimeId(courseid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		this.setRucCourse(rucCourse);
		this.setCid(cid);
		return "courseinfoedite";
	}
	
	public String check(){
		ActionContext context=ActionContext.getContext();
		int userid=((User)context.getSession().get("user")).getUserid();
		RucCourseCheck rucCourseCheck=new RucCourseCheck();
		rucCourseCheck.setUserid(userid);
		rucCourseCheck.setCourseinfo(courseinfo);
		rucCourseCheck.setCoursetimeid(coursetimeid);
		rucCourseCheck.setDatetime(StringHandler.timeTostr(new Date()));
		rucCourseCheck.setCourseimg(courseimg);
		try {
			rucCourseCheckService.save(rucCourseCheck);
			return "check";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
	
	// 依赖注入
		public void setRucCourseService(RucCourseService rucCourseService) {
			this.rucCourseService = rucCourseService;
		}

		public void setCourseTableService(CourseTableService courseTableService) {
			this.courseTableService = courseTableService;
		}

		public void setRucCourseGet(RucCourseGet rucCourseGet) {
			this.rucCourseGet = rucCourseGet;
		}

		public String getStudentid() {
			return studentid;
		}

		public void setStudentid(String studentid) {
			this.studentid = studentid;
		}

		public String getStudentpassword() {
			return studentpassword;
		}

		public void setStudentpassword(String studentpassword) {
			this.studentpassword = studentpassword;
		}
		public CourseTable getMycourseTable() {
			return mycourseTable;
		}

		public void setMycourseTable(CourseTable mycourseTable) {
			this.mycourseTable = mycourseTable;
		}
		public ArrayList<RucCourse> getRuccourselist() {
			return ruccourselist;
		}

		public void setRuccourselist(ArrayList<RucCourse> ruccourselist) {
			this.ruccourselist = ruccourselist;
		}
		public ArrayList<CourseName> getCoursenamelist() {
			return coursenamelist;
		}
		public void setCoursenamelist(ArrayList<CourseName> coursenamelist) {
			this.coursenamelist = coursenamelist;
		}
		public CourseName getMycoursename() {
			return mycoursename;
		}

		public void setMycoursename(CourseName mycoursename) {
			this.mycoursename = mycoursename;
		}
		public String getCourseid() {
			return courseid;
		}

		public void setCourseid(String courseid) {
			this.courseid = courseid;
		}
		public RucCourse getRucCourse() {
			return rucCourse;
		}

		public void setRucCourse(RucCourse rucCourse) {
			this.rucCourse = rucCourse;
		}

		public int getCid() {
			return cid;
		}

		public void setCid(int cid) {
			this.cid = cid;
		}

		public RucCourseService getRucCourseService() {
			return rucCourseService;
		}

		public CourseTableService getCourseTableService() {
			return courseTableService;
		}

		public RucCourseGet getRucCourseGet() {
			return rucCourseGet;
		}

		public RucTeacherService getRucTeacherService() {
			return rucTeacherService;
		}

		public void setRucTeacherService(RucTeacherService rucTeacherService) {
			this.rucTeacherService = rucTeacherService;
		}

		public RucCourseCheckService getRucCourseCheckService() {
			return rucCourseCheckService;
		}

		public void setRucCourseCheckService(RucCourseCheckService rucCourseCheckService) {
			this.rucCourseCheckService = rucCourseCheckService;
		}

		public String getCourseinfo() {
			return courseinfo;
		}

		public void setCourseinfo(String courseinfo) {
			this.courseinfo = courseinfo;
		}

		public String getCourseimg() {
			return courseimg;
		}

		public void setCourseimg(String courseimg) {
			this.courseimg = courseimg;
		}

		public String getCoursetimeid() {
			return coursetimeid;
		}

		public void setCoursetimeid(String coursetimeid) {
			this.coursetimeid = coursetimeid;
		}

		

}
