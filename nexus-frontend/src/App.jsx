import {
    useState, useEffect
} from "react";

//componente principal, la funcion devuelve lo que se ve en pantalla
function App(){
    // en situacion guarda los daros del alumno
    //es setSituacion es la funcion para cmabiar ese valor de null, cuando se usa React, con useState redibuja
    const [situacion, setSituacion] = useState(null)
    // error guarda el mensaje por si algo falla
    const [error, setError] = useState(null)

    //useEffect ejecuca una vz, justo despues de dibujar la pantalla por primera vez
    useEffect(() => {
        //fetch hace peticion get al endpoint de spring
        fetch('http://localhost:8080/api/alumnos/1/situacion?idPeriodo=9')
        //este para similar la ventana abierta
        //fetch('http://localhost:8080/api/alumnos/1/situacion?idPeriodo=9&momento=2026-08-21T10:00:00')
            //cuando llega la respuesta de la peticion get, se revisa que esta bien
            .then((respuesta) =>{
                //respuesta.ok es false si el servidor devolcio un error
            if(!respuesta.ok){
                throw new Error('El servidor respondio con error ' + respuesta.status)
            }
            //se convierte el cuerpo de la respuesta de texto json a un objeto javascrip
            return respuesta.json()
        })
            //cuando el json ya es un obj se guarda y provoca el redibujo de la pantalla
        .then((datos)=> setSituacion(datos))
            //Si algo falla guarda el mensjae
            .catch((e) => setError(e.message))
    }, []);//se ejecuta solo al primera vez

    //si hay un error muestra solo el mensaje y termina
    if(error){
        return <p>Error: {error}</p>
    }
    //si aun no llegan los datos, muestra cargando y termina
    if(situacion === null){
        return <p> Cargando...</p>
    }

    //Si llegaron lso datos dibuja la pantaalla
    return (
        <div>
            <h1>NEXUS</h1>
            <h2>{situacion.nombreAlumno}</h2>
            <p>Creditos acumulados: {situacion.creditosAcumulados}</p>
            <p>Creditos del semestre: {situacion.creditosSemestre}</p>
            <p>Bloque: {situacion.nombreBloque}</p>
            <p>Ventana: del {situacion.fechaInicio} al {situacion.fechaFin} hasta las {situacion.horaLimite}</p>
            <p>Estado: {situacion.ventanaAbierta ? 'Abierta' : 'Cerrada'}</p>
        </div>
    )
}

export default App