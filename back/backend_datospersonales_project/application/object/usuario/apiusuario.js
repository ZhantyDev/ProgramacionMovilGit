
// apiusuario.js

const express = require('express');

const { ModelUsuario, modelusuario } = require('../../../domain/object/usuario/modelusuario'); 

var router = express.Router();

// GET
/**
 * @swagger
 * /operaciongetusuario:
 *   get:
 *     summary: Get all ModelUsuario
 *     responses:
 *       200:
 *         description: List of ModelUsuario
 */
router.get('/operaciongetusuario', async (req, res) => {
	var idusuario = "1";
	var documento = "1040570489";
	var	nombres = "santiago";
	var apellidos = "aguirre";
	var imagen = "";
	try {		
        const modelusuario = new ModelUsuario(idusuario, documento, nombres, apellidos, imagen);
        res.status(200).json(modelusuario);	

	} catch (err) {
		res.status(500).json({ error: err.message });
	}
});

module.exports = router;