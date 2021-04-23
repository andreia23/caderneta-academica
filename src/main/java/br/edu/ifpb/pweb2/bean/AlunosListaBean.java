package br.edu.ifpb.pweb2.bean;

import br.edu.ifpb.pweb2.controller.AlunoController;
import br.edu.ifpb.pweb2.model.Aluno;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Named(value = "alunosListaBean")
@ViewScoped
public class AlunosListaBean extends GenericAcademicoBean implements Serializable {

    private List<Aluno> alunos;

    @Inject
    private AlunoController controllerAluno;

    @PostConstruct
    public void init() {
        this.alunos = this.controllerAluno.findAll();
    }

    public String excluirAluno(Aluno aluno) {
      controllerAluno.excluir(aluno);
      this.alunos = controllerAluno.findAll();
      return null;
    }

    public String editarrAluno(Aluno aluno) {
      this.putFlash("aluno", aluno);
      return "form-estudante?faces-redirect=true";
    }
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String formatarData(Date dt)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dt);
    }

    public String editar(Aluno a)
    {
        this.putFlash("editarAluno", a);
        return "/notas/editar?faces-redirect=true";
    }
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
      }
}
