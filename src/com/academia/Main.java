package com.academia;

import com.academia.config.AcademiaConfig;
import com.academia.factory.TipoPlano;
import com.academia.model.*;
import com.academia.repository.*;
import com.academia.service.*;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // --------------------------------------------------------------------
        // 1. DEMONSTRAÇÃO DO PADRÃO SINGLETON (Configuração Global)
        // --------------------------------------------------------------------
        System.out.println(">>> 1. Configuração Global da Academia (Padrão Singleton)");
        AcademiaConfig config = AcademiaConfig.getInstance();
        System.out.println("Nome da Academia: " + config.getNomeAcademia());
        System.out.println("Horário de Funcionamento: " + config.getHorarioAbertura() + " às " + config.getHorarioFechamento());
        System.out.println("Capacidade Máxima: " + config.getCapacidadeMaximaAlunos() + " alunos");
        System.out.println("Desconto do Plano Anual: " + (config.getPercentualDescontoPlanoAnual() * 100) + "%\n");

        // --------------------------------------------------------------------
        // 2. DEMONSTRAÇÃO DE INJEÇÃO DE DEPENDÊNCIA (DIP / SOLID)
        // --------------------------------------------------------------------
        System.out.println(">>> 2. Inicializando Repositórios e Serviços (Injeção de Dependência)");
        // Instanciação das implementações concretas dos Repositórios
        AlunoRepository alunoRepo = new AlunoRepositoryImpl();
        InstrutorRepository instrutorRepo = new InstrutorRepositoryImpl();
        MatriculaRepository matriculaRepo = new MatriculaRepositoryImpl();
        TreinoRepository treinoRepo = new TreinoRepositoryImpl();

        // Injeção de Dependências via Construtor nos Serviços
        AlunoService alunoService = new AlunoService(alunoRepo);
        InstrutorService instrutorService = new InstrutorService(instrutorRepo);
        MatriculaService matriculaService = new MatriculaService(matriculaRepo);
        TreinoService treinoService = new TreinoService(treinoRepo, alunoRepo, instrutorRepo);

        System.out.println("[OK] Serviços inicializados com suas abstrações injetadas com sucesso.\n");

        // --------------------------------------------------------------------
        // 3. CADASTRO DE INSTRUTORES E ALUNOS (Herança + LSP + SRP)
        // --------------------------------------------------------------------
        System.out.println(">>> 3. Cadastrando Pessoas no Sistema (Herança de Pessoa)");
        Instrutor instrutor1 = instrutorService.cadastrar(
                "Carlos Silva", "111.222.333-44", "carlos@academia.com",
                LocalDate.of(1990, 5, 15), "Musculação & Hipertrofia", "CREF-123456-G/SP", LocalDate.now()
        );
        System.out.println("Instrutor Cadastrado: " + instrutor1.getNome() + " | CREF: " + instrutor1.getCref());

        Aluno aluno1 = alunoService.cadastrar(
                "Enzo Hashimoto", "222.333.444-55", "enzo@email.com", LocalDate.of(2002, 8, 20)
        );
        Aluno aluno2 = alunoService.cadastrar(
                "Mariana Costa", "333.444.555-66", "mariana@email.com", LocalDate.of(2001, 3, 10)
        );
        System.out.println("Aluno 1 Cadastrado: ID " + aluno1.getId() + " - " + aluno1.getNome());
        System.out.println("Aluno 2 Cadastrado: ID " + aluno2.getId() + " - " + aluno2.getNome() + "\n");

        // --------------------------------------------------------------------
        // 4. MATRÍCULA COM FACTORY METHOD (OCP / SOLID)
        // --------------------------------------------------------------------
        System.out.println(">>> 4. Realizando Matrículas (Padrão Factory Method)");
        Matricula mat1 = matriculaService.matricular(aluno1.getId(), TipoPlano.ANUAL);
        Matricula mat2 = matriculaService.matricular(aluno2.getId(), TipoPlano.VIP);

        System.out.println("\n--- Detalhes da Matrícula 1 ---");
        System.out.println("Aluno: " + aluno1.getNome());
        System.out.println("Plano: " + mat1.getPlano().getDescricao());
        System.out.println("Mensalidade Base: R$ " + mat1.getPlano().getValorMensal());
        System.out.println("Duração: " + mat1.getPlano().getDuracaoMeses() + " meses");
        System.out.println("Valor Total com Desconto: R$ " + String.format("%.2f", mat1.getPlano().calcularValorTotal()));
        System.out.println("Benefícios: " + mat1.getPlano().getBeneficios());

        System.out.println("\n--- Detalhes da Matrícula 2 ---");
        System.out.println("Aluno: " + aluno2.getNome());
        System.out.println("Plano: " + mat2.getPlano().getDescricao());
        System.out.println("Valor Total com Desconto: R$ " + String.format("%.2f", mat2.getPlano().calcularValorTotal()));
        System.out.println("Benefícios: " + mat2.getPlano().getBeneficios() + "\n");

        // --------------------------------------------------------------------
        // 5. PRESCRIÇÃO E GESTÃO DE TREINOS
        // --------------------------------------------------------------------
        System.out.println(">>> 5. Prescrevendo Ficha de Treino");
        Treino treinoEnzo = treinoService.criarTreino(
                aluno1.getId(), instrutor1.getId(), "Treino A - Peito e Tríceps", "Hipertrofia"
        );

        treinoService.adicionarExercicio(treinoEnzo.getId(), "Supino Reto com Barra", "Peitoral", 4, 10, 60);
        treinoService.adicionarExercicio(treinoEnzo.getId(), "Supino Inclinado com Halteres", "Peitoral", 3, 12, 45);
        treinoService.adicionarExercicio(treinoEnzo.getId(), "Tríceps Testa", "Tríceps", 4, 12, 45);

        System.out.println("Ficha de Treino Criada: " + treinoEnzo.getNomeTreino() + " (Objetivo: " + treinoEnzo.getObjetivo() + ")");
        System.out.println("Instrutor Responsável: " + treinoEnzo.getInstrutor().getNome());
        System.out.println("Exercícios Prescritos:");
        for (Exercicio ex : treinoEnzo.getExercicios()) {
            System.out.println(" - " + ex);
        }

       
    }
}
