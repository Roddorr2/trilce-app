async function explicarYLeer() {
    const pregunta = document.getElementById("preguntaTTS").value;
    if (!pregunta) {
      alert("Escribe una pregunta o tema.");
      return;
    }
  
    const prompt = `Explica de forma sencilla para un alumno de primaria: ${pregunta}`;
    const respuesta = await consultaGemini(prompt);
    document.getElementById("respuestaTTS").innerText = respuesta;
    leerTexto(respuesta);
}
  
function leerTexto(texto) {
    const speech = new SpeechSynthesisUtterance(texto);
    speech.lang = "es-ES";
    speechSynthesis.speak(speech);
}
  