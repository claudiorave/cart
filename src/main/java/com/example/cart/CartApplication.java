package com.example.cart;

import org.springframework.boot.SpringApplication;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;
@Slf4j
@SpringBootApplication
public class CartApplication {
	

	
	public static void main(String[] args) throws MalformedURLException {
		SpringApplication.run(CartApplication.class, args);
	

	}
}
