document.getElementById('togglePassword').addEventListener('pointerover', function () {
    let contraseniaInput = document.getElementById('password');
    if (contraseniaInput.type === 'password') {
        contraseniaInput.type = 'text';
    } else {
        contraseniaInput.type = 'password';
    }
});
document.getElementById('formCliente').addEventListener('submit', function (event) {
    let fechaNacimiento = document.getElementById('fechaNacimiento').value;
    let fechaNacimientoError = document.getElementById('fechaNacimientoError');
    let telefono = document.getElementById('exampleInputTelefono').value;
    let telefonoError = document.getElementById('telefonoError');
    let dni = document.getElementById('dni').value;
    let dniError = document.getElementById('dniError');
    let correoElectronico = document.getElementById('correoElectronico').value;
    let correoElectronicoError = document.getElementById('correoElectronicoError');

    // Limpia el mensaje de error
    fechaNacimientoError.textContent = '';
    telefonoError.textContent = '';
    dniError.textContent = '';
    correoElectronicoError.textContent = '';

    if (!fechaNacimiento) {
        fechaNacimientoError.textContent = 'Por favor, introduce tu fecha de nacimiento.';
        event.preventDefault();
        return;
    }

    let fechaNacimientoDate = new Date(fechaNacimiento);
    let today = new Date();
    let edad = today.getFullYear() - fechaNacimientoDate.getFullYear();
    let monthDifference = today.getMonth() - fechaNacimientoDate.getMonth();
    let dayDifference = today.getDate() - fechaNacimientoDate.getDate();

    // Ajusta la edad si el mes o el día de cumpleaños no ha pasado todavía en el año actual
    if (monthDifference < 0 || (monthDifference === 0 && dayDifference < 0)) {
        edad--;
    }

    if (edad < 18) {
        fechaNacimientoError.textContent = 'Debes tener al menos 18 años para registrarte.';
        event.preventDefault();
    }

    let telefonoRegex = /^[0-9]{9}$/;
    if (!telefonoRegex.test(telefono)) {
        telefonoError.textContent = 'Por favor, introduce un número de teléfono válido de 9 dígitos.';
        event.preventDefault();
    }

    let dniRegex = /^[0-9]{8}[A-Z]{1}$/;
    if (!dniRegex.test(dni)) {
        dniError.textContent = 'Por favor, introduce un DNI válido (8 dígitos seguidos de una letra mayúscula).';
        event.preventDefault();
        return;
    }

    // Validación de correo electrónico
    let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(correoElectronico)) {
        correoElectronicoError.textContent = 'Por favor, introduce un correo electrónico válido.';
        event.preventDefault();
        return;
    }
});