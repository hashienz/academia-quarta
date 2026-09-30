# Academia Quarta

Sistema de demonstração em Java para gestão de alunos, instrutores, matrículas, planos e treinos. Os dados ficam em memória durante a execução.

## Executar (PowerShell)

Com JDK 17 ou superior disponível no `PATH`, execute na raiz do projeto:

```powershell
$sources = Get-ChildItem src -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d bin $sources
java -cp bin com.academia.Main
```

A classe `Main` mostra o fluxo principal e o tratamento de duas exceções esperadas. Consulte [DEFESA_DO_CODIGO.md](DEFESA_DO_CODIGO.md) para o diagrama e o roteiro da apresentação.
