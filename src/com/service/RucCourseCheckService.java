package com.service;

import com.spring.entity.RucCourseCheck;
/**
 * 用户修改课程信息服务
 * @author Flyaway
 *
 */
public interface RucCourseCheckService {
	
	/**
	 * 保存修改的信息
	 * @param rucCourseCheck
	 */
    void save(RucCourseCheck rucCourseCheck);
	
    /**
     * 删除修改的信息
     * @param rucCourseCheck
     */
	void delete(RucCourseCheck rucCourseCheck);

}
