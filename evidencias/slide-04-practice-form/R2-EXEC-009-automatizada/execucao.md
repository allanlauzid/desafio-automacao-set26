# R2-EXEC-009 — Slide 4 / UI-01

- Data e término: 2026-09-18 23:11:18 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Reprovado
- Classificação: falha da automação

## Esperado

Executar o cenário completo do Practice Form, comparar todos os dados do popup, clicar em `Close` e confirmar que o modal ativo deixou de ser exibido.

## Obtido

O fluxo chegou ao popup e validou todos os dados submetidos. O clique nativo não fechou o modal; a contingência repetiu o evento de clique via JavaScript, mas `.modal.show` permaneceu visível durante a espera final. O step de confirmação posterior não foi executado.

O relatório registrou 1 cenário, 0 falhas de asserção, 1 erro e 0 ignorados no resumo do runner, com duração de 32,14 segundos.

## Dados da execução

- Seed: `1789783855359`
- Nome: `Beatriz Lima`
- E-mail: `qa17897838553599818@example.com`
- Gênero: `Female`
- Celular: `8818166752`
- Nascimento: `1989-04-26`
- Matéria: `English`
- Hobby: `Sports`
- Endereço: `Rua de Teste, 714`
- Estado/cidade: `Uttar Pradesh / Agra`

## Investigação

A captura de falha confirma visualmente que o popup permaneceu aberto. Como tanto o clique nativo quanto o evento JavaScript falharam no ambiente headless, a próxima tentativa manterá o clique exigido e usará `Escape` como contingência acessível de fechamento. Sem reprodução manual independente, a ocorrência não é promovida a defeito do produto.

Não há dados pessoais reais ou segredos na evidência.
