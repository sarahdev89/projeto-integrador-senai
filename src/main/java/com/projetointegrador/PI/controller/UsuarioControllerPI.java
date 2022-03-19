package com.projetointegrador.PI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projetointegrador.PI.models.UsuarioPI;
import com.projetointegrador.PI.repository.UsuarioRepositoryPI;

@Controller

public class UsuarioControllerPI {

	@Autowired
	private UsuarioRepositoryPI ur;

	// GET que chama o form para cadastrar usuários
	@RequestMapping("/cadastrarUsuario")
	public String form() {
		return "form-usuario";
	}

	// POST que cadastra usuários
	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	public String form(UsuarioPI usuario) {

		ur.save(usuario);

		return "redirect:/cadastrarUsuario";
	}

	// GET que lista usuários
	@RequestMapping("/usuarios")
	public ModelAndView listaUsuarios() {
		ModelAndView mv = new ModelAndView("lista-usuario");
		Iterable<UsuarioPI> usuarios = ur.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	}

	// Métodos que atualizam usuário
	// GET que chama o FORM de edição do usuário
	@RequestMapping("/editar-usuario")
	public ModelAndView editarUsuario(long id) {
		UsuarioPI usuario = ur.findById(id).get();
		ModelAndView mv = new ModelAndView("/update-usuario");
		mv.addObject("usuario", usuario);
		return mv;
	}

	// POST que atualiza o usuario
	@RequestMapping(value = "/editar-usuario", method = RequestMethod.POST)
	public String updateUsuario(UsuarioPI usuario) {

		ur.save(usuario);

		return "redirect:/usuarios";

	}
	
	//GET que deleta usuário
		@RequestMapping("/deletarUsuario")
		public String deletarUsuario(long id) {
			ur.deleteById(id);
			return "redirect:/usuarios";
		}

}
