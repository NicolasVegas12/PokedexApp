# 📱 PokedexApp

PokedexApp es una aplicación móvil desarrollada en Jetpack Compose que permite explorar información sobre Pokémon utilizando la [PokeAPI](https://pokeapi.co/). La aplicación almacena datos localmente para garantizar el acceso sin conexión y cuenta con autenticación mediante Firebase.

## ✨ Características

- 🔍 **Explora Pokémon**: Obtén detalles de cada Pokémon como tipo, habilidades y estadísticas.
- 📶 **Modo Offline**: Guarda los datos localmente para acceso sin conexión.
- 🔑 **Autenticación con Firebase**: Inicio de sesión seguro con Firebase Authentication.
- 🏗 **Arquitectura Modular**: Implementación de multi modularidad por features.
- 🛠 **MVVM y Jetpack Compose**: Estructura basada en MVVM con UI moderna en Compose.
- 🌐 **Consumo de API con Retrofit**: Comunicación eficiente con PokeAPI.
- 🏗 **Inyección de dependencias**: Gestión de dependencias optimizada.

## 🏗 Arquitectura

El proyecto sigue el patrón **MVVM (Model-View-ViewModel)** y está estructurado en módulos separados por características, lo que facilita la escalabilidad y mantenibilidad del código.

## 🚀 Instalación y Configuración

Para ejecutar la aplicación localmente, sigue estos pasos:

1. Clona el repositorio:
   ```sh
   git clone https://github.com/NicolasVegas12/PokedexApp.git
2. Abre el proyecto en Android Studio Flamingo o superior.
3. Asegúrate de tener configurado un emulador o dispositivo físico con Android 7.0 (API 24) o superior.
4. Compila y ejecuta la aplicación.


## 📦 Dependencias Principales
- Jetpack Compose: Interfaz de usuario declarativa.
- Retrofit: Consumo de APIs REST.
- Firebase Authentication: Autenticación de usuarios.
- Room Database: Almacenamiento de datos local.
- Hilt/Dagger: Inyección de dependencias.
- Navigation Component: Gestión de navegación entre pantallas.