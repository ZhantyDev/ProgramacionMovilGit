
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
	var imagen = "https://scontent-bog2-1.xx.fbcdn.net/v/t39.30808-6/454230006_1668627817268959_8308237730237540388_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=TN8xBm45wjIQ7kNvwGdQDd0&_nc_oc=AdkJRfv4IvyYNruLXXsse9og-pj2KcQRhgusUdN1M51Wyec76YxiLXnssO8LKGujrHQ&_nc_zt=23&_nc_ht=scontent-bog2-1.xx&_nc_gid=KZQkR079vGz35ZfFq5R97g&oh=00_AfG2polXALpWbdnzzq102-p5Z6Lnlw9lq_D3kPkxtrewsA&oe=6816ED03";
	try {		
        const modelusuario = new ModelUsuario(idusuario, documento, nombres, apellidos,edad, fechaN, imagen);
        res.status(200).json(modelusuario);	

	} catch (err) {
		res.status(500).json({ error: err.message });
	}
});

/**
 * @swagger
 * /operaciongetusuariodocumento:
 *   get:
 *     tags:
 *       - Datos Personales
 *     summary: Get ModelDatosPersonales by Documento
 *     parameters:
 *       - name: documento
 *         in: query
 *         description: Documento
 *         required: true
 *         schema:
 *           type: string
 *           default: 0
 *     responses:
 *       200:
 *         description: Respuesta exitosa
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 results:
 *                   type: array
 *                   items:
 *                     type: string
 *       404:
 *         description: Usuario no encontrado
 */ 
router.get('/operaciongetusuariodocumento', async(req, res) => {
	var idusuario = "1";
	var documento = "1040570489";
	var	nombres = "Santiago";
	var apellidos = "Aguirre";
	var imagen = "https://scontent-bog2-1.xx.fbcdn.net/v/t39.30808-6/454230006_1668627817268959_8308237730237540388_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=TN8xBm45wjIQ7kNvwGdQDd0&_nc_oc=AdkJRfv4IvyYNruLXXsse9og-pj2KcQRhgusUdN1M51Wyec76YxiLXnssO8LKGujrHQ&_nc_zt=23&_nc_ht=scontent-bog2-1.xx&_nc_gid=KZQkR079vGz35ZfFq5R97g&oh=00_AfG2polXALpWbdnzzq102-p5Z6Lnlw9lq_D3kPkxtrewsA&oe=6816ED03";
	try{
        const { documento } = req.query;
        const modelusuario = new ModelUsuario(idusuario, documento, nombres, apellidos, imagen);

        if (documento == '1040570489'){
            res.status(200).json(modelusuario);
        }
        else {
            res.status(404).json({ message: 'Usuario no valido'});
        }
    } catch (err){
        res.status(500).json({ error: err.message });
    }
});
module.exports = router;
