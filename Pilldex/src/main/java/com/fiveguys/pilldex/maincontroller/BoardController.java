package com.fiveguys.pilldex.maincontroller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fiveguys.pilldex.domain.PillVO2;
import com.fiveguys.pilldex.domain.main1page;
import com.fiveguys.pilldex.main1.service.MainBoardService;

@Controller
@RequestMapping(value = "/mainboard/")	
public class BoardController  {

	@Inject
	MainBoardService service;
	
	@RequestMapping(value = "/listPageSearchBox.do", method = RequestMethod.GET)
	public void getListPageSearchBox 
			(Model model, 
			@RequestParam(value = "num") int num,
			@RequestParam(value = "keyword",required = false, defaultValue = "") String keyword,
			@RequestParam(value = "keyword_print",required = false, defaultValue = "") String keyword_print,
			@RequestParam(value = "keyword_shape",required = false, defaultValue = "") String keyword_shape,
			@RequestParam(value = "keyword_color",required = false, defaultValue = "") String keyword_color,
			@RequestParam(value = "keyword_chart",required = false, defaultValue = "") String keyword_chart,
			@RequestParam(value = "keyword_line",required = false, defaultValue = "") String keyword_line
			) 
					throws Exception {
		
	main1page page = new main1page();
	
	page.setNum(num);
	
	page.setCount(service.searchCountBox(
			keyword,
			keyword_print,
			keyword_shape,
			keyword_color,
			keyword_chart,
			keyword_line)); 
	
	page.setKeyword(keyword);
	page.setKeyword_print(keyword_print);
	page.setKeyword_shape(keyword_shape);
	page.setKeyword_color(keyword_color);
	page.setKeyword_chart(keyword_chart);
	page.setKeyword_line (keyword_line );

	
	List<PillVO2> list = null;
	list = service.listPageSearchBox(
	page.getDisplayPost(), 
	page.getPostNum(), 
	keyword,
	keyword_print,
	keyword_shape,
	keyword_color,
	keyword_chart,
	keyword_line);
	
	model.addAttribute("list", list);   
	model.addAttribute("page", page);
	model.addAttribute("select", num);


	}
	
}


	
	