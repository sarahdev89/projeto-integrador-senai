package com.projetointegrador.PI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControllerPI {
	
	@RequestMapping("/")
	public String index() {
		return "indexProjeto";
	}

}
