document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evitar el envío automático del formulario

    // Credenciales válidas
    const validUsername = 'admin';
    const validPassword = 'emarina';

    // Obtener los valores ingresados por el usuario
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Contenedor del mensaje de error
    const errorMessage = document.getElementById('errorMessage');

    // Verificar las credenciales
    if (username === validUsername && password === validPassword) {
        // Redirigir a la página principal
        window.location.href = '/emarina';
    } else {
        // Mostrar mensaje de error
        errorMessage.textContent = 'Nombre de usuario o contraseña incorrectos.';
        errorMessage.style.display = 'block';
    }
});
