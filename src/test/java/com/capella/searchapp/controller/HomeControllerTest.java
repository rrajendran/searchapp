package com.capella.searchapp.controller;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class HomeControllerTest {

	@Test
	public void test_search() {
		HomeController controller = new HomeController();
		Model model = new ExtendedModelMap();
		System.out.println(controller.search("ramesh"));
		
	}
}
