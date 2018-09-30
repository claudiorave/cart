package com.example.cart;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Configuration
@Slf4j
class LoadDatabase {
	
	public static ObjectMapper mapper = new ObjectMapper();
	static ArrayList<Product> data;
	public static URL jsonUrl;
		
	@Bean
	CommandLineRunner initDatabase(ProductRepository repository) {
		return args -> {
				//PRODUCTS ARE RETRIEVED FROM THE URL AND STORED INTO LIST<PRODUCT>
			
				try {
					jsonUrl = new URL("http://challenge.getsandbox.com/articles");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					data = mapper.readValue(jsonUrl,  new TypeReference<List<Product>>(){});
				
	
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//RETRIEVED PRODUCTS ARE SAVED INTO THE REPOSITORY
				for (int i = 0; i < data.size(); i++) {
					log.info("Preloading " + repository.save(data.get(i)));
					
				}
			
		
		};
	}
}