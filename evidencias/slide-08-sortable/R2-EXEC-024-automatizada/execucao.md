# R2-EXEC-024 — UI-05

- Executor: Assistente
- Forma de operação: execução automatizada planejada com Maven, Cucumber e Selenium
- Data e hora: 2026-09-19 01:36 -03:00
- Ambiente: PowerShell local
- Comando: `mvn "-Dtest=SortableTest" "-Dexecution.id=R2-EXEC-024" test`
- Esperado: iniciar o cenário, alterar a ordem por drag and drop e terminar em ordem crescente.
- Obtido: o shell não reconheceu `mvn`; compilação e teste não começaram.
- Status: Bloqueado
- Classificação da ocorrência: Configuração
- Investigação: o README já documentava que o Maven desta máquina não está no `PATH` e indicava a instalação fornecida pelo IntelliJ IDEA.
- Conclusão: a tentativa não fornece resultado funcional sobre o DemoQA.
- Evidências: mensagem do shell registrada durante a execução; não houve relatório nem screenshot porque o teste não iniciou.
- Limitação: nenhuma interação com o sistema sob teste ocorreu.
- Revisão de dados sensíveis: concluída
