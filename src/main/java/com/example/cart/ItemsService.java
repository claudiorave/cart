package com.example.cart;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ItemsService {
	public static ObjectMapper mapper = new ObjectMapper();
	static ArrayList<Product> products;
	public static URL jsonUrl;

	public ItemsService() {
		try {
			jsonUrl = new URL("http://challenge.getsandbox.com/articles");
		} catch (MalformedURLException e1) {
			// logs must be included in every catch
		}

		try {
			products = mapper.readValue(jsonUrl, new TypeReference<List<Product>>() {
			});

		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
	}

	public Product getItem(Long Id) {
		Product prod = products.stream().filter(productFromList -> Id.equals(productFromList.getId())).findAny()
				.orElse(null);
		return prod;

	}

	public ArrayList<Product> getAllItems() {
		return products;

	}

}