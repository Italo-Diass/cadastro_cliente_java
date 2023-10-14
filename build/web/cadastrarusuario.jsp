<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head lang="pt-br">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Controle de Clientes</title>
        <style>
             @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;500;700;900&display=swap');
            
            * {
                font-family:'Poppins', sans-serif; ;
            }
            
           body{
                margin: 0;
                padding: 0;
                background-color: #ffedf3;
            }
            
            h1{
                margin: 0px;
                padding: 0px;
                height: 80px;
                width: 100%;
                background-color: black;
                color: white;
                display: flex;
                align-content: center;
                align-items: center;
                justify-content: center;
                border-style: solid;
                border-color: black;
                font-weight: 10px;
                font-size: 50px;
                font-family: Century Gothic;
                -webkit-text-stroke-width: 2px;
                -webkit-text-stroke-color: #000;
            }
            
            a {
                padding: 5px 10px; 
                margin:0;
                border: 0px solid #f00; 
                background: black;
                text-decoration: none;
                color: white;
                -webkit-border-radius:5px;
                -moz-border-radius:5px;
                border-radius:5px;
            }
            
            a:hover {
                background: black;
                color: #000; 
                border-color: #000;
            }
            .form {
                width: 40%;
                font-weight: 500;
                margin-left: 400px;
                background-color: white;
                padding: 3.125em;
                border-radius: 10px;
                display: flex;
                flex-direction: column;
                align-items: center;
                box-shadow: 5px 5px 15px -1px rgba(0,0,0,0.75);
            }

            .cadastrarcliente {
                color: #055B5C;
                text-transform: uppercase;
                letter-spacing: 2px;
                display: block;
                font-weight: bold;
                font-size: x-large;
                margin-bottom: 0.5em;
            }

            .forminput {
                width: 100%;
                margin-bottom: 1.25em;
                height: 10px;
                border-radius: 5px;
                border: 1px solid gray;
                padding: 0.8em;
                font-family: 'Inter', sans-serif;
                outline: none;
                }

            .forminput:focus {
                border: 1px solid #639;
                outline: none;
                }
                
            .cadastrar {
                padding: 5px 10px; 
                margin:0;
                border: 0px solid #f00; 
                background: #08979D;
                text-decoration: none;
                color: white;
                -webkit-border-radius:5px;
                -moz-border-radius:5px;
                border-radius:5px;
            }
            
            .cadastrar:hover{
                color: black;
                background-color: white;
                border: 1px SOLID #08979D;
                cursor: pointer;
                transition: 0.5s;
            }
            
            .mensagem{
                font-size: 23px;
            }
            
            .voltar{
                padding: 5px 10px; 
                margin:0;
                border: 0px solid #f00; 
                background: #08979D;
                text-decoration: none;
                color: white;
                -webkit-border-radius:5px;
                -moz-border-radius:5px;
                border-radius:5px;
            }
            
            .voltar:hover{
                color: white;
                background-color: black;
                border: 1px SOLID #08979D;
                cursor: pointer;
                transition: 0.5s;
            }
            
        </style>
    </head>  
    <body>

   <header>
        <h1 align="center">Controle de Usuário</h1>
        </header>
        
        </br>
        </br>
          
        <main>
        <form class="form" name="cadastrarusuario" action="CadastrarUsuario" method="post">
           <span class="cadastrarusuario"> Cadastrar Usuario </span>
           
            <p class ="mensagem" align="center"> ${mensagem} </p>
            <table align="center">
                <tr>
                    <td> <label for="usuario">Usuário:</label></td>
                    <td> <input class="forminput" type="text" name="nomeUsuario" id="usuario" /> </td> 
                </tr>       
                
                <tr>
                        <td><label for="login">Login:</label></td>
                        <td><input type="text" name="loginUsuario" id="login" /></td> 
                    </tr>
                
                <tr>
                    <td><label for="senha">Senha:</label></td>
                    <td><input class="forminput" type="password" name="senhaUsuario" id="senha" /> </td> 
                </tr>
                
                    <td colspan="2" align="center">
                        <input class="cadastrar" type="submit" name="cadastrar" value="Cadastrar">
                    </td>
                </tr>
            </table>   
            
            <br>
            <p align="center">
                <a class="voltar" href="index.jsp">Voltar</a>
            </p>
        </form>    
        </main>
    </body>
</html>


