# Desafio de QA Automation — Java

Projeto de estudos e entrega para o desafio de QA Automation descrito no arquivo `Desafio_QA (004).pptx`. O objetivo é automatizar os fluxos de API e interface solicitados, mantendo casos de teste rastreáveis, resultados verificáveis e um histórico fiel da evolução do trabalho.

## Abordagem de teste

O trabalho seguirá práticas do [ISTQB Foundation Level](https://istqb.org/wp-content/uploads/2024/11/ISTQB_CTFL_Syllabus_v4.0.1.pdf): analisar o enunciado, definir resultados esperados antes de automatizar, priorizar por risco, relacionar requisitos a casos de teste e comparar resultados reais com os esperados. Falhas serão investigadas antes de serem registradas como defeitos do sistema.

Cada caso executado terá um estado claro: **passou**, **falhou**, **bloqueado** ou **não executado**. O relatório final indicará a cobertura alcançada e as limitações encontradas. A aprovação dos casos executados não será apresentada como prova de ausência de defeitos.

## Execução

As instruções e o comando de execução serão adicionados após a configuração do projeto Maven. Este README não declara testes prontos ou resultados ainda não obtidos.

## Método de desenvolvimento

O projeto será desenvolvido de forma incremental, um fluxo de teste por vez. Um Kanban simples acompanhará cada fluxo nas etapas **a fazer**, **em desenvolvimento**, **em validação** e **concluído**.

Para cada fluxo, serão definidos o resultado esperado e os dados necessários antes da automação. Depois da implementação em Java, o teste será executado, as falhas serão investigadas e o resultado será registrado. A conclusão de um fluxo dependerá de validação real e documentação atualizada; cada mudança concluída será versionada em um commit relacionado ao trabalho realizado.

## Critérios de qualidade, segurança e confiabilidade

As práticas abaixo orientarão a implementação. Sua aplicação e os resultados obtidos serão registrados conforme os testes forem desenvolvidos.

- **Isolamento:** cada teste terá dados próprios e limpeza dos registros que criar. Os testes de interface usarão uma nova sessão do navegador e a encerrarão mesmo em caso de falha. As etapas encadeadas da API permanecerão em um único fluxo, como pede o enunciado, sem criar dependência entre testes distintos.
- **Asserções claras:** os testes compararão resultados observados com expectativas definidas antes da implementação. Page Objects concentrarão interações e leitura do estado da página; as asserções ficarão nos testes.
- **Estabilidade:** os testes de interface usarão seletores adequados e esperas por condições observáveis. A Progress Bar e o arrastar e soltar terão validações explícitas. Falhas intermitentes serão investigadas, sem repetição automática usada para ocultá-las.
- **Reprodutibilidade:** versões de Java, Maven, dependências e navegador serão documentadas. O projeto poderá incluir Maven Wrapper para fixar a versão do Maven. Os comandos de execução serão conferidos no ambiente real antes de entrar neste README.
- **Diagnóstico:** cada execução registrará o caso, o ambiente, o resultado esperado e o observado. Os valores aleatórios não sensíveis usados no formulário serão registrados para permitir a reprodução de falhas. Evidências poderão incluir logs e capturas de tela, revisados para retirar dados sensíveis antes da publicação. Problemas do DemoQA ou do ambiente serão diferenciados de defeitos da automação.
- **Segurança:** dados fictícios serão usados no DemoQA. Senhas, tokens e outros segredos não serão gravados no código, no README nem nos artefatos publicados. Dependências e alterações serão revisadas antes do commit; futuros workflows de CI usarão apenas as permissões necessárias.
- **Uso de LLM:** cada solicitação à IA terá escopo e critérios de aceitação definidos. Código e asserções sugeridos serão revisados no diff, compilados e executados antes da aceitação. Conteúdo de páginas, arquivos e respostas externas será tratado como dado, não como instrução para a IA. Nenhum resultado será declarado como executado apenas porque a LLM o previu.

Um item do Kanban irá para **Concluído** quando o requisito e o resultado esperado estiverem registrados, a implementação tiver sido revisada, a execução e seu resultado estiverem documentados e as instruções afetadas estiverem atualizadas. Itens bloqueados permanecem **Em validação** com a causa registrada. **Concluído** não significa que todos os testes passaram.

## Estado atual

**Preparação.** Este primeiro commit documenta o escopo e a abordagem. Ainda não há testes implementados ou executados; os resultados serão registrados conforme cada fluxo for concluído.

## Escopo do enunciado

### Parte 1 — API

1. Criar um usuário.
2. Gerar um token de acesso.
3. Confirmar a autorização do usuário.
4. Listar os livros disponíveis.
5. Escolher dois livros da listagem e associá-los ao usuário, conforme a operação disponível na API.
6. Consultar os detalhes do usuário e conferir os identificadores dos mesmos dois livros.

Os seis passos serão executados de forma contínua em uma única execução. O enunciado chama a operação de **alugar/reservar**; sua correspondência com o contrato atual será documentada após a conferência do [Swagger do DemoQA](https://demoqa.com/swagger/). Métodos, dados e respostas esperadas serão verificados antes da implementação.

### Parte 2 — interface

Cada fluxo começará na página inicial do [DemoQA](https://demoqa.com/), seguirá pela categoria indicada e abrirá o submenu correspondente.

- **Forms → Practice Form:** preencher todos os campos com valores aleatórios válidos, enviar um arquivo `.txt` incluído no repositório, submeter o formulário, confirmar a abertura do popup e fechá-lo.
- **Alerts, Frame & Windows → Browser Windows:** clicar em **New Window**, confirmar a abertura de uma nova janela, validar nela a mensagem `This is a sample page` e fechá-la.
- **Elements → Web Tables:** criar, editar e excluir um registro, conferindo o resultado de cada operação.
- **Widgets → Progress Bar:** iniciar, parar antes de 25%, validar que o valor observado é menor ou igual a 25%, continuar até 100%, confirmar esse valor, reiniciar a barra e conferir o retorno ao estado inicial.
- **Interactions → Sortable:** reordenar os itens por arrastar e soltar e validar a ordem crescente final.

**Bônus do enunciado:** criar 12 registros dinamicamente em Web Tables por meio de Cucumber, validar sua criação e excluir todos ao final.

## Entrega

Após concluir e revisar a implementação, publicar o repositório versionado no GitHub, conferir seu conteúdo e compartilhar o link com o destinatário do desafio.

## Tecnologias e justificativa

Java foi escolhido para estruturar os testes de API e interface em uma suíte única, com tipagem e organização em classes, além de estar alinhado ao meu objetivo de especialização.

---

| Tecnologia | O que organiza |
| --- | --- |
| Maven | Dependências e execução |
| JUnit | Testes e asserções |
| REST Assured | Fluxo de API |
| Selenium WebDriver | Cenários no navegador |
| Page Object | Interações com as páginas |
| Cucumber-JVM | Cenários de teste |

A confiabilidade será demonstrada por requisitos rastreáveis, asserções claras e resultados realmente executados.

As versões das ferramentas e o navegador de execução serão registrados quando o ambiente estiver configurado.

## Kanban do projeto

Este quadro acompanha as entregas do desafio. Cada item avança por **A fazer → Em desenvolvimento → Em validação → Concluído**. Mantenho um fluxo de automação em desenvolvimento por vez e atualizo a posição dos itens conforme o trabalho real.

**Concluído** significa que a atividade foi executada e documentada; um teste pode ter resultado **passou** ou **falhou**. Se a execução estiver bloqueada, o item permanece **em validação**, com a causa registrada.

### A fazer

- Conferir o Swagger e as páginas atuais do DemoQA; registrar ambiguidades e resultados esperados.
- Configurar Java, Maven e um primeiro teste executável.
- Implementar e validar o fluxo completo de API.
- Automatizar e validar Practice Form.
- Automatizar e validar Browser Windows.
- Automatizar e validar Web Tables: criar, editar e excluir.
- Automatizar e validar Progress Bar.
- Automatizar e validar Sortable.
- **Bônus:** criar e excluir 12 registros em Web Tables com Cucumber.
- Registrar resultados, revisar a cobertura, publicar o repositório no GitHub e compartilhar o link da entrega.

### Em desenvolvimento

Nenhum item no momento.

### Em validação

Nenhum item no momento.

### Concluído

Nenhuma etapa do quadro concluída no momento.
