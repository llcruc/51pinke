package com.service;

import com.spring.entity.RucCourseCheck;
/**
 * �û��޸Ŀγ���Ϣ����
 * @author Flyaway
 *
 */
public interface RucCourseCheckService {
	
	/**
	 * �����޸ĵ���Ϣ
	 * @param rucCourseCheck
	 */
    void save(RucCourseCheck rucCourseCheck);
	
    /**
     * ɾ���޸ĵ���Ϣ
     * @param rucCourseCheck
     */
	void delete(RucCourseCheck rucCourseCheck);

}
