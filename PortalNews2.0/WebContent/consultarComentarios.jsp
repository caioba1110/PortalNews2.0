<%@page import="java.util.ArrayList"%>
<%@page import="models.Comentario" %>
<%@page import="models.Noticia" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/global.css">
<title>Noticia</title>
</head>
<body>
	<h1>RealNews </h1>
	<hr>
	<%
		ArrayList<Comentario> lista = new ArrayList<>();
		Noticia noticia;
		
		HttpSession sessao = request.getSession();
		
		noticia = (Noticia) sessao.getAttribute("noticia");
		lista = (ArrayList) sessao.getAttribute("lista");
		
	%>
	
	<h1><%=noticia.getTitulo() %></h1>
	
	<p><%=noticia.getTexto() %> </p>
	
	<h1>Comentários</h1>
	
	<%for(Comentario comentario : lista){ %>
		<tr> 
			<td><%=comentario.getNome() %></td>
			<br>
			<td><%=comentario.getTexto() %></td>
			<hr>
			<br>
		</tr>
	<%} %>
	
	<h3>Adicionar comentário</h3>
	<form action="Controller.do" method="post">
		<label>Nome</label>
		<input type="text" name="nome">
		<br>
		<label>Comentário</label>
        <input type="hidden" name="command" value="CadastrarComentario">
        <br>
		<textarea rows="5" cols="40" name="comentario"></textarea>
		<input type="submit" value="OK">
	</form>
</body>
</html>