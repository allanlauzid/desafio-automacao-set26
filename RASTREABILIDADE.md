# Rastreabilidade

| ID do caso | Slide | Tipo | Requisito ou cenário | Critério observável | Risco | Estado de implementação | Status da última execução | ID da última execução |
| --- | ---: | --- | --- | --- | --- | --- | --- | --- |
| API-01 | 3 | Exigência | Criar usuário, gerar token, confirmar autorização, listar catálogo, associar dois ISBNs distintos e consultar o usuário em um cenário contínuo | A consulta final retorna o usuário criado com exatamente os dois ISBNs escolhidos | O fluxo pode apresentar sucesso parcial e terminar sem a associação esperada | Implementado | Aprovado | R2-EXEC-002 |
| API-PA-01 | 3 | Prática adicional | Executar o mesmo fluxo no Postman | As seis respostas e a consulta final ficam comprovadas sem expor segredos | A operação manual pode ocultar um passo ou atribuir a execução à pessoa errada | Executado | Aprovado | R2-EXEC-005 |
| UI-01 | 4 | Exigência | Preencher e enviar Practice Form com arquivo `.txt`, confirmar e fechar o popup | Popup mostra os dados enviados e deixa de aparecer após o fechamento | O formulário pode aceitar o envio sem refletir corretamente os dados | Planejado | Não executado | — |
| UI-02 | 5 | Exigência | Abrir nova janela, validar a mensagem e fechar a janela | Surge uma janela adicional com `This is a sample page` e ela é fechada | A automação pode validar a janela original ou deixar a nova janela aberta | Planejado | Não executado | — |
| UI-03 | 6 | Exigência | Criar, editar e excluir o mesmo registro em Web Tables | O registro próprio reflete cada mudança e não aparece após a exclusão | A exclusão pode atingir outra linha ou a edição pode não persistir | Planejado | Não executado | — |
| UI-BONUS-01 | 6 | Bônus | Criar dinamicamente 12 registros com Cucumber e excluir todos | Os 12 registros coexistem e cada exclusão é verificada | Uma exclusão pode fazer outros registros desaparecerem sem comprovar a exclusão individual | Planejado | Não executado | — |
| UI-04 | 7 | Exigência | Parar antes de 25%, validar valor até 25%, chegar a 100% e resetar | Valores observados atendem cada estado solicitado | O tempo da interface pode fazer a parada ultrapassar o limite | Planejado | Não executado | — |
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
