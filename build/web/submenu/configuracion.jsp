<!-- jsp configuracion de administrador -->
<a href="http://localhost/phpmyadmin/" target="_blank">
    <button class="btn btn-info w-100">Ver la base de datos</button>
</a>

<br />
<br />

<a
    href="https://github.com/nekonapster/LigaBaloncesto"
    target="_blank"
    >
    <button class="btn btn-info w-100">
        Ir al repositorio en GitHub
    </button>
</a>

<br />
<br />

<a
    href="https://mega.nz/file/CNBzmArJ#RYzgM96lDAGAeFb-2638vqnwGrC7KKDE36Kb8Rqh-zA"
    target="_blank"
    >
    <button class="btn btn-info w-100">Descargar tutoriales</button>
</a>

<br />
<br />

<!-- Button trigger modal -->
<button
    type="button"
    class="btn btn-primary"
    data-bs-toggle="modal"
    data-bs-target="#staticBackdrop"
    >
    Launch static backdrop modal
</button>

<!-- Modal -->
<div
    class="modal fade"
    id="staticBackdrop"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
    >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">
                    Modal title
                </h5>
                <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                    ></button>
            </div>
            <div class="modal-body">
                <form action="EditarUsuario">
                    <input type="text" name="editarUsuarioNombreDesdeFormularioModal" placeholder="nombre">
                    <input type="text" name="editarUsuarioPassDesdeFormularioModal" placeholder="password">
                    <br/>
                    <br/>
                    <input type="text" name="editarUsuarioEmailDesdeFormularioModal" placeholder="email">
                    <input type="text" name="editarUsuarioRolDesdeFormularioModal" placeholder="rol">
                </form>
                
            </div>
            <div class="modal-footer">
                <button
                    type="button"
                    class="btn btn-secondary"
                    data-bs-dismiss="modal"
                    >
                    Close
                </button>
                <!-- <button type="button" class="btn btn-primary">Understood</button> -->
            </div>
        </div>
    </div>
</div>