# Gestión de Finanzas Personales

Esta es una aplicación de consola en Java para gestionar las finanzas personales. Permite a los usuarios registrar ingresos y gastos, ver un listado de estos movimientos y consultar el saldo de su cuenta. La aplicación también realiza comprobaciones para asegurarse de que los datos ingresados son válidos.

 ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) 

## Características

- **Validación del DNI**: Verifica que el DNI ingresado por el usuario sea válido antes de permitir el acceso a las funcionalidades.
- **Registrar ingresos**: Añade una descripción y una cantidad a la lista de ingresos.
- **Registrar gastos**: Añade una descripción y una cantidad a la lista de gastos. Si se intenta registrar un gasto que excede el saldo disponible, se lanza una excepción personalizada `GastoException`.
- **Listar ingresos**: Muestra todos los ingresos registrados.
- **Listar gastos**: Muestra todos los gastos registrados.
- **Consultar saldo**: Muestra el saldo actual de la cuenta.


## Estructura del Proyecto

- `Main.java`: Clase principal que contiene el menú y las funcionalidades principales de la aplicación.
- `Cuenta.java`: Clase que representa la cuenta del usuario, gestionando ingresos, gastos y el saldo.
- `Usuario.java`: Clase que representa al usuario con sus datos personales.
- `Ingreso.java`: Clase que representa un ingreso.
- `Gasto.java`: Clase que representa un gasto.
- `GastoException.java`: Excepción personalizada para manejar errores relacionados con los gastos.


## Funcionalidades del Menú

- `1. Introduce un nuevo gasto`: Permite añadir un nuevo gasto proporcionando una descripción y una cantidad.
- `2. Introduce un nuevo ingreso`: Permite añadir un nuevo ingreso proporcionando una descripción y una cantidad.
- `3. Mostrar gastos`: Muestra una lista de todos los gastos registrados.
- `4. Mostrar ingresos`: Muestra una lista de todos los ingresos registrados.
- `5. Mostrar saldo`: Muestra el saldo actual de la cuenta.
- `0. Salir`: Termina la ejecución de la aplicación.

## Ejemplo de Uso

Al iniciar la aplicación, se pedirá al usuario que ingrese sus datos personales (nombre, edad, DNI). Luego, el usuario podrá interactuar con el menú para gestionar sus ingresos y gastos. Aquí hay un ejemplo de cómo se verá el menú:

