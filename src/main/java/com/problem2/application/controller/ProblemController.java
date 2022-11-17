package com.problem2.application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController(value = "/")
public class ProblemController {

	@GetMapping
	public List<String> handleFile(@RequestParam("file") MultipartFile file) {
		List<String> listMap = new ArrayList<String>();
		try {
			String stringFile = new String(file.getBytes());
			String[] stringArray = stringFile.split(" ");
			Map<String,Integer> stringMap = new HashMap<>();
			for(String i : stringArray) {
				Integer duplicate = stringMap.get(i);
				if(stringMap.get(i)==null) {
					stringMap.put(i, 1);
				} else {
					duplicate = duplicate+1;
					stringMap.put(i,duplicate);
				}
			}
			Set<Map.Entry<String, Integer>> duplicateMaps = stringMap.entrySet();
	        for(Map.Entry<String,Integer> entry : duplicateMaps){
	        	listMap.add(entry.getKey()+":"+entry.getValue());
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMap;
	}
}
