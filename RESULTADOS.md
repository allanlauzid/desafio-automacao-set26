# Resultados

| ID da execução | Slide/caso | Data | Tipo | Executor | Esperado em uma frase | Obtido em uma frase | Status | Link da evidência |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| R2-EXEC-001 | Slide 3 / API-01 | 2026-09-18 21:41:39 -03:00 | Automatizada | Assistente | Executar continuamente os seis passos e consultar o usuário com os dois livros | A tentativa parou antes da primeira chamada porque faltava um serializador JSON no classpath | Bloqueado | [execução](evidencias/slide-03-api/R2-EXEC-001-automatizada/execucao.md) |
| R2-EXEC-002 | Slide 3 / API-01 | 2026-09-18 21:43:41 -03:00 | Automatizada | Assistente | Executar continuamente os seis passos e consultar o usuário com os dois livros | Os seis steps terminaram e a consulta final apresentou exatamente os dois ISBNs escolhidos | Aprovado | [execução](evidencias/slide-03-api/R2-EXEC-002-automatizada/execucao.md) |
| R2-EXEC-003 | Slide 3 / API-PA-01 | 2026-09-18 | Manual planejada | Assistente | Executar os seis passos pela interface do Postman e preservar evidências sem segredos | A execução não começou porque o Postman não está instalado nem disponível entre os aplicativos controláveis | Bloqueado | [execução](evidencias/slide-03-api/R2-EXEC-003-manual/execucao.md) |
| R2-EXEC-004 | Slide 3 / API-PA-01 | 2026-09-18 22:20:00 -03:00 | Manual no Postman Web | Assistente, via interface do Postman | Executar continuamente os seis passos e consultar o usuário com os dois livros | O passo 1 retornou HTTP 400 porque o editor manteve uma chave extra no JSON digitado | Reprovado | [execução](evidencias/slide-03-api/R2-EXEC-004-manual/execucao.md) |
| R2-EXEC-005 | Slide 3 / API-PA-01 | 2026-09-18 22:24:01 -03:00 | Manual no Postman Web | Assistente, via interface do Postman | Executar continuamente os seis passos e consultar o usuário com os dois livros | Os seis passos terminaram; a consulta final retornou o usuário criado com exatamente os dois ISBNs escolhidos | Aprovado | [execução](evidencias/slide-03-api/R2-EXEC-005-manual/execucao.md) |

Uma nova linha será acrescentada para cada tentativa. Uma tentativa anterior não será reclassificada retroativamente.
