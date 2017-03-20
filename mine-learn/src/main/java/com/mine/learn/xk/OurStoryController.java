package com.mine.learn.xk;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("our_story")
public class OurStoryController {
	@Autowired
	OurStoryService storyService;

	@RequestMapping("/firstChat")
	@ResponseBody
	public Map<String, Object> firstChat(){
		Map<String, Object> resultMap = Maps.newHashMap();

		storyService.firstChat();

		resultMap.put("flag", "success");
		resultMap.put("data", "");
		return resultMap;
	}
	
}