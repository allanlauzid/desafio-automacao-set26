# R2-EXEC-005 — verificação adicional no Postman

- Data e término: 2026-09-18 22:24:01 -03:00
- Tipo: manual no Postman Web
- Executor: Assistente, via interface do Postman
- Caso relacionado: API-PA-01
- Resultado: Aprovado

## Resultado por passo

| Passo | Operação | Verificação observada |
| ---: | --- | --- |
| 1 | `POST /Account/v1/User` | HTTP 201; `userID` presente e `username` igual ao enviado |
| 2 | `POST /Account/v1/GenerateToken` | HTTP 200; `status` igual a `Success`; token presente |
| 3 | `POST /Account/v1/Authorized` | HTTP 200; corpo booleano `true` |
| 4 | `GET /BookStore/v1/Books` | HTTP 200; catálogo com 8 livros; dois ISBNs distintos selecionados |
| 5 | `POST /BookStore/v1/Books` | HTTP 201; resposta com exatamente `9781449325862` e `9781449331818` |
| 6 | `GET /Account/v1/User/{userId}` | HTTP 200; mesmo usuário e exatamente os dois ISBNs escolhidos |

## Conclusão

O resultado esperado foi atingido em um fluxo contínuo. A consulta final apresentou exatamente os dois livros associados. Esta é uma verificação adicional independente; a evidência automatizada principal permanece `R2-EXEC-002`.

Senha e token foram usados apenas durante a sessão e não foram gravados nesta evidência.
