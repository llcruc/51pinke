package com.spring.aop;

import javax.naming.NoPermissionException;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.opensymphony.xwork2.ActionContext;
import com.spring.entity.User;

@Aspect
public class LoginCheck {
	
	@Before("execution(* com.action.DispatchAction.uploadpage(..)) or execution(* com.action.DispatchAction.user*(..))"
			+ " or execution(* com.action.DispatchAction.user*(..)) or execution(* com.action.DispatchAction.edite*(..))")
	public void check() throws Throwable{
		System.out.println("登录检查");
		ActionContext context=ActionContext.getContext();
		User user=(User)context.getSession().get("user");
		if(user==null){
			System.out.println("用户未登录");
			throw new NoPermissionException();
		}else {
			System.out.println("用户已经登录");
		}
	}
	
	@Before("execution(* com.action.DispatchAction.collect(..)) or execution(* com.action.DispatchAction.mydownload(..))"
			+ " or execution(* com.action.DispatchAction.ruccourse(..))")
	public void check2() throws Throwable{
		System.out.println("登录检查");
		ActionContext context=ActionContext.getContext();
		User user=(User)context.getSession().get("user");
		if(user==null){
			System.out.println("用户未登录");
			throw new NoPermissionException();
		}else {
			System.out.println("用户已经登录");
		}
	}
	
	@Before("execution(* com.action.UserAction.update*(..)) or execution(* com.action.UserAction.userinfoedite(..))")
	public void check3()throws Throwable{
		System.out.println("登录检查");
		ActionContext context=ActionContext.getContext();
		User user=(User)context.getSession().get("user");
		if(user==null){
			System.out.println("用户未登录");
			throw new NoPermissionException();
		}else {
			System.out.println("用户已经登录");
		}
	}
	
	@Before("execution(* com.action.CourseAction.editeinfo(..))")
	public void check4()throws Throwable{
		System.out.println("登录检查");
		ActionContext context=ActionContext.getContext();
		User user=(User)context.getSession().get("user");
		if(user==null){
			System.out.println("用户未登录");
			throw new NoPermissionException();
		}else {
			System.out.println("用户已经登录");
		}
	}

}
