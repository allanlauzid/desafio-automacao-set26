# Desafio QA Automation — nova rodada supervisionada

Projeto reconstruído na ordem dos slides do `Desafio_QA (004).pptx`. Cada checkpoint separa a exigência do enunciado, o bônus, os critérios de avaliação e as práticas adicionais.

## Estrutura do projeto

```text
src/test/
├── java/com/accenture/challenge/
│   ├── ApiFlowTest.java                 ← Slide 3 / API-01 (runner)
│   ├── ApiSteps.java                    ← Slide 3 / API-01 (steps)
│   ├── UiFlowTest.java                  ← Slide 4 / UI-01 (runner)
│   ├── PracticeFormSteps.java           ← Slides 4 e 5 / UI-01 e UI-02 (steps compartilhados)
│   ├── BrowserWindowsTest.java          ← Slide 5 / UI-02 (runner)
│   ├── WebTablesRequiredTest.java       ← Slide 6 / UI-03 (runner)
│   ├── WebTablesBonusTest.java          ← Slide 6 / UI-BONUS-01 (runner)
│   ├── WebTablesSteps.java              ← Slide 6 / UI-03 e UI-BONUS-01 (steps)
│   ├── ProgressBarTest.java             ← Slide 7 / UI-04 (runner)
│   ├── ProgressBarSteps.java            ← Slide 7 / UI-04 (steps)
│   ├── SortableTest.java                ← Slide 8 / UI-05 (runner)
│   ├── SortableSteps.java               ← Slide 8 / UI-05 (steps)
│   └── ui/
│       ├── BasePage.java                ← Slides 4 a 8 (base compartilhada)
│       ├── NavigationPage.java          ← Slides 4 a 8 (navegação compartilhada)
│       ├── PracticeFormPage.java        ← Slide 4 / UI-01
│       ├── StudentData.java             ← Slide 4 / UI-01 (dados)
│       ├── BrowserWindowsPage.java      ← Slide 5 / UI-02
│       ├── WebTablesPage.java           ← Slide 6 / UI-03 e UI-BONUS-01
│       ├── PersonData.java              ← Slide 6 / UI-03 e UI-BONUS-01 (dados)
│       ├── ProgressBarPage.java         ← Slide 7 / UI-04
│       └── SortablePage.java            ← Slide 8 / UI-05
└── resources/
    ├── features/
    │   ├── 03_api.feature              ← Slide 3 / API-01
    │   ├── 04_practice_form.feature    ← Slide 4 / UI-01
    │   ├── 05_browser_windows.feature  ← Slide 5 / UI-02
    │   ├── 06_web_tables.feature       ← Slide 6 / UI-03 e UI-BONUS-01
    │   ├── 07_progress_bar.feature     ← Slide 7 / UI-04
    │   └── 08_sortable.feature         ← Slide 8 / UI-05
    └── files/
        └── practice-form-upload.txt    ← Slide 4 / UI-01 (arquivo de upload)

evidencias/
├── slide-03-api/                       ← Slide 3 / API-01 e API-PA-01
├── slide-04-practice-form/             ← Slide 4 / UI-01
├── slide-05-browser-windows/           ← Slide 5 / UI-02
├── slide-06-web-tables/                ← Slide 6 / UI-03 e UI-BONUS-01
├── slide-07-progress-bar/              ← Slide 7 / UI-04
└── slide-08-sortable/                  ← Slide 8 / UI-05
```

## Convenção de nomes

Os arquivos `.feature` começam com o número do slide, como `07_progress_bar.feature`. Runners, steps e Page Objects recebem nomes relacionados ao fluxo e são ligados explicitamente pelo mapa de artefatos. Uma classe de steps pode atender mais de um fluxo, e um slide pode possuir mais de um runner.

## Ir direto para um slide

- [Slide 3 — API](src/test/resources/features/03_api.feature)
- [Slide 4 — Practice Form](src/test/resources/features/04_practice_form.feature)
- [Slide 5 — Browser Windows](src/test/resources/features/05_browser_windows.feature)
- [Slide 6 — Web Tables](src/test/resources/features/06_web_tables.feature)
- [Slide 7 — Progress Bar](src/test/resources/features/07_progress_bar.feature)
- [Slide 8 — Sortable](src/test/resources/features/08_sortable.feature)

## Abordagem de trabalho

