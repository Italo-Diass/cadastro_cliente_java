<%-- 
    Document   : index1
    Created on : 31 de ago de 2023, 19:56:33
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Clientes</title>
        <style>
            #botao{
                margin-left: 600px;
            }
        </style>
    </head>
    <body>
        <h1 align="center">Controle de Clientes</h1>
        
        <form name="logarusuario" action="LogarUsuario" method="post">
            
            <table align="center" border="0">
                <tr>
                    <th colspan="2"> Insira os dados para acessar </th>
                </tr>
                <tr>
                    <th colspan="2">${message} </th>
                </tr>
                <tr>
                    <td><label for="login"> Login: </label> </td>
                    <td><input type="text" name="loginUsuario" id="login"> </td>
                </tr>
                <tr>
                     <td><label for="senha"> Senha: </label> </td>
                    <td><input type="password" name="senhaUsuario" id="senha"> </td>
                </tr>
                <tr>
                    <td><input class="botao" type="submit" value="Entrar" name="entrar"> </td>
                </tr>
                <tr>
                    <th>
                    <th colspan="2">  <a href="cadastrarusuario.jsp"> Não sou cadastrado </a> </th>
                    </th>
                </tr>
                
            </table>
            
        </form>
    </body>
</html>
