
// domain/object/pais/modelusuario.js

class ModelUsuario{
	constructor(
				idusuario, 
				documento,
				nombres,
				apellidos,
				edad,
				fechaN,
				imagen){
		this.idusuario = idusuario;
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.fechaN = fechaN;
		this.imagen = imagen;
	}
}

module.exports = { ModelUsuario };