package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.cdi.Transactional;
import br.edu.ifpb.pweb2.dao.UsuarioAdminDAO;
import br.edu.ifpb.pweb2.model.UsuarioAdmin;
import br.edu.ifpb.pweb2.util.PasswordUtil;

public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioAdminDAO usuarioDAO;

	@Transactional
	public UsuarioAdmin insert(UsuarioAdmin admin) {
		String encrip = (passwordUtil.encryptMD5(admin.getSenha()));
		admin.setSenha(encrip);
		return usuarioDAO.insert(admin);
	}

	private PasswordUtil passwordUtil;

	public List<UsuarioAdmin> findAll()
	{
		return this.usuarioDAO.findAll();
	}

	public UsuarioAdmin isValido(String usuario, String senha) {

		String encrip = (passwordUtil.encryptMD5(senha));
		UsuarioAdmin user = usuarioDAO.findByLogin(usuario);
				
		if (user == null || !encrip.equals(user.getSenha())) {
			user = null;
		}

		return user;
	}
}
