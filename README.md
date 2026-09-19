# Desafio QA Automation — nova rodada supervisionada

Projeto reconstruído na ordem dos slides do `Desafio_QA (004).pptx`. Cada checkpoint separa a exigência do enunciado, o bônus, os critérios de avaliação e as práticas adicionais.

## Abordagem de trabalho

Este projeto adota uma abordagem spec-first para automação de testes, inspirada em Spec-Driven Development. Antes de implementar cada requisito, a base de teste é analisada para definir a condição de teste, o risco, os dados, as ações e os resultados esperados. Após a revisão humana do checkpoint, a IA apoia a implementação e executa os testes. A rastreabilidade liga requisito, caso, tentativa de execução e evidência.

O processo utiliza terminologia do ISTQB e Cucumber, sem apresentar o uso isolado de Gherkin como prova de um processo completo de BDD. Na apresentação para entrevista, esta abordagem pode ser resumida como **automação de testes spec-first, assistida por IA e com revisão humana por checkpoint**. “Spec-Driven Testing” é usado apenas como uma analogia descritiva, não como termo oficial do ISTQB.

## Tecnologias

- Java 17 e Maven organizam a compilação e a execução.
- Cucumber descreve todos os fluxos como cenários executáveis.
- JUnit Platform executa os cenários Cucumber.
- REST Assured realiza as chamadas da API.
- Selenium WebDriver será usado nos checkpoints de interface.
- Page Objects concentrarão interações com a interface; as verificações observáveis ficarão nos steps.

O uso de Cucumber é um diferencial do enunciado e uma escolha para toda esta rodada. Um arquivo Gherkin, isoladamente, não comprova um processo colaborativo completo de BDD.

## Checkpoint atual

O Slide 3 está representado por `API-01`: um único cenário Cucumber contínuo que cria um usuário, gera token, confirma autorização, consulta o catálogo, associa dois ISBNs distintos e consulta o usuário com os dois livros.

```powershell
mvn -Dtest=ApiFlowTest test
```

Nesta máquina, `mvn` não está no `PATH`. As duas tentativas registradas usaram:

```powershell
& 'C:\Program Files\JetBrains\IntelliJ IDEA 2026.1.4\plugins\maven\lib\maven3\bin\mvn.cmd' -Dtest=ApiFlowTest test
```

Ambiente observado: Windows 11, Java 23.0.1 e Maven 3.9.11. O projeto compila os testes com compatibilidade Java 17.

Os relatórios temporários são produzidos em `target/`. As cópias sanitizadas de cada tentativa ficam em `evidencias/`.

Última execução de `API-01`: `R2-EXEC-002`, Aprovado. A tentativa anterior `R2-EXEC-001` permanece registrada como Bloqueado por configuração.

A prática adicional `API-PA-01` também foi concluída no Postman Web. `R2-EXEC-003` permanece Bloqueado por Ambiente; `R2-EXEC-004` permanece Reprovado por JSON manual inválido no primeiro passo; e `R2-EXEC-005` foi Aprovado após concluir os seis passos e confirmar os dois ISBNs na consulta final. O executor foi o Assistente via interface do Postman. Senha e token não foram armazenados nas evidências.

## Controle por slide

> **Aviso de checkpoint:** ao concluir cada slide, revisar o diff, a rastreabilidade, o resultado real e as evidências. Depois dessa revisão, solicitar autorização de Allan para fazer um commit exclusivo do slide. Não fazer commit ou push automaticamente.

O histórico de execução fica em `RESULTADOS.md`. O estado de implementação e o resumo da última execução ficam em `RASTREABILIDADE.md`.
