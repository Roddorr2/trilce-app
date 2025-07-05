async function generarEjercicios() {
    const tema = document.getElementById("tema").value;
    const grado = document.getElementById("grado").value;
    if (!tema || !grado) {
      alert("Completa el tema y el grado.");
      return;
    }
  
    const prompt = `Genera 5 preguntas de opción múltiple sobre el tema "${tema}" para estudiantes de ${grado}. Incluye la respuesta correcta.`;
    const respuesta = await consultaGemini(prompt);
    document.getElementById("resultado-ejercicios").innerText = respuesta;
}
  