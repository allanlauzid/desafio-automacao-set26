# R2-EXEC-025 — UI-05

- Executor: Assistente
- Forma de operação: execução automatizada planejada com Maven, Cucumber e Selenium
- Data e hora: 2026-09-19 01:37:14 -03:00
- Ambiente: PowerShell em área de execução restrita
- Comando: `& 'C:\Program Files\JetBrains\IntelliJ IDEA 2026.1.4\plugins\maven\lib\maven3\bin\mvn.cmd' "-Dtest=SortableTest" "-Dexecution.id=R2-EXEC-025" test`
- Esperado: compilar e executar somente `SortableTest`.
- Obtido: o Maven foi iniciado, mas recebeu `AccessDeniedException` ao copiar `08_sortable.feature` para `target/test-classes`; o cenário não começou.
- Status: Bloqueado
- Classificação da ocorrência: Ambiente
- Investigação: a escrita em `target` estava impedida pela área restrita; a execução foi repetida com autorização fora dessa restrição.
- Conclusão: a tentativa não fornece resultado funcional sobre o DemoQA.
- Evidências: saída do Maven registrada durante a execução; não houve relatório nem screenshot do cenário.
- Limitação: nenhuma interação com o sistema sob teste ocorreu.
- Revisão de dados sensíveis: concluída
