$(function() {

    $("#spandepa").load("Peru?accion=DEPA_CBO", function() {
        cbdepa();
    });

    $(".cebra tr:even").addClass("par");
    $(".cebra tr:odd").addClass("impar");

    $(".cebra tr").mouseover(function() {
        $(this).addClass("ilumina");
    });
    $(".cebra tr").mouseout(function() {
        $(this).removeClass("ilumina");
    });
});

function cbdepa(){
    $("#bdepa").load("Peru?accion=DEPA_QRY&numpag=" + $("#numpag_depa").val());
}

function jsIns() {
    window.location = "productosIns.jsp";
}

function jsDel() {
    var ids = [];

    $("input[name='del']:checked").each(function() {
        ids.push($(this).val());
    });

    if (ids.length === 0) {
        alert("Seleccione fila(s) a Retirar");
    } else {
        if (confirm("Retirar fila(s)?")) {
            window.location = "Productos?accion=DEL&ids=" + ids.toString();
        }                    //accion e ids se almacena en el request
    }
}

function jsUpd() {
    var id = $("input[name='upd']:checked").val();

    if (isNaN(id)) {
        alert("Seleccione Fila para Actualizar Datos");
    } else {
        window.location = "Productos?accion=GET&id=" + id;
    }
}