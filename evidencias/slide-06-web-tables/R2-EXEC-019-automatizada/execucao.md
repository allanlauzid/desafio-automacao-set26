# R2-EXEC-019 — Slide 6 / UI-BONUS-01

- Data e término: 2026-09-19 00:03:40 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Aprovado com defeito registrado

## Esperado

Criar dinamicamente 12 registros por meio do cenário Cucumber, confirmar todos os dados, excluir os registros criados e comprovar que nenhum permaneceu.

## Obtido

Os 12 registros foram criados com dados únicos e seus seis campos foram comparados. A tabela apresentou 12 IDs visuais distintos, de `delete-record-4` a `delete-record-15`. Ao acionar `delete-record-4`, o DemoQA removeu as 12 linhas de uma vez. A automação reconheceu os demais registros como já ausentes e confirmou que nenhum dos 12 permaneceu, preservando os três registros padrão.

O critério final do bônus foi atendido. O comportamento de exclusão em cascata foi registrado separadamente como `DEF-UI-001`.

O cenário terminou com 0 falhas e 0 erros, em 73,68 segundos. O resumo Surefire também registrou 1 item ignorado pelo filtro de tags, correspondente ao cenário obrigatório não selecionado nesta execução.

## Dados da execução

- Seed: `1789786955799`
- Quantidade criada e validada: `12`
- IDs visuais de exclusão distintos: `12`
- Linhas removidas pelo primeiro clique: `12`
- Registros do teste restantes: `0`

Não há dados pessoais reais ou segredos na evidência.
