package com.yg.test;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yg.dto.MemberDto;
import com.yg.service.MemberService;
import com.yg.util.MyJob;

@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/")
	public String homeLogin(Locale locale, Model model) {
		
		return "homeLogin";
	}
	
	@RequestMapping(value = "/main")
	public String main(Locale locale, Model model) {
		
		return "main";
	}
	

	@RequestMapping(value = "/loginAction")
	public String loginAction(Model model,String id, String pw, HttpServletRequest request) {
		boolean result = memberService.loginCheck(id, pw);
		
		String ret ="";
		if(result) {
			if("aaa".equals(id)) {
				ret ="";
			} else {
				model.addAttribute("id",id);
				model.addAttribute("pw",pw);
				ret="/main";
			}
		}else{
			request.setAttribute("msg", "아이디/비번 확인 요망");
			ret = "homeLogin";
		}
		return ret;
	}
	
	
	@RequestMapping(value = "/register")
	public String register() {
		return "registerForm";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		request.setAttribute("msg", "로그아웃 되었습니다.");
		return "homeLogin";
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/registerAction")
	public String registerAction(MemberDto dto, HttpServletRequest request) {
		memberService.registerMember(dto);
		request.setAttribute("msg", "가입되었습니다. 로그인해주세요.");
		return "homeLogin";
	}
	
	@RequestMapping(value = "/start")  // 스케줄러 시작할게요 (= 10초마다 MyJob 실행할게요).
	public String homeStart() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		  // define the job and tie it to our HelloJob class
		  JobDetail job = JobBuilder.newJob(MyJob.class)
		      .withIdentity("job1", "group1")
		      .build();

		  // Trigger the job to run now, and then repeat every 40 seconds
		  Trigger trigger = TriggerBuilder.newTrigger()
		      .withIdentity("trigger1", "group1")
		      .startNow()
		      .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
		      .build();

		  // Tell quartz to schedule the job using our trigger
		  scheduler.scheduleJob(job, trigger);
		  scheduler.start();
		  System.out.println("스케줄러가 시작됨.");
		return "main";
	}
	
	@RequestMapping(value = "/end")    // 스케줄러 끝낼게요 (= MyJob 그만 할게요).
	public String homeEnd() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.shutdown();
		System.out.println("스케줄러가 종료됨.");
		return "main";
	}
	
	
	
	
	
}
