package br.edu.ifpb.pweb2.dao;

import java.io.Serializable;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pweb2.model.UsuarioAdmin;

public class UsuarioAdminDAO extends GenericDAO<UsuarioAdmin, Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	public UsuarioAdmin findByLogin(String login) {
		Query q = entityManager.createQuery("select u from UsuarioAdmin u where u.nome = :login");
		q.setParameter("login", login);
		UsuarioAdmin u = null;
		try {
			u = (UsuarioAdmin) q.getSingleResult();
		}catch (NoResultException e) {		
		}
		return u; 
	}
	
}
