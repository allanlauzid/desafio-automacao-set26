# Rastreabilidade

| ID do caso | Slide | Tipo | Requisito ou cenário | Critério observável | Risco | Estado de implementação | Status da última execução | ID da última execução |
| --- | ---: | --- | --- | --- | --- | --- | --- | --- |
| API-01 | 3 | Exigência | Criar usuário, gerar token, confirmar autorização, listar catálogo, associar dois ISBNs distintos e consultar o usuário em um cenário contínuo | A consulta final retorna o usuário criado com exatamente os dois ISBNs escolhidos | O fluxo pode apresentar sucesso parcial e terminar sem a associação esperada | Implementado | Aprovado | R2-EXEC-002 |
| API-PA-01 | 3 | Prática adicional | Executar o mesmo fluxo no Postman | As seis respostas e a consulta final ficam comprovadas sem expor segredos | A operação manual pode ocultar um passo ou atribuir a execução à pessoa errada | Executado | Aprovado | R2-EXEC-005 |
| UI-01 | 4 | Exigência | Preencher e enviar Practice Form com arquivo `.txt`, confirmar e fechar o popup | Popup mostra os dados enviados e deixa de aparecer após o fechamento | O formulário pode aceitar o envio sem refletir corretamente os dados | Implementado | Aprovado | R2-EXEC-011 |
| UI-02 | 5 | Exigência | Abrir nova janela, validar a mensagem e fechar a janela | Surge uma janela adicional com `This is a sample page` e ela é fechada | A automação pode validar a janela original ou deixar a nova janela aberta | Implementado | Aprovado | R2-EXEC-012 |
| UI-03 | 6 | Exigência | Criar, editar e excluir o mesmo registro em Web Tables | O registro próprio reflete cada mudança e não aparece após a exclusão | A exclusão pode atingir outra linha ou a edição pode não persistir | Implementado | Aprovado | R2-EXEC-020 |
| UI-BONUS-01 | 6 | Bônus | Criar dinamicamente 12 registros com Cucumber e excluir todos | Os 12 registros coexistem antes da exclusão e nenhum permanece ao final | Uma exclusão pode fazer outros registros desaparecerem sem comprovar a exclusão individual | Implementado | Aprovado com DEF-UI-001 | R2-EXEC-019 |
| UI-04 | 7 | Exigência | Parar antes de 25%, validar valor até 25%, chegar a 100% e resetar | Valores observados atendem cada estado solicitado | O tempo da interface pode fazer a parada ultrapassar o limite | Implementado | Aprovado | R2-EXEC-023 |
| UI-05 | 8 | Exigência | Reordenar os elementos com drag and drop | A ordem final observada é crescente | O gesto pode mover o item visualmente sem produzir a ordem esperada | Planejado | Não executado | — |

## Decisão aprovada para API-01

- Um único caso e um único cenário Cucumber contêm os seis passos do slide.
- O estado nasce dentro do cenário; usuário, token e ISBNs não são compartilhados com outra execução.
- Senha e token permanecem fora de relatórios e mensagens de falha.
- Os códigos HTTP e os campos de resposta são verificações técnicas adicionais ao fluxo exigido.
- O Postman permanece uma prática adicional independente.

## Registro de uso de IA — checkpoint API-01

