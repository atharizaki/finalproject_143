/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.finalproject;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author athar  
 * NIM = 20200140143
 */
@RestController
@CrossOrigin
@ResponseBody
public class MyController {
	
	finalprojectJpaController control = new finalprojectJpaController();
	
	@PostMapping("/POST")
	public String sendData(HttpEntity<String> kiriman) throws Exception{
		finalproject datas = new finalproject();
		String d = kiriman.getBody();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		datas = mapper.readValue(d, finalproject.class);
	        control.create(datas);
		return d;
	}
	
	@PutMapping("/PUT")
	public String editData(HttpEntity<String> kiriman) throws Exception{
		finalproject datas = new finalproject();
		String d = kiriman.getBody();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		datas = mapper.readValue(d, finalproject.class);
	        control.edit(datas);
		return d;
	}
	
	@DeleteMapping("/DELETE")
	public String deleteData(HttpEntity<String> kiriman) throws Exception{
		finalproject datas = new finalproject();
		String d = kiriman.getBody();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		datas = mapper.readValue(d, finalproject.class);
	        control.destroy(datas.getId());
		return "id: "+datas.getId()+" deleted";
	}
	
	@GetMapping("/GET")
	public List<finalproject> getTabel(){
		List<finalproject> list = new ArrayList<>();
		try {
			list = control.findfinalprojectEntities();
		}
		catch (Exception e){}
		return list;
	}
	
}
