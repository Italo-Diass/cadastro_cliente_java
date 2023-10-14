<% 
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    
    HttpSession sessao = httpServletRequest.getSession();
    
    if(sessao.getAttribute("usuario") != null) { //diferente de nulo vai entrar no cadastrar cliente
%>

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
            *{
                margin-top: 0;
            }
            h1{
                background-color: #CFC8DE;
                font-size: 40px;
                color: white;
            }
            p{
                font-size: 25px;
            }
            a{
                text-decoration: none;
                text-align: center;
            }
            a:link{
                color: white;
            }
            a:visited{
                color: #DBB8DF;
            }
            a:hover{
                color: #CFC0FA;
            }
            body{
                background-color: #F6EAEA;
            }
            /* código do forms */
            .contact-form {
                background-color: #F6EAEA;
                padding: 20px;
                border-radius: 10px;
            }

            .contact-form label {
                color: black;
            }

            .contact-form .heading {
                font-size: 24px;
                color: black;
                margin-bottom: 12px;
                font-weight: bold;
                display: block;
                text-align: center;
            }

            .contact-form form {
                display: flex;
                flex-direction: column;
            }

            .contact-form label {
                margin-bottom: 10px;
            }

            textarea {
                resize: none;
                height: 80px;
                width: 200px;
            }

            .contact-form input, .contact-form textarea {
                padding: 10px;
                border: none;
                border-radius: 5px;
                margin-bottom: 20px;
            }

            .contact-form input:focus, .contact-form textarea:focus {
                outline: none;
                box-shadow: 0 0 5px #CFC0FA;
                transform: scale(1.05);
                transition: transform 0.3s ease-in-out;
            }

            .contact-form button[type="submit"] {
                background-color: #CFC8DE;
                color: #fff;
                border: none;
                border-radius: 5px;
                padding: 10px 20px;
                font-size: 16px;
                cursor: pointer;
            }

            .contact-form button[type="submit"]:hover {
                transform: scale(1.1);
                transition: transform 0.3s ease-in-out;
            }
            img{
                width: 30px;
                height: 30px;
            }
        </style>
    </head>
    <body>
        <h1 align="center">Controle de Clientes</h1>

        <div class="contact-form">
            <span class="heading">Alterar Cliente</span>

            <form name="cadastrarcliente" action="AlterarCliente" method="post"> <%-- action = nome da servlet --%>
                <p align="center"> ${mensagem} </p>
                <table align="center" >

                    <tr>
                        <td><label for="id"></label>ID:</td>
                        <td><input type="hidden" name="idCliente" id="idcliente" readonly="true" value="${cliente.idCliente}"/></td>
                    </tr>    
                    
                     <tr>
                        <td><label for="id"></label>ID PESSOA:</td>
                        <td><input type="hidden" name="idPessoa" id="idpessoa" readonly="true" value="${cliente.idPessoa}"/></td>
                    </tr>   

                    <tr>
                        <td><label for="nome">Nome:</label></td>
                        <td><input type="text" name="nomePessoa" id="nome" value="${cliente.nomePessoa}"/></td> 
                    </tr>

                    <tr>
                        <td><label for="endereco">Endereço:</label></td>
                        <td><input type="text" name="enderecoPessoa" id="endereco" value="${cliente.enderecoPessoa}"/></td> 
                    </tr>

                    <tr>
                        <td><label for="telefone">Telefone:</label></td>
                        <td><input type="text" name="telefoneCliente" id="telefone" value="${cliente.telefoneCliente}"/></td> 
                    </tr>

                    <tr>
                        <td><label for="cidade">Cidade:</label></td>
                        <td><input type="text" name="cidadePessoa" id="cidade" value="${cliente.cidadePessoa}"/></td> 
                    </tr>

                    <tr>
                        <td><label for="estado">Estado:</label></td>
                        <td><input type="text" name="estadoPessoa" id="estado" value="${cliente.estadoPessoa}"/></td> 
                    </tr>

                    <tr>
                        <th>Profissão</th>
                        <td>
                            <select name="idProfissao">
                                <c:forEach var="profissao" items="${profissoes}">
                                    <option value="${profissao.idProfissao}" ${profissao.idProfissao ==  cliente.profissaoCliente.idProfissao ? 'selected' : ''}> ${profissao.nomeProfissao} </option>
                                            </c:forEach>
                            </select>
                        </td>
                    </tr>
                    
                    
                    
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit" name="alterar" value="Alterar">Alterar</button>
                        </td>
                    </tr>
                </table>   
        </div>

        <br>

        <p align="center">
            <a href="index.jsp"><img src="imagens/voltar.png"></a>
        </p>
    </form>        
</body>
</html>


<% 
    }else {
        String message = "É necessário logar para cadastrar cliente";
        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>