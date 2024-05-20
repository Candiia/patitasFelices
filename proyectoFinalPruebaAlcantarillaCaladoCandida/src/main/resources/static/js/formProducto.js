document.addEventListener('DOMContentLoaded', function () {
    const precioInput = document.getElementById('exampleInputPrecio');
    const precioError = document.getElementById('precioError');
    const fechaInput = document.getElementById('exampleInputFecha');
    const fechaError = document.getElementById('fechaError');
    const form = document.getElementById('formProducto');

    form.addEventListener('submit', function (event) {
        const today = new Date().toISOString().split('T')[0];
        let valid = true;

        // Validación de precio
        const precio = parseFloat(precioInput.value);
        if (isNaN(precio) || precio < 0) {
            precioError.textContent = 'El precio no puede ser negativo.';
            precioInput.classList.add('is-invalid');
            valid = false;
        } else {
            precioError.textContent = '';
            precioInput.classList.remove('is-invalid');
        }

        // Validación de fecha
        if (fechaInput.value > today) {
            fechaError.textContent = 'La fecha de ingreso no puede ser mayor que la fecha actual.';
            fechaInput.classList.add('is-invalid');
            valid = false;
        } else {
            fechaError.textContent = '';
            fechaInput.classList.remove('is-invalid');
        }

        // Evitar el envío del formulario si hay campos inválidos
        if (!valid) {
            event.preventDefault(); // Evitar el envío del formulario
        }
    });
});