package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

//此方法为配置文件所写
/*public class IndexController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("message", "Hello My SpringMvc");
		return mv;
	}
}*/

//此方法为注解所写
@Controller
public class IndexController{
	@RequestMapping("/index")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav=new ModelAndView("/index");
		mav.addObject("message", "hello spring mvc come on yanxiaojie");
		return mav;
	}
	
	
	//redirect:/index客户端跳转
	@RequestMapping("/jump")
	public ModelAndView jump(){
		ModelAndView mav=new ModelAndView("redirect:/index");
		return mav;	
	}
	
	@RequestMapping("/check")
	public ModelAndView check(HttpSession session){
		Integer i=(Integer) session.getAttribute("count");
		if(i==null)
			i=0;
		i++;
		session.setAttribute("count", i);
		
		ModelAndView mav=new ModelAndView("/check");
		return mav;
		
		
	}
	
	@RequestMapping("/clear")
	public ModelAndView clear(HttpSession session){
		session.setAttribute("count", -1);
		ModelAndView mav = new ModelAndView("redirect:/check");
		return mav;
	}
	
	
}

