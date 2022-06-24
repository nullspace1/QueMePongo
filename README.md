Diagrama de clases de la sexta entrega.

![imagen](https://github.com/nullspace1/QueMePongo/blob/main/QMPT%20It.6.drawio.png)

Me resultaba medio raro tener algun tipo de lista con todooos los usuarios metidos en una clase (ademas que creo que esto implicaria tener otro singleton, o bien meterlo en el que ya tengo) decidi agregar una interfaz generica DataProvider que es basicamente un stand-in generico de lo que se usaria posta para obtener los usuarios.
