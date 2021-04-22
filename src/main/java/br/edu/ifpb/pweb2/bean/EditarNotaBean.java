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

@Named(value = "editarNotaBean")
@ViewScoped
public class EditarNotaBean extends GenericAcademicoBean implements Serializable {

    @Inject
    private Aluno aluno;

    @Inject
    private AlunoController controllerAluno;

    @PostConstruct
    public void init() {
        Aluno alunoFlash = (Aluno) this.getFlash("editarAluno");
        if (alunoFlash != null) {
            this.aluno = alunoFlash;
        }
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public String salvar()
    {
        this.controllerAluno.saveOrUpdate(this.aluno);

        return "/notas/alunos?faces-redirect=true";
    }
}
