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

@Named(value = "relatorioAlunoBean")
@ViewScoped
public class RelatorioAlunoBean extends GenericAcademicoBean implements Serializable {

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

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String situacao(Situations situ)
    {
        switch (situ)
        {
            case AP:
                return "Aprovado";
            case FN:
                return "Em Final";
            case MT:
                return "Matriculado";
            case RF:
                return "Reprovado por Falta";
            case RP:
                return "Reprovado";
        }
        return "";
    }
}
