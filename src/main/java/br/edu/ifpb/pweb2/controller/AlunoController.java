package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.cdi.Transactional;
import br.edu.ifpb.pweb2.dao.AlunoDAO;
import br.edu.ifpb.pweb2.model.Aluno;

public class AlunoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private AlunoDAO alunoDAO;
	
	@Transactional
	public void excluir(Aluno aluno) {
		alunoDAO.delete(aluno);
	}
	
	@Transactional
	public Aluno update(Aluno aluno) {
		return alunoDAO.update(aluno);
	}
	
	public void refresh(Aluno aluno) {
		alunoDAO.refresh(aluno);
	}
	
	public List<Aluno> findAll() {
		return alunoDAO.findAll();
	}
	
	public Aluno find(Integer id) {
		return alunoDAO.find(id);
	}
	
	@Transactional
	public Aluno insert(Aluno aluno) {
		return alunoDAO.insert(aluno);
	}

	@Transactional
	public void saveOrUpdate(Aluno aluno) {
		if (aluno.getId() != null) {
			alunoDAO.update(aluno);
		} else {
			alunoDAO.insert(aluno);
		}
		
	}

}

