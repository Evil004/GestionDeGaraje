# Aplicación de Gestión de grage.

Esta es una aplicación de gestión de garaje, que permite gestionar los vehículos que ingresan al garaje, y los que salen del mismo.

## Características

- Permite registrar la hora de ingreso de un vehículo.
- Permite registrar la hora de salida de un vehículo.
- Permite calcular el costo de la estancia de un vehículo.
- Permite diferenciar entre 3 tipos de vehículos: Oficial, Residente y No Residente.
- Los vehículos oficiales no pagan estancia.
- Los vehículos residentes pagan de manera mensual, y se puede obtener un reporte de los pagos de un mes.
- Los vehículos no residentes pagan por minuto a la salida del garaje.

## Uso

Para usar la aplicación hay dos maneras, ejecutando el archivo compilado que puedes encontrar [aquí](https://github.com/Evil004/GestionDeGaraje/releases) o compilándolo tú mismo.

Para ejecutar el archivo compilado es necesario tener instalado Java 1.8 o superior, y ejecutarlo, ya sea dándole doble click o desde la terminal con el comando `java -jar ./GestionDeGaraje.jar`.

## A tener en cuenta

Al importar el codigo en un proyecto es posible que los tests tengan errores debido a que falta JUnit, para solucionarlo tienes que importar JUnit 5 al proyecto.