Este projeto adota uma abordagem spec-first para automação de testes, inspirada em Spec-Driven Development. Antes de implementar cada requisito, a base de teste é analisada para definir a condição de teste, o risco, os dados, as ações e os resultados esperados. Após a revisão humana do checkpoint, a IA apoia a implementação e executa os testes. A rastreabilidade liga requisito, caso, tentativa de execução e evidência.

O processo utiliza terminologia do ISTQB e Cucumber, sem apresentar o uso isolado de Gherkin como prova de um processo completo de BDD. Na apresentação para entrevista, esta abordagem pode ser resumida como **automação de testes spec-first, assistida por IA e com revisão humana por checkpoint**. “Spec-Driven Testing” é usado apenas como uma analogia descritiva, não como termo oficial do ISTQB.

## Tecnologias

- Java 17 e Maven organizam a compilação e a execução.
- Cucumber descreve todos os fluxos como cenários executáveis.
- JUnit Platform executa os cenários Cucumber.
- REST Assured realiza as chamadas da API.
- Selenium WebDriver realiza os checkpoints de interface.
- Page Objects concentram interações e leitura de estado; as asserções observáveis ficam nos steps.

O uso de Cucumber é um diferencial do enunciado e uma escolha para toda esta rodada. Um arquivo Gherkin, isoladamente, não comprova um processo colaborativo completo de BDD.

## Checkpoint concluído — Slide 3

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

## Checkpoint concluído — Slide 4

O Slide 4 está representado por `UI-01`: acessar o DemoQA, abrir `Forms > Practice Form`, preencher todos os campos com dados fictícios válidos e aleatórios, anexar o arquivo versionado `practice-form-upload.txt`, submeter, comparar todos os dados do popup e fechá-lo.

```powershell
mvn -Dtest=UiFlowTest test
```

Última execução de `UI-01`: `R2-EXEC-011`, Aprovado, com 1 cenário, 0 falhas, 0 erros e 0 ignorados. As tentativas `R2-EXEC-006` a `R2-EXEC-010` permanecem preservadas como reprovadas por falhas da automação investigadas e corrigidas.

No Chrome headless observado, o clique nativo no botão `Close` não alterou o modal. A automação registra essa limitação, usa `Escape` como contingência acessível e só aprova o fechamento após `.modal-content` ficar invisível. O aviso de compatibilidade aproximada CDP 151/Chrome 153 não afetou o cenário, que não depende de comandos CDP.

## Checkpoint concluído — Slide 5

O Slide 5 está representado por `UI-02`: acessar `Alerts, Frame & Windows > Browser Windows`, abrir uma nova janela, validar a mensagem `This is a sample page`, fechar a janela secundária e confirmar que somente a original permaneceu aberta.

```powershell
mvn -Dtest=BrowserWindowsTest test
```

Última execução de `UI-02`: `R2-EXEC-012`, Aprovado na primeira tentativa, com 1 cenário, 0 falhas, 0 erros e 0 ignorados. A nova janela é obtida pela diferença entre os conjuntos de identificadores, sem depender de posição fixa.

## Checkpoint concluído — Slide 6

O Slide 6 contém o requisito `UI-03` e o bônus `UI-BONUS-01`. O requisito cria, confere, edita, confere novamente e exclui o mesmo registro. O bônus cria 12 registros dinâmicos, compara todos e confirma que nenhum permanece após a exclusão.

```powershell
mvn -Dtest=WebTablesRequiredTest test
mvn -Dtest=WebTablesBonusTest test
```

Última execução de `UI-03`: `R2-EXEC-020`, Aprovado. A primeira aprovação ocorreu em `R2-EXEC-015`; a regressão confirmou o fluxo depois da alteração compartilhada de exclusão.

Última execução de `UI-BONUS-01`: `R2-EXEC-019`, Aprovado com `DEF-UI-001` registrado. Os 12 registros foram criados e validados, mas o primeiro clique de exclusão removeu todas as 12 linhas adicionadas. A ausência final exigida pelo bônus foi confirmada e os três registros padrão permaneceram intactos.

## Checkpoint concluído — Slide 7

O Slide 7 está representado por `UI-04`: acessar `Widgets > Progress Bar`, iniciar, solicitar a parada antes de 25%, validar o valor estabilizado menor ou igual a 25%, retomar até 100% e resetar para 0%.

```powershell
mvn "-Dtest=ProgressBarTest" "-Dexecution.id=R2-EXEC-023" test
```

Na chamada pelo PowerShell, os dois argumentos `-D` foram passados entre aspas para chegarem íntegros ao Maven.

