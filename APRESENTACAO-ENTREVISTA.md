# Apresentação do desafio em entrevista

## Resposta curta

Eu organizei o desafio como uma automação de testes spec-first, com revisão humana por checkpoint. Antes de implementar cada slide, defini a base de teste, a condição, o risco, os dados, o resultado esperado e a evidência. A solução usa Java 17, Maven, Cucumber, JUnit, REST Assured, Selenium WebDriver e Page Objects. As últimas execuções das seis exigências foram aprovadas. O bônus de 12 registros também atingiu o resultado esperado, mas revelou o defeito `DEF-UI-001`, no qual uma única exclusão removeu os 12 registros criados. Preservei as tentativas bloqueadas e reprovadas para mostrar a investigação, sem transformar o histórico em uma sequência artificial de aprovações.

## Cobertura confirmada

| Escopo | Resultado mais recente | Evidência principal |
|---|---|---|
| Slide 3, fluxo contínuo da API | `API-01` aprovado em `R2-EXEC-002` | Relatórios REST Assured, Cucumber e Surefire |
| Slide 4, Practice Form | `UI-01` aprovado em `R2-EXEC-011` | Comparações do popup, captura e relatórios |
| Slide 5, Browser Windows | `UI-02` aprovado em `R2-EXEC-012` | Mensagem da nova janela, captura e relatórios |
| Slide 6, Web Tables obrigatório | `UI-03` aprovado em `R2-EXEC-020` | Criação, edição, exclusão e regressão |
| Slide 7, Progress Bar | `UI-04` aprovado em `R2-EXEC-023` | Valores observados em parada, conclusão e reset |
| Slide 8, Sortable | `UI-05` aprovado em `R2-EXEC-026` | Ordem não crescente criada e ordem final crescente |
| Bônus, 12 registros | `UI-BONUS-01` aprovado em `R2-EXEC-019`, com `DEF-UI-001` | Presença dos 12 registros, ausência final e relatório do defeito |
| Prática adicional, Postman | `API-PA-01` aprovado em `R2-EXEC-005` | Seis respostas e consulta final sanitizadas |

O histórico preserva 26 tentativas: 10 aprovações, incluindo uma aprovação com defeito, 11 reprovações e 5 bloqueios. As reprovações e os bloqueios continuam visíveis em `RESULTADOS.md`; a matriz aponta somente para o estado mais recente de cada caso.

## Investigações que posso explicar

- A primeira execução da API não iniciou porque faltava um serializador JSON. A investigação identificou a dependência ausente e a correção adicionou `jackson-databind`.
- No Practice Form, as tentativas distinguiram problema de oráculo, comportamento do modal em headless e tempo da animação. A correção final aguardou o desaparecimento real do popup.
- No bônus de Web Tables, a automação confirmou que uma única ação removeu os 12 registros. O resultado final do bônus foi atingido, mas a ocorrência funcional permaneceu registrada como `DEF-UI-001`.
- Na Progress Bar, a revisão revelou dois navegadores causados por sobreposição de hooks. A regressão confirmou a execução com somente um navegador.
- No Sortable, duas tentativas ficaram bloqueadas por configuração do shell e restrição do ambiente. A execução seguinte comprovou o drag and drop e a ordem final pelo DOM.

## Decisões técnicas

- Um único cenário contínuo mantém o estado dos seis passos da API.
- Page Objects concentram interação e leitura da interface; as asserções ficam nos steps.
- Dados fictícios e chaves únicas reduzem interferência entre execuções.
- Esperas explícitas observam o estado da aplicação, evitando pausas fixas como oráculo.
- Capturas comprovam estados visuais relevantes, enquanto relatórios e asserções comprovam a execução.
- O teste do Sortable cria primeiro uma ordem não crescente, pois validar apenas a ordem inicial geraria um falso positivo.

## Uso de IA e revisão humana

A IA apoiou a análise, a implementação, a execução, a investigação e a documentação. Allan revisou os checkpoints e executou pessoalmente os commits e pushes em sua conta. Os campos sobre compreensão pessoal das tecnologias permanecem marcados como pendentes em `USO-DE-IA.md` até que Allan os descreva com suas próprias palavras.

## Limitações que devo declarar

- A automação cobre os fluxos pedidos, não uma suíte completa do DemoQA.
- A maior parte da interface foi executada em Chrome headless e resolução desktop.
- Não houve cobertura ampla de navegadores, dispositivos móveis, acessibilidade, desempenho, segurança ou concorrência.
- O fluxo principal da API cobre o caminho esperado; testes negativos ficaram fora do escopo.
- O aviso de compatibilidade entre CDP 151 e Chrome 153 permaneceu nas execuções de interface, sem impedir os cenários e sem afetar comandos CDP, que não foram usados.

## Onde demonstrar

- `README.md`: visão do projeto e localização dos artefatos.
- `RASTREABILIDADE.md`: estado atual dos casos.
- `RESULTADOS.md`: histórico completo das tentativas.
- `evidencias/`: capturas, relatórios e detalhes de cada execução.
- `docs/decisoes/`: decisões aprovadas por slide.
- `USO-DE-IA.md`: contribuição da IA, executor real e limitações.
