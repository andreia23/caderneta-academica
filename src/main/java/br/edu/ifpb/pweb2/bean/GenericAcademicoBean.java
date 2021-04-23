package br.edu.ifpb.pweb2.bean;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

public class GenericAcademicoBean {
	
	@Inject
	private LoginBean loginBean;
	
	protected void addMessage(String mensagem, Severity severidade, String id) {
		FacesMessage fm = new FacesMessage(mensagem);
		fm.setSeverity(severidade);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(id, fm);
	}

	protected void addInfoMessage(String mensagem, String id) {
		this.addMessage(mensagem, FacesMessage.SEVERITY_INFO, id);
	}

	protected void addErrorMessage(String mensagem, String id) {
		this.addMessage(mensagem, FacesMessage.SEVERITY_ERROR, id);
	}

	protected void putFlash(String nome, Object valor) {
		Flash f = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		f.put(nome, valor);
	}

	protected Object getFlash(String nome) {
		Flash f = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		return f.get(nome);
	}

	protected Flash getFlash() {
		return FacesContext.getCurrentInstance().getExternalContext().getFlash();
	}

	protected void keepMessages() {
		this.getFlash().setKeepMessages(true);
	}
	
	public void setValueOf(String elExpression, Class<?> clazz, Object value) {
		FacesContext current = FacesContext.getCurrentInstance();
		ELContext elContext = current.getELContext();
		Application app = current.getApplication();
		ExpressionFactory fac = app.getExpressionFactory();
		ValueExpression ve = fac.createValueExpression(elContext, elExpression, clazz);
		ve.setValue(current.getELContext(), value);		
	}
	
	public void invalidateSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
        ((HttpSession)facesContext.getExternalContext().getSession(false)).invalidate();
	}

	/**
	 * @return the loginBean
	 */
	public LoginBean getLoginBean() {
		return loginBean;
	}

	/**
	 * @param loginBean the loginBean to set
	 */
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	

}
