Diagrama de clases de la sexta entrega.

![imagen](https://github.com/nullspace1/QueMePongo/blob/main/QMPT%20It.6.drawio.png)

Me resultaba medio raro tener algun tipo de lista con todooos los usuarios metidos en una clase (ademas que creo que esto implicaria tener otro singleton, o bien meterlo en el que ya tengo) decidi agregar una interfaz generica DataProvider que es basicamente un stand-in generico de lo que se usaria posta para obtener los usuarios.

Por otro lado, las Alertas son enums pero cada uno tiene un String, que es su mensaje de notificacion. Esto era para evitar crear un Observer para cada alerta o meter un if medio choclo adentro del que ya existe para las notificaciones. Dado que los tipos de alertas no van a cambiar a futuro (segun el enunciado), esta segunda opcion era perfectamente viable.
