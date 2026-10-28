package com.academia;

import com.academia.decorator.AcessoPiscinaDecorator;
import com.academia.decorator.NutricionistaDecorator;
import com.academia.decorator.PersonalTrainerDecorator;
import com.academia.factory.PlanoFactory;
import com.academia.factory.TipoPlano;
import com.academia.model.Aluno;
import com.academia.model.Matricula;
import com.academia.model.Plano;
import com.academia.repository.AlunoRepository;
import com.academia.repository.AlunoRepositoryImpl;
import com.academia.repository.MatriculaRepository;
import com.academia.repository.MatriculaRepositoryImpl;
import com.academia.service.AlunoService;
import com.academia.service.MatriculaService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Inicialização mínima necessária para o teste
        AlunoRepository alunoRepo = new AlunoRepositoryImpl();
        MatriculaRepository matriculaRepo = new MatriculaRepositoryImpl();

        AlunoService alunoService = new AlunoService(alunoRepo);
        MatriculaService matriculaService = new MatriculaService(matriculaRepo, alunoRepo);

        Aluno aluno = alunoService.cadastrar(
                "Enzo", "222.333.444-55", "enzo@email.com", LocalDate.of(2002, 8, 20)
        );

        // --------------------------------------------------------------------
        // DEMONSTRAÇÃO DO PADRÃO DECORATOR (Adicionais Dinâmicos ao Plano)
        // --------------------------------------------------------------------
        System.out.println(">>> Demonstração do Padrão Decorator nos Planos da Academia\n");

        // 1. Plano base criado via Factory
        Plano plano = PlanoFactory.criarPlano(TipoPlano.TRIMESTRAL);
        System.out.println("[1] Plano Base:");
        exibirResumoPlano(plano);

        // 2. Adicionando Personal Trainer dinamicamente
        plano = new PersonalTrainerDecorator(plano);
        System.out.println("\n[2] Após adicionar PersonalTrainerDecorator:");
        exibirResumoPlano(plano);

        // 3. Adicionando Acesso à Piscina dinamicamente
        plano = new AcessoPiscinaDecorator(plano);
        System.out.println("\n[3] Após adicionar AcessoPiscinaDecorator:");
        exibirResumoPlano(plano);

        // 4. Adicionando Nutricionista dinamicamente
        plano = new NutricionistaDecorator(plano);
        System.out.println("\n[4] Após adicionar NutricionistaDecorator:");
        exibirResumoPlano(plano);

        // 5. Realizando a matrícula com o plano decorado
        Matricula matricula = matriculaService.matricular(aluno.getId(), plano);
        System.out.println("\n>>> Matrícula confirmada para " + aluno.getNome()
                + " | Plano final: " + matricula.getPlano().getDescricao()
                + " | Total: R$ " + String.format("%.2f", matricula.getPlano().calcularValorTotal()));
    }

    private static void exibirResumoPlano(Plano plano) {
        System.out.println("  Descrição: " + plano.getDescricao());
        System.out.println("  Mensalidade: R$ " + String.format("%.2f", plano.getValorMensal()));
        System.out.println("  Valor Total (" + plano.getDuracaoMeses() + " meses): R$ " + String.format("%.2f", plano.calcularValorTotal()));
        System.out.println("  Benefícios: " + plano.getBeneficios());
    }
}