`R2-EXEC-021` permanece Bloqueado por Configuração porque o cenário não iniciou. `R2-EXEC-022` foi Aprovado, mas a revisão do relatório identificou um segundo navegador aberto por sobreposição de hooks. Esse navegador não participou das ações. Depois da correção, `R2-EXEC-023` foi Aprovado com 1 cenário, 0 falhas, 0 erros e 0 ignorados. O clique em `Stop` foi solicitado em 10%, a barra estabilizou em 12%, chegou a 100% e retornou a 0% após o reset.

## Checkpoint concluído — Slide 8

O Slide 8 está representado por `UI-05`: acessar `Interactions > Sortable`, comprovar uma mudança de ordem por drag and drop e terminar com os seis elementos em ordem crescente. Como a lista padrão já começa crescente, o cenário primeiro move `Six` para o início e confirma a ordem não crescente antes de executar a ordenação.

```powershell
& 'C:\Program Files\JetBrains\IntelliJ IDEA 2026.1.4\plugins\maven\lib\maven3\bin\mvn.cmd' "-Dtest=SortableTest" "-Dexecution.id=R2-EXEC-026" test
```

`R2-EXEC-024` e `R2-EXEC-025` permanecem Bloqueados por Configuração e Ambiente, respectivamente, porque o cenário não chegou a iniciar. `R2-EXEC-026` foi Aprovado com 1 cenário, 0 falhas, 0 erros e 0 ignorados. A ordem observada mudou para `[Six, One, Two, Three, Four, Five]` e terminou em `[One, Two, Three, Four, Five, Six]`.

## Mapa rápido dos artefatos por slide

Este é o ponto de entrada para localizar a automação, as evidências e os resultados. `RESULTADOS.md` mantém uma linha por tentativa e aponta para cada `execucao.md`; `RASTREABILIDADE.md` apresenta o estado atual de cada caso.

### Onde está a automação

| Slide / caso | Feature | Test (runner) | Steps | Page Object / dados |
|---|---|---|---|---|
| Slide 3 / `API-01` | [`03_api.feature`](src/test/resources/features/03_api.feature) | [`ApiFlowTest.java`](src/test/java/com/accenture/challenge/ApiFlowTest.java) | [`ApiSteps.java`](src/test/java/com/accenture/challenge/ApiSteps.java) | Não se aplica à API |
| Slide 3 / `API-PA-01` | Mesmo fluxo de [`03_api.feature`](src/test/resources/features/03_api.feature), executado adicionalmente no Postman | Não se aplica | Não se aplica | Não se aplica |
| Slide 4 / `UI-01` | [`04_practice_form.feature`](src/test/resources/features/04_practice_form.feature) | [`UiFlowTest.java`](src/test/java/com/accenture/challenge/UiFlowTest.java) | [`PracticeFormSteps.java`](src/test/java/com/accenture/challenge/PracticeFormSteps.java) | [`PracticeFormPage.java`](src/test/java/com/accenture/challenge/ui/PracticeFormPage.java), [`StudentData.java`](src/test/java/com/accenture/challenge/ui/StudentData.java) e [`practice-form-upload.txt`](src/test/resources/files/practice-form-upload.txt) |
| Slide 5 / `UI-02` | [`05_browser_windows.feature`](src/test/resources/features/05_browser_windows.feature) | [`BrowserWindowsTest.java`](src/test/java/com/accenture/challenge/BrowserWindowsTest.java) | [`PracticeFormSteps.java`](src/test/java/com/accenture/challenge/PracticeFormSteps.java), compartilhado com o Slide 4 | [`BrowserWindowsPage.java`](src/test/java/com/accenture/challenge/ui/BrowserWindowsPage.java) |
| Slide 6 / `UI-03` | [`06_web_tables.feature`](src/test/resources/features/06_web_tables.feature) | [`WebTablesRequiredTest.java`](src/test/java/com/accenture/challenge/WebTablesRequiredTest.java) | [`WebTablesSteps.java`](src/test/java/com/accenture/challenge/WebTablesSteps.java) | [`WebTablesPage.java`](src/test/java/com/accenture/challenge/ui/WebTablesPage.java) e [`PersonData.java`](src/test/java/com/accenture/challenge/ui/PersonData.java) |
| Slide 6 / `UI-BONUS-01` | [`06_web_tables.feature`](src/test/resources/features/06_web_tables.feature) | [`WebTablesBonusTest.java`](src/test/java/com/accenture/challenge/WebTablesBonusTest.java) | [`WebTablesSteps.java`](src/test/java/com/accenture/challenge/WebTablesSteps.java) | [`WebTablesPage.java`](src/test/java/com/accenture/challenge/ui/WebTablesPage.java) e [`PersonData.java`](src/test/java/com/accenture/challenge/ui/PersonData.java) |
| Slide 7 / `UI-04` | [`07_progress_bar.feature`](src/test/resources/features/07_progress_bar.feature) | [`ProgressBarTest.java`](src/test/java/com/accenture/challenge/ProgressBarTest.java) | [`ProgressBarSteps.java`](src/test/java/com/accenture/challenge/ProgressBarSteps.java) | [`ProgressBarPage.java`](src/test/java/com/accenture/challenge/ui/ProgressBarPage.java) |
| Slide 8 / `UI-05` | [`08_sortable.feature`](src/test/resources/features/08_sortable.feature) | [`SortableTest.java`](src/test/java/com/accenture/challenge/SortableTest.java) | [`SortableSteps.java`](src/test/java/com/accenture/challenge/SortableSteps.java) | [`SortablePage.java`](src/test/java/com/accenture/challenge/ui/SortablePage.java) |

