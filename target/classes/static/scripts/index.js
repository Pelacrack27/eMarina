// Obtener elementos del DOM
var infoModal = document.getElementById("infoModal");
var infoBtn = document.getElementById("infoBtn");
var closeBtn = document.getElementsByClassName("close")[0];

// Mostrar la ventana emergente cuando se hace clic en el botón
infoBtn.onclick = function() {
    infoModal.style.display = "block";
}

// Ocultar la ventana emergente cuando se hace clic en el botón de cerrar
closeBtn.onclick = function() {
    infoModal.style.display = "none";
}

// Ocultar la ventana emergente cuando se hace clic fuera de ella
window.onclick = function(event) {
    if (event.target == infoModal) {
        infoModal.style.display = "none";
    }
}


