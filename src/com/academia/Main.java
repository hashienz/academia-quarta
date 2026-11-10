package com.academia;

import com.academia.decorator.AcessoPiscinaDecorator;
import com.academia.decorator.NutricionistaDecorator;
import com.academia.decorator.PersonalTrainerDecorator;
import com.academia.factory.PlanoFactory;
import com.academia.factory.TipoPlano;
import com.academia.model.Aluno;
import com.academia.model.Exercicio;
import com.academia.model.Instrutor;
import com.academia.model.Matricula;
import com.academia.model.Plano;
import com.academia.model.Treino;
import com.academia.observer.ConsoleMatriculaObserver;
import com.academia.repository.AlunoRepository;
import com.academia.repository.AlunoRepositoryImpl;
import com.academia.repository.InstrutorRepository;
import com.academia.repository.InstrutorRepositoryImpl;
import com.academia.repository.MatriculaRepository;
import com.academia.repository.MatriculaRepositoryImpl;
import com.academia.repository.TreinoRepository;
import com.academia.repository.TreinoRepositoryImpl;
import com.academia.service.AlunoService;
import com.academia.service.InstrutorService;
import com.academia.service.MatriculaService;
import com.academia.service.TreinoService;
import com.academia.strategy.EstrategiaHipertrofia;
import com.academia.strategy.EstrategiaResistencia;
import com.academia.strategy.EstrategiaTreino;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Inicialização mínima necessária para o teste
        AlunoRepository alunoRepo = new AlunoRepositoryImpl();
        MatriculaRepository matriculaRepo = new MatriculaRepositoryImpl();

        AlunoService alunoService = new AlunoService(alunoRepo);
        MatriculaService matriculaService = new MatriculaService(matriculaRepo, alunoRepo);
        matriculaService.adicionarObservador(new ConsoleMatriculaObserver());

        Aluno aluno = alunoService.cadastrar(
                "Enzo", "222.333.444-55", "enzo@email.com", LocalDate.of(2002, 8, 20)
        );

        // --------------------------------------------------------------------
        // DEMONSTRAÇÃO DO PADRÃO DECORATOR (Adicionais Dinâmicos ao Plano)
        // --------------------------------------------------------------------
        System.out.println("=== Padrão Decorator: adicionais ao plano ===\n");

        // 1. Plano base criado via Factory
        Plano plano = PlanoFactory.criarPlano(TipoPlano.TRIMESTRAL);
        System.out.println("[1] Plano base:");
        exibirResumoPlano(plano);

        // 2. Adicionando Personal Trainer dinamicamente
        plano = new PersonalTrainerDecorator(plano);
        System.out.println("\n[2] Com Personal Trainer:");
        exibirResumoPlano(plano);

        // 3. Adicionando Acesso à Piscina dinamicamente
        plano = new AcessoPiscinaDecorator(plano);
        System.out.println("\n[3] Com acesso à piscina:");
        exibirResumoPlano(plano);

        // 4. Adicionando Nutricionista dinamicamente
        plano = new NutricionistaDecorator(plano);
        System.out.println("\n[4] Com nutricionista:");
        exibirResumoPlano(plano);

        // 5. Realizando a matrícula com o plano decorado
        Matricula matricula = matriculaService.matricular(aluno.getId(), plano);
        System.out.println("\n>>> Matrícula confirmada para " + aluno.getNome()
                + " | Plano final: " + matricula.getPlano().getDescricao()
                + " | Total: R$ " + String.format("%.2f", matricula.getPlano().calcularValorTotal()));

        // --------------------------------------------------------------------
        // DEMONSTRAÇÃO DO PADRÃO PROTOTYPE (Clonagem de Treinos)
        // --------------------------------------------------------------------
        System.out.println("\n=== Padrão Prototype: clonagem de treinos ===\n");

        InstrutorRepository instrutorRepo = new InstrutorRepositoryImpl();
        TreinoRepository treinoRepo = new TreinoRepositoryImpl();
        InstrutorService instrutorService = new InstrutorService(instrutorRepo);
        TreinoService treinoService = new TreinoService(treinoRepo, alunoRepo, instrutorRepo, matriculaRepo);

        Instrutor instrutor = instrutorService.cadastrar(
                "Carla", "111.222.333-44", "carla@email.com", LocalDate.of(1990, 3, 15),
                "Musculação", "123456-G/SP", LocalDate.of(2020, 1, 10)
        );

        Aluno outroAluno = alunoService.cadastrar(
                "Lucas", "333.444.555-66", "lucas@email.com", LocalDate.of(2000, 5, 12)
        );
        matriculaService.matricular(outroAluno.getId(), TipoPlano.MENSAL);

        // --------------------------------------------------------------------
        // DEMONSTRAÇÃO DO PADRÃO STRATEGY (Prescrição de Exercícios)
        // --------------------------------------------------------------------
        System.out.println("\n=== Padrão Strategy: prescrição de exercícios ===\n");

        // 1. A estratégia de hipertrofia define séries, repetições e descanso
        EstrategiaTreino estrategiaHipertrofia = new EstrategiaHipertrofia();
        Treino original = treinoService.criarTreino(aluno.getId(), instrutor.getId(), "Treino A", "Hipertrofia");
        treinoService.adicionarExercicio(original.getId(), "Supino Reto", "Peito", estrategiaHipertrofia);
        treinoService.adicionarExercicio(original.getId(), "Crucifixo", "Peito", estrategiaHipertrofia);
        treinoService.adicionarExercicio(original.getId(), "Tríceps Corda", "Tríceps", estrategiaHipertrofia);
        System.out.println("[1] Treino original:");
        exibirTreino(original);

        EstrategiaTreino estrategiaResistencia = new EstrategiaResistencia();
        Treino treinoResistencia = treinoService.criarTreino(
                outroAluno.getId(), instrutor.getId(), "Treino B", "Resistência"
        );
        treinoService.adicionarExercicio(
                treinoResistencia.getId(), "Esteira", "Cardiorrespiratório", estrategiaResistencia
        );
        System.out.println("\n[2] Treino com estratégia de resistência:");
        exibirTreino(treinoResistencia);

        // 2. Clonando o treino para outro aluno, sem recadastrar os exercícios
        Treino clone = treinoService.duplicarTreinoParaAluno(original.getId(), outroAluno.getId());
        System.out.println("\n[3] Treino clonado:");
        exibirTreino(clone);

        // 3. Alterando o clone para provar que é uma cópia independente
        Exercicio supinoDoClone = clone.getExercicios().get(0);
        supinoDoClone.setSeries(5);
        supinoDoClone.setRepeticoes(6);
        System.out.println("\n[4] Após ajustar o Supino no clone (5x6):");
        System.out.println("  Clone:    " + supinoDoClone);
        System.out.println("  Original: " + original.getExercicios().get(0));
    }

    private static void exibirTreino(Treino treino) {
        System.out.println("  ID: " + treino.getId() + " | " + treino.getNomeTreino() + " (" + treino.getObjetivo() + ")"
                + " | Aluno: " + treino.getAluno().getNome() + " | Instrutor: " + treino.getInstrutor().getNome());
        treino.getExercicios().forEach(e -> System.out.println("    - " + e));
    }

    private static void exibirResumoPlano(Plano plano) {
        System.out.println("  Descrição: " + plano.getDescricao());
        System.out.println("  Mensalidade: R$ " + String.format("%.2f", plano.getValorMensal()));
        System.out.println("  Valor Total (" + plano.getDuracaoMeses() + " meses): R$ " + String.format("%.2f", plano.calcularValorTotal()));
        System.out.println("  Benefícios: " + plano.getBeneficios());
    }
}
