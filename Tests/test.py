import datetime
from locust import HttpUser, task, between
import random

class MyUser(HttpUser):
    host = "http://localhost:8081"

    wait_time = between(1, 3)

    # @task
    # def crear_autor(self):
    #     payload = {
    #         "nombre": f"Autor {random.randint(1, 1000)}",
    #         "apellido": f"Apellido {random.randint(1, 1000)}",
    #         "email": f"autor{random.randint(1, 1000)}@example.com",
    #         "orcid": f"0000-0000-{random.randint(1000, 9999)}",
    #         "nacionalidad": "ES",
    #         "telefono": f"+593 {random.randint(600000000, 699999999)}",
    #         "instutcion": f"Institucion {random.randint(1, 100)}",
    #     }
    #     self.client.post("/api/autores", json=payload)

    @task
    def crear_libro(self):
        payload = {
            "titulo": f"Libro {random.randint(1, 1000)}",
            "aniopublicacion": random.randint(2000, 2024),
            "editorial": f"Editorial {random.randint(1, 100)}",
            "inbm": f"{random.randint(100, 999)}-{random.randint(100, 999)}-{random.randint(100, 999)}",
            "resumen": f"Este es un resumen del libro {random.randint(1, 1000)}.",
            "idioma": random.choice(["Español", "Inglés", "Francés", "Alemán"]),
            "genero": random.choice(["Ficción", "No Ficción", "Ciencia", "Historia", "Biografía"]),
            "numeroPaginas": random.randint(100, 800),
            "edicion": random.choice(["Primera", "Segunda", "Tercera", "Cuarta"]),
            "autorId": random.randint(1, 20),  # se creo 20 autores en la base de datos
            
        }
        self.client.post("/api/libros", json=payload)
        
    @task
    def crear_articulo(self):
        # Generar una fecha de publicación aleatoria (entre 2000 y 2024)
        start_date = datetime.datetime(2000, 1, 1)
        end_date = datetime.datetime(2024, 12, 31)
        random_date = start_date + datetime.timedelta(days=random.randint(0, (end_date - start_date).days))

        payload = {
            "titulo": f"Artículo {random.randint(1, 1000)}",
            "aniopublicacion": random.randint(2000, 2024),
            "resumen": f"Resumen del artículo científico {random.randint(1, 1000)}.",
            "idioma": random.choice(["Español", "Inglés", "Francés", "Alemán"]),
            "doi": f"10.1000/{random.randint(1000, 9999)}",  # Formato simple de DOI
            "revista": f"Revista {random.randint(1, 100)}",
            "areaInvestigacion": random.choice(["Ciencias Naturales", "Ingeniería", "Medicina", "Ciencias Sociales"]),
            "fechaPublicacion": random_date.strftime("%Y-%m-%d"),  # Formato ISO (YYYY-MM-DD)
            "autorId": random.randint(1, 20)  # IDs de autores existentes
        }
        self.client.post("/api/articulos-cientificos", json=payload)