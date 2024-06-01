// // Función para mostrar el modal
 function mostrarModal() {
//     // Obtener el modal
     var modal = document.getElementById("modalMensaje");

//     // Mostrar el modal
    modal.style.display = "block";

//     // Cerrar el modal cuando el usuario haga clic fuera de él
     window.onclick = function(event) {
         if (event.target == modal) {
             modal.style.display = "none";
         }
     }
 }


