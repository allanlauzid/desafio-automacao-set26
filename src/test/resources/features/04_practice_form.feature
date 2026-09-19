# language: pt
@slide-04 @ui @ui-01
Funcionalidade: Cadastro de estudante no Practice Form

  Cenário: Enviar o formulário completo e fechar o comprovante
    Dado que acesso o DemoQA
    E abro Forms e Practice Form
    Quando preencho todos os campos com dados fictícios válidos
    E envio o arquivo TXT versionado no projeto
    E submeto o formulário
    Então o popup apresenta os mesmos dados enviados
    Quando fecho o popup
    Então o popup deixa de ser exibido