- Pedido à IA: analisar as fontes, propor o caso e, após revisão, implementar e executar o Slide 3.
- Sugestão ou implementação da IA: cenário Cucumber contínuo com REST Assured e verificações por resposta.
- Revisão e compreensão de Allan: pendente de descrição nas palavras de Allan.
- Ajuste ou teste pessoal de Allan: nenhum informado.
- Executor do teste: Assistente.
- Resultado real da primeira tentativa: `R2-EXEC-001` ficou Bloqueado antes da primeira chamada por ausência de serializador JSON.
- Classificação da ocorrência: Configuração.
- Investigação e ajuste: o REST Assured recebeu objetos Java no corpo das requisições, mas o projeto não declarava Jackson, Gson, Johnzon ou Yasson. Foi adicionada apenas a dependência `jackson-databind` necessária à serialização.
- Resultado real da segunda tentativa: `R2-EXEC-002` concluiu o cenário com 1 teste executado, 0 falhas, 0 erros e 0 ignorados.
- Status resumido de API-01: Aprovado na última execução, sem alterar o status Bloqueado preservado para `R2-EXEC-001`.
- Verificação adicional no Postman: `R2-EXEC-003` permanece Bloqueado por Ambiente; nenhuma chamada foi enviada nessa tentativa.
- Após a instalação do Postman e a autenticação feita por Allan, `R2-EXEC-004` iniciou no Postman Web e foi Reprovado no passo 1: o editor manteve uma chave extra e o corpo JSON inválido recebeu HTTP 400. A ocorrência foi classificada como preparação incorreta da requisição manual, não defeito da API.
- A nova tentativa `R2-EXEC-005`, executada pelo Assistente via interface do Postman, concluiu os seis passos: HTTP 201, 200, 200/`true`, 200, 201 e 200. A consulta final retornou exatamente os ISBNs `9781449325862` e `9781449331818` para o usuário criado.
- Senha e token não foram gravados nas evidências. A prática adicional não substitui nem altera o resultado da automação `R2-EXEC-002`.
- Limitação: o caminho principal não cobre testes negativos, segurança, desempenho ou concorrência.
- Ponto de Java que ainda não domino: pendente de informação de Allan.
- Ponto de Maven que ainda não domino: pendente de informação de Allan.
- Ponto de Cucumber que ainda não domino: pendente de informação de Allan.
- Ponto de REST Assured que ainda não domino: pendente de informação de Allan.
- Ponto de JUnit que ainda não domino: pendente de informação de Allan.

> **Aviso de commit do Slide 3:** depois de revisar o diff, o resultado e as evidências de API-01, solicitar autorização de Allan para criar o commit deste slide. Não incluir trabalho de outros slides no mesmo commit e não fazer push sem pedido explícito.

## Decisão aprovada para UI-01

- Um cenário Cucumber cobre a navegação, o preenchimento completo, o upload, o envio, a conferência do popup e o fechamento.
- Os dados válidos são fictícios e aleatórios; a seed de cada tentativa é registrada para reprodução.
- O arquivo `practice-form-upload.txt` faz parte do projeto, conforme exigido pelo slide.
- Os Page Objects executam ações e leem o estado; as comparações permanecem nos steps.
- A captura do popup é anexada ao relatório antes do fechamento.
- O clique no botão `Close` é tentado primeiro. No ambiente headless observado, a contingência com `Escape` foi necessária; a aprovação exige invisibilidade real ao fim da animação.

## Registro de uso de IA — checkpoint UI-01

- Pedido à IA: após aprovação do checkpoint, implementar e executar somente o Slide 4.
- Sugestão ou implementação da IA: cenário Cucumber com Selenium, dados aleatórios reproduzíveis, Page Objects e evidência do popup.
- Revisão e compreensão de Allan: pendente de descrição nas palavras de Allan.
- Ajuste ou teste pessoal de Allan: nenhum informado.
- Executor do teste: Assistente.
- `R2-EXEC-006`: Reprovado por oráculo de título desatualizado; nenhum defeito do produto demonstrado.
- `R2-EXEC-007`: Reprovado após validar os dados, por critério genérico de invisibilidade no fechamento.
- `R2-EXEC-008`: Reprovado porque o clique nativo não removeu `.modal.show`.
- `R2-EXEC-009`: Reprovado porque nem o clique nativo nem o evento JavaScript fecharam o modal no Chrome headless.
- `R2-EXEC-010`: Reprovado por falso negativo durante a animação de saída iniciada por `Escape`.
- `R2-EXEC-011`: Aprovado com 1 cenário executado, 0 falhas, 0 erros e 0 ignorados; todos os dados foram comparados e o popup ficou invisível após o fechamento.
- Limitação de ambiente: o Selenium 4.47.0 emitiu aviso de correspondência CDP 151 para Chrome 153. O cenário não usa comandos CDP e foi concluído.
- Ponto de Selenium que ainda não domino: pendente de informação de Allan.

