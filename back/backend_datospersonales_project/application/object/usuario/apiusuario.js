
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
	var	nombres = "Santiago";
	var apellidos = "Aguirre";
	var	edad = "20";
	var fechaN = "07/05/02004";
	var imagen = "https://instagram.feoh6-1.fna.fbcdn.net/v/t51.2885-19/454141482_861283672074113_1568628073825928589_n.jpg?stp=dst-jpg_s150x150_tt6&_nc_ht=instagram.feoh6-1.fna.fbcdn.net&_nc_cat=105&_nc_oc=Q6cZ2QGD2uHBXaW-3sMnOOQM5PjXnVHdi1vB9ml6YhboENqAGX-np_jaVKJK6HDdeBM427A&_nc_ohc=RgguEe0SxI0Q7kNvwEBmzP8&_nc_gid=a1gs76TORY-pYSJLzQjJ5g&edm=AP4sbd4BAAAA&ccb=7-5&oh=00_AfHp3hIRtwWtXfzZwCZxgm0AN2qO1iprOpEDS4EnBKnBig&oe=681061DC&_nc_sid=7a9f4bhttps://instagram.feoh6-1.fna.fbcdn.net/v/t51.2885-19/454141482_861283672074113_1568628073825928589_n.jpg?stp=dst-jpg_s150x150_tt6&_nc_ht=instagram.feoh6-1.fna.fbcdn.net&_nc_cat=105&_nc_oc=Q6cZ2QGD2uHBXaW-3sMnOOQM5PjXnVHdi1vB9ml6YhboENqAGX-np_jaVKJK6HDdeBM427A&_nc_ohc=RgguEe0SxI0Q7kNvwEBmzP8&_nc_gid=a1gs76TORY-pYSJLzQjJ5g&edm=AP4sbd4BAAAA&ccb=7-5&oh=00_AfHp3hIRtwWtXfzZwCZxgm0AN2qO1iprOpEDS4EnBKnBig&oe=681061DC&_nc_sid=7a9f4b";
	try {		
        const modelusuario = new ModelUsuario(idusuario, documento, nombres, apellidos,edad, fechaN, imagen);
        res.status(200).json(modelusuario);	

	} catch (err) {
		res.status(500).json({ error: err.message });
	}
});

module.exports = router;