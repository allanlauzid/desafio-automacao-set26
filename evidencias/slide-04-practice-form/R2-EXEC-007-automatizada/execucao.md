# R2-EXEC-007 — Slide 4 / UI-01

- Data e término: 2026-09-18 23:06:07 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Reprovado
- Classificação: falha da automação

## Esperado

Executar o cenário completo do Practice Form, comparar todos os dados do popup e confirmar seu fechamento.

## Obtido

O fluxo navegou até o Practice Form, preencheu dados válidos aleatórios, anexou `practice-form-upload.txt`, enviou o formulário e validou no popup todos os valores submetidos. A captura anexada ao relatório comprova o popup e os valores exibidos.

Ao acionar `Close`, a automação aguardou por 15 segundos que `.modal-content` se tornasse invisível, mas a condição expirou. O step final, que confirmaria a ausência do popup, não foi executado. O relatório registrou 1 cenário, 0 falhas de asserção, 1 erro e 0 ignorados no resumo do runner, com duração de 27,91 segundos.

## Dados da execução

- Seed: `1789783546743`
- Nome: `Diana Lima`
- E-mail: `qa17897835467439549@example.com`
- Gênero: `Female`
- Celular: `9057707980`
- Nascimento: `2000-04-27`
- Matéria: `English`
- Hobby: `Sports`
- Endereço: `Rua de Teste, 352`
- Estado/cidade: `NCR / Delhi`

## Investigação

Esta ocorrência ainda não demonstra defeito do DemoQA. O popup aceitou o envio e apresentou todos os dados esperados; a falha ocorreu no critério técnico usado para observar seu fechamento. A próxima tentativa deve observar o estado ativo do modal (`.modal.show`) após o clique no botão, em vez de depender da presença genérica de `.modal-content`.

Não há dados pessoais reais ou segredos na evidência.
