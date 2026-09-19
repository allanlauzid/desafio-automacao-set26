# R2-EXEC-026 — UI-05

- Executor: Assistente
- Forma de operação: execução automatizada com Maven, Cucumber e Selenium WebDriver
- Data e hora: 2026-09-19 01:38:18 -03:00
- Ambiente: Windows, Chrome 153, Selenium 4.47.0, Java 17, execução headless em 1920 × 1080
- Comando: `& 'C:\Program Files\JetBrains\IntelliJ IDEA 2026.1.4\plugins\maven\lib\maven3\bin\mvn.cmd' "-Dtest=SortableTest" "-Dexecution.id=R2-EXEC-026" test`
- Esperado: comprovar a alteração da ordem por drag and drop e terminar com `One`, `Two`, `Three`, `Four`, `Five`, `Six`.
- Obtido: o primeiro arraste produziu `[Six, One, Two, Three, Four, Five]`; a ordenação seguinte terminou em `[One, Two, Three, Four, Five, Six]`.
- Status: Aprovado
- Resultado técnico: 1 teste executado, 0 falhas, 0 erros e 0 ignorados; Maven terminou com `BUILD SUCCESS`.
- Investigação de anomalia: nenhuma divergência funcional foi observada. O aviso de correspondência CDP 151/Chrome 153 permaneceu e não impediu o cenário, que não usa comandos CDP.
- Conclusão: a ordem final crescente foi confirmada pela sequência completa lida do DOM depois de ações reais de ponteiro.
- Evidências: `screenshots/01-ordem-nao-crescente.png`, `screenshots/02-ordem-crescente.png` e arquivos em `relatorios/`.
- Limitação: o caso cobre somente a aba `List`, em Chrome, resolução desktop e uma sequência conhecida; não cobre `Grid`, dispositivos móveis, outros navegadores, acessibilidade ou desempenho.
- Revisão de dados sensíveis: concluída
