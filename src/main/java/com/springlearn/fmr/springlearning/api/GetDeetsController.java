package com.springlearn.fmr.springlearning.api;


import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetDeetsController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/hello")
	public String Welcome()
	{
		return "Welcome Boss";
	}

	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id)
	{
		return topicService.getTopic(id);
	}
	@RequestMapping(method = RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
	public void UpdateTopic(@RequestBody Topic topic, @PathVariable("id") String id)
	{
		topicService.updateTopic(id, topic);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
	public void DeleteTopic(@PathVariable("id") String id)
	{
		topicService.deleteTopic(id);
		
	}
}
