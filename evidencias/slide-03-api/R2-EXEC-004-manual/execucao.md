# R2-EXEC-004 — verificação adicional no Postman

- Data: 2026-09-18
- Tipo: manual no Postman Web
- Executor: Assistente, via interface do Postman
- Caso relacionado: API-PA-01
- Resultado: Reprovado
- Classificação da ocorrência: preparação incorreta da requisição manual

## Evidência observada

O primeiro envio foi `POST /Account/v1/User`. O Postman manteve uma chave de fechamento adicional no editor, tornando o JSON inválido. A resposta observada foi HTTP 400 Bad Request, em 330 ms.

A tentativa foi encerrada no passo 1 e não foi reclassificada. O problema estava no corpo montado no Postman, portanto não constitui evidência de defeito da API.

Senha e token não são registrados neste arquivo.
