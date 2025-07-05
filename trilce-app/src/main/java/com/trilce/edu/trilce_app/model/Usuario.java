    package com.trilce.edu.trilce_app.model;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.ManyToOne;

    @Entity
    public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String nombres;  
        private String correo;
        private String dni;
        @ManyToOne
        @JoinColumn(name = "id_grado", referencedColumnName = "id")
        private Grado grado;
        @ManyToOne
        @JoinColumn(name = "id_seccion", referencedColumnName = "id")
        private Seccion seccion;
        @ManyToOne
        @JoinColumn(name = "id_tipo_usuario", referencedColumnName = "id")
        private TipoUsuario tipoUsuario;

        public Usuario() {

        }

        public Usuario(String correo, String dni, Grado grado, int id, String nombres, Seccion seccion, TipoUsuario tipoUsuario) {
            this.correo = correo;
            this.dni = dni;
            this.grado = grado;
            this.id = id;
            this.nombres = nombres;
            this.seccion = seccion;
            this.tipoUsuario = tipoUsuario;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public Grado getGrado() {
            return grado;
        }

        public void setGrado(Grado grado) {
            this.grado = grado;
        }

        public Seccion getSeccion() {
            return seccion;
        }

        public void setSeccion(Seccion seccion) {
            this.seccion = seccion;
        }

        public TipoUsuario getTipoUsuario() {
            return tipoUsuario;
        }

        public void setTipoUsuario(TipoUsuario tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
        }

    }