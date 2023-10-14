<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head lang="pt-br">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Controle de Clientes</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;600&display=swap" rel="stylesheet">
        <style>

            h1 {
                font-size: 60px;
            }

            .link {
                font-size: 36px;
                text-decoration: none;
                color: black;
            }

            .link:hover {
                text-decoration: underline;
                color: blue;
            }


            .sair {
                font-size: 20px;
                margin-top: 100px;

            }

            .sair a {
                text-decoration: none;
                color: black;
            }

            .sair a:hover {
                text-decoration: underline;
                color: blue;
            }


        </style>

    </head>
    <body>
        <h1 align="center">Controle de Clientes</h1>

        <br/>
        <p align="center" class="message"> ${message}  </p>

        <br/>

        <p align="center">
            <a class="link" href="CarregarProfissao">Cadastrar Clientes</a>
            <br/>
            <br/>
            <br/>
            <a class="link" href="ListarClientes">Listar Clientes</a>
        </p>  

        <p class="sair" align="center"> <a  href="EncerrarSessao"> Sair </a>
    </body> 
</html>