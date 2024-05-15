 document.addEventListener("DOMContentLoaded", function() {
        var form = document.querySelector("form");

        form.addEventListener("submit", function(event) {
            event.preventDefault(); // Evitar el envío automático del formulario

            // Obtener los valores de los campos del formulario
            let username = document.getElementById("exampleInputNombreUsu").value;
            let password = document.getElementById("password").value;
            let email = document.getElementById("exampleInputEmail").value;
            let nombre = document.getElementById("exampleInputNombre").value;
            let apellido = document.getElementById("exampleInputApellido").value;
            let telefono = document.getElementById("exampleInputTelefono").value;
            let dni = document.getElementById("exampleInputDNI").value;
            let fechaNacimiento = document.getElementById("exampleInputFecha").value;

            // Validar el correo electrónico
            let emailValido = /\S+@\S+\.\S+/.test(email);

            // Validar el DNI (solo como ejemplo, ajusta según tus requisitos)
            let dniValido = /^\d{8}$/.test(dni);

            // Validar el teléfono (solo como ejemplo, ajusta según tus requisitos)
            let telefonoValido = /^\d{9}$/.test(telefono);

            // Calcular la edad a partir de la fecha de nacimiento
            let fechaNacimientoDate = new Date(fechaNacimiento);
            let hoy = new Date();
            let edad = hoy.getFullYear() - fechaNacimientoDate.getFullYear();
            let mes = hoy.getMonth() - fechaNacimientoDate.getMonth();
            if (mes < 0 || (mes === 0 && hoy.getDate() < fechaNacimientoDate.getDate())) {
                edad--;
            }

            // Verificar que la edad sea mayor o igual a 18 años
            let fechaValida = edad >= 18;

            // Mostrar mensajes de error si los campos no son válidos
            if (!emailValido) {
                alert("Por favor, introduce un correo electrónico válido.");
                return;
            }
            if (!dniValido) {
                alert("Por favor, introduce un DNI válido.");
                return;
            }
            if (!telefonoValido) {
                alert("Por favor, introduce un número de teléfono válido.");
                return;
            }
            if (!fechaValida) {
                alert("Debes ser mayor de 18 años para registrarte.");
                return;
            }

            // Si todos los campos son válidos, enviar el formulario
            form.submit();
        });
    });