> **Aviso de commit do Slide 4:** revisar o diff, as seis tentativas `R2-EXEC-006` a `R2-EXEC-011`, a rastreabilidade e as evidências. Depois da revisão, Allan deve executar pessoalmente um commit exclusivo do slide e o push. Mensagem sugerida: `test(slide-04): automatizar fluxo completo do Practice Form`.

## Decisão aprovada para UI-02

- Um cenário Cucumber cobre navegação, abertura, validação e fechamento da nova janela.
- O identificador novo é obtido pela diferença entre os conjuntos observados antes e depois do clique.
- A mensagem é comparada na janela secundária e a captura é anexada antes do fechamento.
- A validação final confirma o conjunto original de janelas, o foco original e a disponibilidade da página `Browser Windows`.
- O encerramento do WebDriver no `@After` evita janelas órfãs mesmo em caso de falha.

## Registro de uso de IA — checkpoint UI-02

- Pedido à IA: após aprovação do checkpoint, implementar e executar somente o Slide 5.
- Sugestão ou implementação da IA: cenário Cucumber com Selenium, Page Object e identificação da nova janela por diferença entre conjuntos.
- Revisão e compreensão de Allan: pendente de descrição nas palavras de Allan.
- Ajuste ou teste pessoal de Allan: nenhum informado.
- Executor do teste: Assistente.
- Resultado real: `R2-EXEC-012` foi Aprovado na primeira tentativa, com 1 cenário executado, 0 falhas, 0 erros e 0 ignorados.
- Evidência observável: captura da janela secundária com `This is a sample page`, relatórios Cucumber e relatórios Surefire.
- Limitação de ambiente: o Selenium 4.47.0 emitiu aviso de correspondência CDP 151 para Chrome 153. O cenário não usa comandos CDP e foi concluído.
- O resultado histórico do projeto anterior não foi usado como prova desta execução.
- Ponto de Selenium que ainda não domino: pendente de informação de Allan.

> **Aviso de commit do Slide 5:** revisar o diff, `R2-EXEC-012`, a rastreabilidade e as evidências. Depois da revisão, Allan deve executar pessoalmente um commit exclusivo do slide e o push. Mensagem sugerida: `test(slide-05): automatizar validacao de nova janela`.

## Decisão aprovada para UI-03 e UI-BONUS-01

- `UI-03` usa e-mail fictício único como chave para criar, conferir, editar e excluir somente o registro do teste.
- `UI-BONUS-01` gera 12 registros no próprio cenário Cucumber e mantém todos visíveis antes da exclusão.
- O requisito e o bônus têm runners, relatórios e resultados independentes.
- A tabela usa 20 linhas por página para manter os 12 registros novos e os três registros padrão na mesma visão.
- Capturas documentam criação, edição e exclusão no requisito e os estados anterior e posterior à exclusão no bônus.
- A rotina de encerramento tenta limpar registros remanescentes depois de preservar a evidência de uma falha.

## Registro de uso de IA — checkpoint do Slide 6

