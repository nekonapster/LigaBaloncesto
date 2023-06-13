<!-- jsp usuarios de administrador -->
<%-- 
usuarios.jsp muestro el contenido de la tabla y creo los usuarios que necesito. 
PENDIENTE
    1-poner boton mostrar contenido sin necesidad de crear ususarios nuevos. 
    2-controlar que si se crean usuarios vacios o estan repetidos salta un error.
    Document   : vistaUsuarios
    Created on : 22 may 2023, 19:15:50
    Author     : martin
--%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .errorMensajeEliminacionAdminPrincipal .errorMensajeCreacionAdminPrincipal{
                padding: 7px;
                background-color: teal;
            }
            .btnEliminar{
                appearance: none;
                border: none;
                background: transparent;
                color: white;
            }
            .celdaEliminar{
                background-color: teal !important;
                text-align: center;
            }

            .celdaEditar{
                background-color: teal !important;
                color: white;
                text-align: center;

            }
            .linkEditar{
                text-decoration: none;
                color: white;

            }
        </style>


    </head>
    <body>
        <div
            class="tab-pane fade show active"
            id="v-pills-usuarios"
            role="tabpanel"
            aria-labelledby="v-pills-usuarios-tab">
            <h1>Crea, edita o elimina usuarios</h1>
            <br />


            <!-- FORMULARIO DE CREACION DE USUARIOS -->
            <form method="POST" action="CrearUsuario">
                <input type="text" name="creacionNombreDesdeAdmin" placeholder="nombre de usuario" required/>
                <input type="email" name="creacionEmailDesdeAdmin" placeholder="email"   />
                <input type="text" name="creacionPassDesdeAdmin" placeholder="contraseña" required/>
                <select name="creacionRolDesdeAdmin">
                    <optgroup label="Rol">
                        <option value="administrador">Administrador</option>
                        <option value="arbitro">Árbitro</option>
                    </optgroup>
                </select>

                <input type="submit" value="Crear" />
            </form>

            <br />

            <h3>Lista de usuarios creados</h3>
            <table class="table table-sm table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <!--<td>Id</td>-->
                        <td>Nombre</td>
                        <td>Email</td>
                        <td>Contraseña</td>
                        <td>Rol</td>
                        <td colspan="2" style="text-align: center">Opciones</td>
                    </tr>
                </thead>
                <tbody>
                    <!--MUESTRO LO QUE ME TRAIGO DE LA TABLA USUARIOS DE LA BD -->
                    <c:forEach var="usuario" items="${usuarios}">
                        <tr>
                            <td>${usuario.nombre}</td>
                            <td>${usuario.email}</td>
                            <td>${usuario.pass}</td>
                            <td>${usuario.rol}</td>
                            <td class="celdaEliminar" >
                                <form action="EliminarUsuario" method="POST">
                                    <input type="hidden" name="idAEliminar" value=${usuario.id}>
                                    <input class="btnEliminar" type="submit" value="Eliminar">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <br/>

            <%-- Check if errorDeCreacion attribute exists --%>
            <c:if test="${not empty errorDeCreacion}">
                <div class="errorMensajeCreacionAdminPrincipal"> 
                    <h4>
                        ${errorDeCreacion}
                    </h4>
                </div>
            </c:if>
            <c:if test="${not empty errorDeEliminacion}">
                <div class="errorMensajeEliminacionAdminPrincipal"> 
                    <h4>
                        ${errorDeEliminacion}
                    </h4>
                </div>
            </c:if>

            <br />
        </div>
    </body>
</html>
