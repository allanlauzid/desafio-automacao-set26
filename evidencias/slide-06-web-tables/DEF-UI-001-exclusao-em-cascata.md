# DEF-UI-001 — Exclusão de um registro remove todos os registros adicionados

- Componente: DemoQA / Elements / Web Tables
- Situação: Confirmado nas execuções `R2-EXEC-018` e `R2-EXEC-019`
- Severidade funcional: Alta
- Prioridade sugerida: Alta

## Condição prévia

A tabela contém os três registros padrão e 12 registros novos criados pela interface, todos com e-mails únicos.

## Passos para reproduzir

1. Configurar a tabela para mostrar 20 linhas.
2. Criar 12 registros novos.
3. Confirmar que as 15 linhas aparecem.
4. Acionar a exclusão do primeiro registro criado.

## Resultado esperado

Somente o registro associado à ação selecionada deixa de aparecer. A tabela passa de 15 para 14 linhas.

## Resultado obtido

Os 12 registros adicionados deixam de aparecer simultaneamente. A tabela passa de 15 para 3 linhas, preservando somente os registros padrão.

Na execução `R2-EXEC-019`, o DOM apresentou 12 IDs visuais distintos, de `delete-record-4` a `delete-record-15`, mas a ação `delete-record-4` removeu 12 linhas.

## Evidências

- `R2-EXEC-018`: falha da asserção que exigia redução de exatamente uma linha e captura com somente os três registros padrão.
- `R2-EXEC-019`: relatório Cucumber com os 12 IDs observados, contagem de 12 linhas removidas pelo primeiro clique e confirmação da ausência final.

## Observação

O efeito funcional está comprovado. A causa interna não foi determinada e não deve ser afirmada sem acesso ao código ou diagnóstico adicional do produto.
