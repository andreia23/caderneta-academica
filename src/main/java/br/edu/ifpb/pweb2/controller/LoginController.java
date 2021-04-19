package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.UsuarioAdminDAO;
import br.edu.ifpb.pweb2.model.UsuarioAdmin;


public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioAdminDAO usuarioDAO;
	
	public UsuarioAdmin isValido(String usuario, String senha) {

		UsuarioAdmin user = usuarioDAO.findByLogin(usuario);
		if (user == null || !senha.equals(user.getSenha())) {
			user = null;
		}

		return user;
	}
}