- Pedido à IA: implementar e executar o requisito obrigatório e, separadamente, o bônus dos 12 registros.
- Sugestão ou implementação da IA: cenários Cucumber independentes, Page Object, dados únicos e rastreamento por e-mail.
- Revisão e compreensão de Allan: pendente de descrição nas palavras de Allan.
- Ajuste ou teste pessoal de Allan: nenhum informado.
- Executor do teste: Assistente.
- `R2-EXEC-013` e `R2-EXEC-014`: Reprovados por localizadores incompatíveis com o DOM semântico atual.
- `R2-EXEC-015`: requisito obrigatório Aprovado.
- `R2-EXEC-016` e `R2-EXEC-017`: bônus Reprovado durante a investigação da exclusão em cascata.
- `R2-EXEC-018`: Reprovado pela asserção técnica que exigia redução de uma linha; o primeiro clique removeu as 12 linhas do teste.
- `R2-EXEC-019`: bônus Aprovado pelo critério final do slide, com `DEF-UI-001` registrado.
- `R2-EXEC-020`: regressão do requisito obrigatório Aprovada após a alteração compartilhada.
- Limitação de ambiente: o aviso CDP 151/Chrome 153 permaneceu sem impedir os cenários.
- Ponto de Selenium que ainda não domino: pendente de informação de Allan.

> **Aviso de commit do Slide 6:** revisar o diff, as execuções `R2-EXEC-013` a `R2-EXEC-020`, `DEF-UI-001`, a rastreabilidade e as evidências. Depois da revisão, Allan deve executar pessoalmente um commit exclusivo do slide e o push. Mensagem sugerida: `test(slide-06): automatizar operacoes da Web Tables`.

## Decisão aprovada para UI-04

- Um cenário Cucumber cobre navegação, início, parada, validação do limite, retomada, conclusão e reset.
- A ação e o oráculo permanecem distintos: o clique é solicitado com uma leitura abaixo de 25% e a aprovação exige valor estabilizado menor ou igual a 25%.
- O gatilho técnico em 10% cria margem para o avanço ocorrido entre a leitura e o clique; ele não altera o limite exigido pelo slide.
- O Page Object controla a interface e lê o percentual; as comparações ficam nos steps.
- Capturas documentam a barra parada, o estado em 100% e o estado depois do reset.

## Registro de uso de IA — checkpoint UI-04

- Pedido à IA: após aprovação do checkpoint, implementar e executar somente o Slide 7.
- Sugestão ou implementação da IA: cenário Cucumber com Selenium, Page Object, espera com consulta frequente e separação entre o momento da ação e o valor estabilizado.
- Revisão e compreensão de Allan: pendente de descrição nas palavras de Allan.
- Ajuste ou teste pessoal de Allan: nenhum informado.
- Executor do teste: Assistente.
- `R2-EXEC-021`: Bloqueado por Configuração antes da compilação, pois o Maven recebeu parte do parâmetro de identificação como fase inexistente.
- `R2-EXEC-022`: Aprovado com 1 cenário executado, 0 falhas, 0 erros e 0 ignorados; parada solicitada em 10%, valor estabilizado em 14%, conclusão em 100% e reset em 0%.
- A revisão de `R2-EXEC-022` identificou um segundo navegador aberto por sobreposição entre o hook genérico `@ui` e o hook específico `@progress-bar`. Esse navegador não participou das ações nem alterou as verificações.
- `R2-EXEC-023`: regressão Aprovada depois de restringir o hook genérico; somente um navegador foi iniciado, a parada foi solicitada em 10%, o valor estabilizou em 12%, chegou a 100% e voltou a 0%.
- Evidência observável: três capturas, relatórios Cucumber e relatórios Surefire.
- Limitação: o temporizador pode avançar entre a leitura e o clique; o oráculo final continua exigindo valor menor ou igual a 25%.
- Limitação de ambiente: o aviso CDP 151/Chrome 153 permaneceu sem impedir o cenário.
- Ponto de Selenium que ainda não domino: pendente de informação de Allan.

> **Aviso de commit do Slide 7:** revisar o diff, `R2-EXEC-021` a `R2-EXEC-023`, a rastreabilidade, o mapa do README e as evidências. Depois da revisão, Allan deve executar pessoalmente um commit exclusivo do slide e o push. Mensagem sugerida: `test(slide-07): automatizar estados da Progress Bar`.
