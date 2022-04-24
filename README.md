El hecho de que podian existir prendas "incompletas" (solo un tipo) me hacia considerar la nocion de robustez:
Tendria que separar conceptualmente las prendas incompletas de las completas? 

Puedo tener una prenda con por ejemplo tipo y material pero sin el resto de sus caracteristicas, o simplemente
hay dos etapas (tipo, el resto)? 

Que pasa si me olvido de cargar algo y empiezo a tener una Prenda con elementos nulos
en mi sistema? Podria explotar todo. 

En base a todo lo anterior, se me ocurrio el siguiente diseño:

 No quiero tener una referencia Prenda en estado invalido (componentes faltantes o inconsistentes) en ningun momento.
 No le veo el uso a tener una clase PrendaIncompleta o algo asi, seria una clase que solo almacena datos y no puede
 tener comportamiento (lo unico que podria hacer con una PrendaIncompleta es, bueno, completarla). 
 A nivel de abstraccion no me parecia bueno.
 
 Por otro lado, estaria bueno tener la capacidad de guardar la prenda en estado incompleta en cualquier etapa de su construccion.
 
 Con esto en mente, quiero delegar la creacion de la prenda a una interfaz PrendaBuilder y solo recibir una Prenda
 cuando esta sepa que lo que voy a recibir es consistente. Mientras tanto, que la PrendaBuilder almacene y "mantenga
 escondida" a la prenda hasta cuando la necesite.
 
 Una cosa que pense era como almacenar la prenda incompleta. Sin querer romper el encapsulamiento almacenando los
 parametros de la Prenda, decidi eliminar el constructor de la iteracion anterior y permitir instanciar una Prenda
 con cosas incompletas. 
 
 El problema con esta solucion es que es que el PrendaBuilder queda bastante acoplado a la Prenda, cualquier nueva cosa
 que agregue a la Prenda va a tener que agregarse a la PrendaBuilder. 
