package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

//�˷���Ϊ�����ļ���д
/*public class IndexController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("message", "Hello My SpringMvc");
		return mv;
	}
}*/

//�˷���Ϊע����д
@Controller
public class IndexController{
	@RequestMapping("/index")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav=new ModelAndView("/index");
		mav.addObject("message", "hello spring mvc come on yanxiaojie");
		return mav;
	}
	
	
	//redirect:/index�ͻ�����ת
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

