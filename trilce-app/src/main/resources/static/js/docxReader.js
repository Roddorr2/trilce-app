function analizarDocumento() {
  const file = document.getElementById("fileInput").files[0];
  if (!file) {
    alert("Selecciona un archivo PDF o DOCX.");
    return;
  }

  const ext = file.name.split(".").pop().toLowerCase();
  if (ext === "pdf") {
    analizarPDF(file);
  } else if (ext === "docx") {
    analizarDOCX(file);
  } else {
    alert("Archivo no soportado. Usa PDF o DOCX.");
  }
}

function analizarDOCX(file) {
  const reader = new FileReader();
  reader.onload = function () {
    const arrayBuffer = reader.result;
    mammoth.extractRawText({ arrayBuffer }).then(result => {
      document.getElementById("textoExtraido").value = result.value;
    }).catch(err => {
      alert("Error al leer el archivo DOCX: " + err.message);
    });
  };
  reader.readAsArrayBuffer(file);
}

async function analizarPDF(file) {
  const reader = new FileReader();
  reader.onload = async function () {
    const typedarray = new Uint8Array(this.result);
    const pdf = await pdfjsLib.getDocument(typedarray).promise;
    let text = "";

    for (let i = 1; i <= pdf.numPages; i++) {
      const page = await pdf.getPage(i);
      const content = await page.getTextContent();
      const strings = content.items.map(item => item.str).join(" ");
      text += strings + "\n";
    }

    document.getElementById("textoExtraido").value = text;
  };
  reader.readAsArrayBuffer(file);
}

async function preguntarDocumento() {
  const texto = document.getElementById("textoExtraido").value;
  const pregunta = document.getElementById("preguntaDoc").value;
  if (!texto || !pregunta) {
    alert("Por favor asegúrate de tener texto extraído y una pregunta.");
    return;
  }

  const prompt = `Tengo el siguiente texto:\n${texto}\n. Y mi pregunta es:\n${pregunta}`;
  const respuesta = await consultaGemini(prompt);
  document.getElementById("respuestaDoc").innerText = respuesta;
}