### Onde está a evidência

| Slide / caso | Pasta de evidência | Última execução | Defeito registrado |
|---|---|---|---|
| Slide 3 / `API-01` | [`slide-03-api`](evidencias/slide-03-api/) | [`R2-EXEC-002`](evidencias/slide-03-api/R2-EXEC-002-automatizada/execucao.md) | — |
| Slide 3 / `API-PA-01` | [`slide-03-api`](evidencias/slide-03-api/) | [`R2-EXEC-005`](evidencias/slide-03-api/R2-EXEC-005-manual/execucao.md) | — |
| Slide 4 / `UI-01` | [`slide-04-practice-form`](evidencias/slide-04-practice-form/) | [`R2-EXEC-011`](evidencias/slide-04-practice-form/R2-EXEC-011-automatizada/execucao.md) | — |
| Slide 5 / `UI-02` | [`slide-05-browser-windows`](evidencias/slide-05-browser-windows/) | [`R2-EXEC-012`](evidencias/slide-05-browser-windows/R2-EXEC-012-automatizada/execucao.md) | — |
| Slide 6 / `UI-03` | [`slide-06-web-tables`](evidencias/slide-06-web-tables/) | [`R2-EXEC-020`](evidencias/slide-06-web-tables/R2-EXEC-020-automatizada/execucao.md) | — |
| Slide 6 / `UI-BONUS-01` | [`slide-06-web-tables`](evidencias/slide-06-web-tables/) | [`R2-EXEC-019`](evidencias/slide-06-web-tables/R2-EXEC-019-automatizada/execucao.md) | [`DEF-UI-001`](evidencias/slide-06-web-tables/DEF-UI-001-exclusao-em-cascata.md) |
| Slide 7 / `UI-04` | [`slide-07-progress-bar`](evidencias/slide-07-progress-bar/) | [`R2-EXEC-023`](evidencias/slide-07-progress-bar/R2-EXEC-023-automatizada/execucao.md) | — |
| Slide 8 / `UI-05` | [`slide-08-sortable`](evidencias/slide-08-sortable/) | [`R2-EXEC-026`](evidencias/slide-08-sortable/R2-EXEC-026-automatizada/execucao.md) | — |

Componentes compartilhados pelos fluxos de interface: [`BasePage.java`](src/test/java/com/accenture/challenge/ui/BasePage.java) e [`NavigationPage.java`](src/test/java/com/accenture/challenge/ui/NavigationPage.java).

Índices de acompanhamento: [`RASTREABILIDADE.md`](RASTREABILIDADE.md) e [`RESULTADOS.md`](RESULTADOS.md).

## Controle por slide

> **Aviso de checkpoint:** ao concluir cada slide, revisar o diff, a rastreabilidade, o resultado real e as evidências. Depois dessa revisão, parar para que Allan faça pessoalmente o commit e o push. O Assistente não executa esses comandos.

O histórico de execução fica em [`RESULTADOS.md`](RESULTADOS.md), e o estado atual dos casos fica em [`RASTREABILIDADE.md`](RASTREABILIDADE.md). As decisões técnicas ficam em [`docs/decisoes/`](docs/decisoes/), o registro da colaboração com IA em [`USO-DE-IA.md`](USO-DE-IA.md) e os commits confirmados em [`CONTROLE-DE-COMMITS.md`](CONTROLE-DE-COMMITS.md).
