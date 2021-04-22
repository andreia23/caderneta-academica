package br.edu.ifpb.pweb2.bean;

import br.edu.ifpb.pweb2.controller.AlunoController;
import br.edu.ifpb.pweb2.model.Aluno;
import br.edu.ifpb.pweb2.model.Situations;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named(value = "editarNotaBean")
@ViewScoped
public class EditarNotaBean extends GenericAcademicoBean implements Serializable {

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

    public String salvar() {
        Double media = this.aluno.getMedia();
        if (this.aluno.getNotaFinal() != null) {
            double nota = ((media * 60) + (this.aluno.getNotaFinal().doubleValue() * 40)) / 100;
            if (nota >= 50) {
                this.aluno.setSituacao(Situations.AP);
            }
            else {
                this.aluno.setSituacao(Situations.RP);
            }
        } else if (media != null && this.aluno.getFaltas() != null) {
            if (this.aluno.getFaltas() >= 25) {
                this.aluno.setSituacao(Situations.RF);
            }
            else if (media < 40) {
                this.aluno.setSituacao(Situations.RP);
            }
            else if (media < 70) {
                this.aluno.setSituacao(Situations.FN);
            }
            else {
                this.aluno.setSituacao(Situations.AP);
            }
        }

        this.controllerAluno.saveOrUpdate(this.aluno);
        return "/notas/alunos?faces-redirect=true";
    }

}
