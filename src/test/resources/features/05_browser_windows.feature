# language: pt
@slide-05 @ui @ui-02
Funcionalidade: Nova janela em Browser Windows

  Cenário: Abrir, validar e fechar uma nova janela
    Dado que acesso o DemoQA
    E abro Alerts, Frame & Windows e Browser Windows
    Quando solicito a abertura de uma nova janela
    Então uma nova janela é aberta
    E apresenta a mensagem "This is a sample page"
    Quando fecho a nova janela
    Então apenas a janela original permanece aberta
