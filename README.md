Diagrama de clases de la cuarta entrega:

![imagen](https://github.com/nullspace1/QueMePongo/blob/main/diagramaNuevo.PNG)

Al principio existian varias validaciones a nivel de modelo y el Usuario tenia mayores responsabilidades - las instancias de usuario tenian que enviarse al momento de aceptar o rechazar propuestas, o agregar usuarios a la lista de usuarios de un determinado guardaropa.

Estas validaciones terminaron siendo eliminadas por que la sensacion que me dejaba es que estaba acoplando mucho mi modelo a ciertos mecanismos de seguridad que no estaban del todo definidos y que podrian ser mejor armados en un momento futuro cuando el resto del modelo este mas definido. Es por eso que por ahora tengo objetos como propuestas o guardaropas que son llamados asi "sueltos" - quienes y desde donde se van a llamar son parametros que aun no deje totalmente definidos.
