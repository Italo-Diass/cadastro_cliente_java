<% 
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    
    HttpSession sessao = httpServletRequest.getSession();
    
    if(sessao.getAttribute("usuario") != null) { //diferente de nulo vai entrar no cadastrar cliente
%>

<%@page import="br.com.projetocliente.model.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Controle de Clientes</title>
        <style>
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
            
            tr {
                background-color: #08979D;
            }
            
            a{
                text-decoration: none;
                color: white;
            }
            
            a:link {
                color: white;
            }
            
            a:hover{ 
                color: white;
            }
            
            h1{
                text-align: center;
            }

            table, th, td {
                border: 1px solid black;
            }

            table {
                border-collapse: collapse;
                margin: auto;
            }

            th, td{
                padding: 10px;
                text-align: center;
                width: 120px;
            }

            th{
                font-weight: bold;
            }


            tr:nth-child(even) {
                background-color: white;
            }

            tr:hover:nth-child(1n + 2) {
                background-color: #6EC6CA;
                color: white;
            }
            
            img {
                width: 30px;
                height: 30px;
            }
            
            
        </style>
    </head>
    <body>
        
        <h1 align="center">Controle de Clientes</h1>
        
        <br>
        <br>
        
        <table align="center" border="1">
            <tr>
                <th colspan="10"> Lista de Cliente </th>
            </tr>
            <tr>
                <th align="center"> IDCLIENTE </th>
                <th align="center"> IDPESSOA </th>
                <th align="center"> Nome </th>
                <th align="center"> Endereço </th>
                <th align="center"> Telefone </th>
                <th align="center"> Cidade </th>
                <th align="center"> Estado </th>
                <th align="center"> Profissão </th>
                <th align="center" colspan="2"> Editar </th>
            </tr>
            
            <%-- Código Java --%>
            <%
               List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes"); 
               for(Cliente cliente:clientes){  //isso aqui ta falando que vai pegar os clientes listados e vai aparecer 
            %>
            <tr>
                <td align="center"><%=cliente.getIdCliente()%></td>
                <td align="center"><%=cliente.getIdPessoa()%></td>
                <td align="center"><%=cliente.getNomePessoa()%></td>
                <td align="center"><%=cliente.getEnderecoPessoa()%></td>
                <td align="center"><%=cliente.getTelefoneCliente()%></td>
                <td align="center"><%=cliente.getCidadePessoa()%></td>
                <td align="center"><%=cliente.getEstadoPessoa()%></td>
                <td align="center"><%=cliente.getProfissaoCliente().getNomeProfissao()%></td>
                <td align="center"><a href="ExcluirCliente?idPessoa=<%=cliente.getIdPessoa()%>"> <img src="images/lixeira (1).png"></a></td>
                <td align="center"><a href="CarregarCliente?idPessoa=<%=cliente.getIdPessoa()%>"> <img src="images/editar.png"></a></td>
            </tr>
            <%
                }
            %>
            <tr>
                <th colspan="10"><a href="index.jsp"><img src="images/voltar.png"></a></th>
            </tr>
        </table>
    </body>
</html>

<% 
    }else {
        String message = "É necessário logar para cadastrar cliente";
        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
