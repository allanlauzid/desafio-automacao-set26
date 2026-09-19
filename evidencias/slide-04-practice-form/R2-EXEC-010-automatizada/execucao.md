# R2-EXEC-010 — Slide 4 / UI-01

- Data e término: 2026-09-18 23:13:46 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Reprovado
- Classificação: falha da automação

## Esperado

Executar o cenário completo do Practice Form, comparar os dados do popup, fechá-lo e confirmar que deixou de ser exibido.

## Obtido

Todos os dados do popup foram validados. O clique nativo não o fechou e a contingência com `Escape` removeu o estado ativo `.modal.show`, permitindo concluir o step de fechamento. A asserção seguinte, porém, ocorreu enquanto `.modal-content` ainda estava visível durante a transição de saída e falhou.

O relatório registrou 1 cenário, 1 falha de asserção, 0 erros e 0 ignorados no resumo do runner, com duração de 15,48 segundos. A captura de falha mostra o modal ainda visível no instante da asserção.

## Dados da execução

- Seed: `1789784019115`
- Nome: `Ana Lima`
- E-mail: `qa17897840191158918@example.com`
- Gênero: `Other`
- Celular: `7837356104`
- Nascimento: `1997-02-17`
- Matéria: `English`
- Hobby: `Reading`
- Endereço: `Rua de Teste, 452`
- Estado/cidade: `Haryana / Karnal`

## Investigação

Trata-se de falso negativo por sincronização da automação: o oráculo consultou a visibilidade durante a animação de saída. A correção deve aguardar explicitamente `.modal-content` ficar invisível após o estado ativo desaparecer, sem usar tempo fixo.

Não há dados pessoais reais ou segredos na evidência.
