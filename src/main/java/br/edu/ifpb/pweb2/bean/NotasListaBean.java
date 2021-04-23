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
import java.util.Date;
import java.util.List;

@Named(value = "notasListaBean")
@ViewScoped
public class NotasListaBean extends GenericAcademicoBean implements Serializable {

    private List<Aluno> alunos;

    @Inject
    private AlunoController controllerAluno;

    @PostConstruct
    public void init() {
        this.alunos = this.controllerAluno.findAll();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String salvar() {
        for (Aluno a : this.alunos) {
            Double media = a.getMedia();
            if (a.getNotaFinal() != null && media != null) {
                double nota = ((media * 60) + (a.getNotaFinal().doubleValue() * 40)) / 100;
                if (nota >= 50) {
                    a.setSituacao(Situations.AP);
                } else {
                    a.setSituacao(Situations.RP);
                }
            } else if (a.getFaltas() != null) {
                if (a.getFaltas() >= 25) {
                    a.setSituacao(Situations.RF);
                } else if (media != null) {
                    if (media < 40) {
                        a.setSituacao(Situations.RP);
                    } else if (media < 70) {
                        a.setSituacao(Situations.FN);
                    } else {
                        a.setSituacao(Situations.AP);
                    }
                }
            }
            this.controllerAluno.saveOrUpdate(a);
        }
        return "/notas?faces-redirect=true";
    }
}
