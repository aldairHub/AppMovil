# Aplicacion movil

Este proyecto consiste en el desarrollo de una aplicacion movil para el sistema operativo Android utilizando el lenguaje de programacion Java en Android Studio. La aplicacion implementa el uso de los controles comunes de la interfaz de usuario (UI), validaciones de datos y navegacion entre multiples actividades mediante Intents.

## Caracteristicas del proyecto

- Estructura: Separacion entre el diseno visual en XML (ConstraintLayout, ScrollView, TextInputLayout) y la logica en Java.
- Validacion de Formularios: Comprobacion de formatos de datos como expresiones regulares para correos electronicos (Patterns.EMAIL_ADDRESS) y longitudes para documentos de identidad (Cedula de 10 digitos).
- Componentes de UI: Integracion de un selector de fechas (DatePickerDialog), controles de seleccion unica (RadioGroup y RadioButton) e inputs de texto avanzados.
- Navegacion: Uso de Bundle e Intent para capturar y transferir informacion entre pantallas de manera dinamica.
- Diseno Responsivo: Uso de contenedores con scroll (ScrollView y HorizontalScrollView) para asegurar la adaptabilidad en diferentes orientaciones y tamanos de pantalla.

## Capturas de Pantalla de la app

| 1. Pantalla de Inicio | 2. Inicio de Sesion (Login) | 3. Formulario de Registro | 4. Vista de Perfil Guardado |
| :---: | :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/fd3cc165-f1ad-4a1d-ada7-dc91a0d34826" width="240"> | <img src="https://github.com/user-attachments/assets/3783c476-7cf5-425b-9f36-a860f62fda99" width="240"> | <img src="https://github.com/user-attachments/assets/2bcd2483-0301-4dbf-836b-bb3e93624d3a" width="240"> | <img src="https://github.com/user-attachments/assets/e1ae0398-426d-4716-b9a6-4de25988c77d" width="240"> |
| Pantalla principal de bienvenida y acceso a la aplicacion. | Comprueba formato de correo y contrasena no vacia. | Incluye validacion de cedula, texto en mayusculas y DatePicker. | Recibe los datos enviados y los renderiza en pantalla. |
