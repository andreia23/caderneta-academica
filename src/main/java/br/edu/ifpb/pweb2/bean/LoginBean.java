package br.edu.ifpb.pweb2.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.controller.LoginController;
import br.edu.ifpb.pweb2.model.UsuarioAdmin;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean extends GenericAcademicoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String usuario;

	private String senha;

	@Inject
	private UsuarioAdmin usuarioLogado;

	@Inject
	private LoginController loginController;

	public String autenticar() {
		String proxView = null;
		
		if (loginController.isValido(usuarioLogado.getNome(), usuarioLogado.getSenha()) == null) {
			loginController.insert(usuarioLogado);
			proxView = "/main?faces-redirect=true";

		}

		else if ((usuarioLogado = loginController.isValido(usuarioLogado.getNome(), usuarioLogado.getSenha())) != null) {
			this.setValueOf("#{sessionScope.loginUser}", String.class, usuarioLogado.getNome());
			proxView = "/main?faces-redirect=true";
		}

		else {
			this.addErrorMessage("Login inv�lido.");
		}

		return proxView;
	}

	public String logout() {
		this.invalidateSession();
		return "/login/login?faces-redirect=true";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioAdmin getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioAdmin usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
