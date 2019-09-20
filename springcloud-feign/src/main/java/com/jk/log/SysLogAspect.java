package com.jk.log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import com.jk.model.Highcharts;
import com.jk.service.HbService;
import com.jk.service.XxfService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



@Aspect
@Component
public class SysLogAspect {
	@Autowired
	private HbService hbService;

	@Pointcut("execution(* com.jk.controller.ZcController.grDenLu (..))")
	public void logPointCut() {}
	 //后置通知
    @AfterReturning( value= "logPointCut()" ,returning="returningValue" ) 
    public void myAfter(JoinPoint jp,Object returningValue){//returningValue是返回值，但需要告诉spring
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			String time = sdf.format(date);
			Highcharts highcharts2=hbService.queryHighcharts(time);
			if(highcharts2==null){
				Highcharts highcharts = new Highcharts();
				highcharts.setDaytime(sdf.format(new Date()));
				highcharts.setVisitcount(1);
				hbService.addHighcharts(highcharts);
			}else {
				hbService.updateHighcharts(highcharts2.getId());
			}
    }







}
