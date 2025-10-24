# Managing School Applications and Scholarships with Artificial Intelligence


[![](https://img.shields.io/badge/language-Java-blue)](https://www.java.com/)
[![Python](https://img.shields.io/badge/python-3.11-green)](https://www.python.org/)

---

## Descripción del proyecto

Este proyecto nació como un **sistema de gestión de becas** y ha evolucionado a una **plataforma integral de administración educativa**, permitiendo la gestión de:

- Becas y solicitudes de becas
- Tutorías
- Materias y carteleras por materia
- Pagos de servicios educativos

Adicionalmente, incluye un **modelo de Inteligencia Artificial** desarrollado en Python para la **evaluación de solicitudes de becas**, utilizando **FastAPI** para la integración con la aplicación de escritorio en Java.

El diseño de interfaces se encuentra disponible en **Figma**:  
[Figma - Solicitudes de Becas](https://www.figma.com/design/BfJg17arzK6wUWBKQ760om/Becas?node-id=0-1&p=f&t=F3Q4DWxIFlz2v1Jm-0)

---

## Arquitectura del sistema

- Aplicación de escritorio en **Java (Swing)** para la interacción del usuario.
- **Python + Scikit-Learn** para la lógica de predicción de solicitudes.
- Comunicación mediante **FastAPI** como intermediario para consultas y evaluaciones.
- Patrón de arquitectura **MVC clásico** para separar lógica, presentación y datos.

---

## 🛠 Tecnologías utilizadas

| Tecnología | Propósito |
|------------|-----------|
| Java (Swing) | Interfaz de usuario de escritorio |
| Python 3.x | Modelos de IA supervisada |
| Scikit-Learn | Entrenamiento y predicción de solicitudes |
| FastAPI | API para comunicar Java ↔ Python |
| Figma | Diseño de interfaces y prototipos |

---
