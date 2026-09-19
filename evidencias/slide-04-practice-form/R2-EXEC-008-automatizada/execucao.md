# R2-EXEC-008 — Slide 4 / UI-01

- Data e término: 2026-09-18 23:09:37 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Reprovado
- Classificação: falha da automação

## Esperado

Executar o cenário completo do Practice Form, comparar todos os dados do popup, clicar em `Close` e confirmar que o modal ativo deixou de ser exibido.

## Obtido

O fluxo navegou, preencheu todos os campos, anexou o TXT, submeteu o formulário e validou os dados do popup. O clique nativo no botão `Close` não produziu o fechamento observável: `.modal.show` permaneceu ativo durante os 15 segundos de espera. O step final não foi executado.

O relatório registrou 1 cenário, 0 falhas de asserção, 1 erro e 0 ignorados no resumo do runner, com duração de 28,40 segundos.

## Dados da execução

- Seed: `1789783756753`
- Nome: `Camila Moraes`
- E-mail: `qa178978375675375@example.com`
- Gênero: `Male`
- Celular: `7802111151`
- Nascimento: `1981-05-21`
- Matéria: `Chemistry`
- Hobby: `Music`
- Endereço: `Rua de Teste, 254`
- Estado/cidade: `Rajasthan / Jaipur`

## Investigação

O resultado não é classificado como defeito do produto: ainda é necessário eliminar a hipótese de incompatibilidade da interação nativa no ambiente headless. A próxima tentativa manterá o clique no botão e, somente se o modal continuar ativo, repetirá o evento de clique via JavaScript; o oráculo continuará exigindo que `.modal.show` fique invisível.

Não há dados pessoais reais ou segredos na evidência.
