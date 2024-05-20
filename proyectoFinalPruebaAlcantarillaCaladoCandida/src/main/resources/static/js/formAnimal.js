document.addEventListener("DOMContentLoaded", function () {
    let fechaNacimientoInput = document.getElementById("exampleInputFecha");

    fechaNacimientoInput.addEventListener("change", function () {
        let fechaNacimiento = new Date(this.value);

        let fechaHoy = new Date();

        let errorFechaNacimiento = document.getElementById("errorFechaNacimiento");

        if (fechaNacimiento > fechaHoy) {
            errorFechaNacimiento.textContent = "La fecha de nacimiento no puede ser mayor que la fecha de hoy.";
            this.value = "";
        } else {
            errorFechaNacimiento.textContent = "";
        }
    });
});