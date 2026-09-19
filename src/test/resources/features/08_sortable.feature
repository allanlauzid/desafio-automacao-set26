# language: pt
@slide-08 @ui @ui-05 @sortable
Funcionalidade: Ordenação dos elementos do Sortable

  Cenário: Colocar os elementos em ordem crescente com drag and drop
    Dado que acesso Interactions e Sortable
    Quando crio uma ordem não crescente usando drag and drop
    E reordeno os elementos em ordem crescente usando drag and drop
    Então os elementos aparecem na ordem crescente de One a Six
