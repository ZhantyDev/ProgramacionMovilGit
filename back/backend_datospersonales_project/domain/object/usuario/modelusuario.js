
// domain/object/pais/modelusuario.js

class ModelUsuario{
	constructor(
				idusuario, 
				documento,
				nombres,
				apellidos,
				imagen){
		this.idusuario = idusuario;
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.imagen = imagen;
	}
}

module.exports = { ModelUsuario };