# Uso de IA

Os campos marcados como “pendente de informação de Allan” aguardam preenchimento por Allan, com suas próprias palavras, antes da entrega final.

## Slide 3 — API-01

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

## Slide 4 — UI-01

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

## Slide 5 — UI-02

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

## Slide 6 — UI-03 e UI-BONUS-01

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

## Slide 7 — UI-04

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
