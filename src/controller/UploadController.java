package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.UploadedImageFile;

@Controller
public class UploadController {
	
	@RequestMapping("/uploadImage")
	public ModelAndView upload(HttpServletRequest request, UploadedImageFile file) throws IllegalStateException, IOException{
		System.out.println("hellpo ");
		String name=RandomStringUtils.randomAlphanumeric(10);//给上传的图片重命名
		String newFileName=name+".jpg";
		File newfile=new File(request.getServletContext().getRealPath("/image"),newFileName);
		System.out.println(request.getServletContext().getRealPath("/image"));
		newfile.getParentFile().mkdirs();
		file.getImage().transferTo(newfile);//复制文件
		
		ModelAndView mav = new ModelAndView("show");
        mav.addObject("imageName", newFileName);
		
		return mav;
		
	}

}
