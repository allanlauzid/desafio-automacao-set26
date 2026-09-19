# Slide 6 — UI-03 e UI-BONUS-01 / Web Tables

## Decisão aprovada

- `UI-03` usa e-mail fictício único como chave para criar, conferir, editar e excluir somente o registro do teste.
- `UI-BONUS-01` gera 12 registros no próprio cenário Cucumber e mantém todos visíveis antes da exclusão.
- O requisito e o bônus têm runners, relatórios e resultados independentes.
- A tabela usa 20 linhas por página para manter os 12 registros novos e os três registros padrão na mesma visão.
- Capturas documentam criação, edição e exclusão no requisito e os estados anterior e posterior à exclusão no bônus.
- A rotina de encerramento tenta limpar registros remanescentes depois de preservar a evidência de uma falha.
