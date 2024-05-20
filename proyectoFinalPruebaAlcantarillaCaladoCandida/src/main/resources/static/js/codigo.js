function comprobarDNI() {
    let dniInput = document.getElementById('dni');
    let dniError = document.getElementById('dniError');
    let dni = dniInput.value.trim().toUpperCase(); 

    let letras = 'TRWAGMYFPDXBNJZSQVHLCKE';

    if (/^\d{8}[A-Z]$/.test(dni)) {
        let letraCalculada = letras.charAt(parseInt(dni, 10) % 23);

        if (letraCalculada === dni.charAt(8)) {
            dniInput.classList.remove('is-invalid');
            dniError.innerText = '';
            return true;
        } else {
            dniInput.classList.add('is-invalid');
            dniError.innerText = 'La letra del DNI no es correcta.';
            return false;
        }
    } else {
        dniInput.classList.add('is-invalid');
        dniError.innerText = 'Formato de DNI incorrecto.';
        return false;
    }
}


function comprobarCorreo() {
    let correoInput = document.getElementById('correoElectronico');
    let correoError = document.getElementById('correoElectronicoError');
    let correo = correoInput.value.trim();

    let correoRegExp = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if (correoRegExp.test(correo)) {
        correoInput.classList.remove('is-invalid');
        correoError.innerText = '';
        return true;
    } else {
        correoInput.classList.add('is-invalid');
        correoError.innerText = 'Formato de correo electrónico incorrecto.';
        return false;
    }
}


function comprobarEdad() {
    let fechaNacimientoInput = document.getElementById('fechaNacimiento');
    let fechaNacimientoError = document.getElementById('fechaNacimientoError');
    let fechaNacimiento = new Date(fechaNacimientoInput.value);
    let hoy = new Date();
    let edad = hoy.getFullYear() - fechaNacimiento.getFullYear();
    let mes = hoy.getMonth() - fechaNacimiento.getMonth();

    if (mes < 0 || (mes === 0 && hoy.getDate() < fechaNacimiento.getDate())) {
        edad--;
    }

    if (edad >= 18) {
        fechaNacimientoInput.classList.remove('is-invalid');
        fechaNacimientoError.innerText = '';
        return true;
    } else {
        fechaNacimientoInput.classList.add('is-invalid');
        fechaNacimientoError.innerText = 'Debe ser mayor de edad';
        return false;
    }
}
     
let iconElement = document.getElementById('icon');
let options = {
    from: 'bi-pencil-square',
    to: 'bi-pencil-squares',
    animation: 'rubberBand'
};

iconate(iconElement, options);
