package com.pdmtaller2.DavidSandoval_00379422.data.repositorio

import com.pdmtaller2.DavidSandoval_00379422.data.modelo.*

object repositorioRestaurantes {
    val restaurantes = listOf(
        // Comida Mexicana
        Restaurante(
            id = 1,
            nombre = "Tacos Lacas",
            descripcion = "Los mejores tacos de la ciudad",
            imagenUrl = "https://img.freepik.com/premium-vector/tacos-always-fresh-logo_187482-396.jpg?w=2000",
            categoria = "Comida Mexicana",
            menu = listOf(
                Plato("Taco al pastor", "Con piña y cebolla", "https://cdn.tasteatlas.com/images/dishes/c83a9146efbc4e08901a81f608cf1c1c.jpg"),
                Plato("Taco de res", "Carne asada deliciosa", "https://th.bing.com/th/id/R.ca36c772d0054cf36560fce3a13494d9?rik=dkGMVKyqbkszUA&pid=ImgRaw&r=0")
            )
        ),
        Restaurante(
            id = 2,
            nombre = "Sopazas",
            descripcion = "Comida típica mexicana con sabor casero",
            imagenUrl = "https://thumbs.dreamstime.com/b/vector-de-logotipo-sopa-dise%C3%B1o-gr%C3%A1fico-ilustraci%C3%B3n-vectorial-171945398.jpg",
            categoria = "Comida Mexicana",
            menu = listOf(
                Plato("Enchiladas Verdes", "Con pollo y salsa verde", "https://th.bing.com/th/id/R.3fee9c44225cedc6a72c8e211f892d9c?rik=9e5fM3iPIVdGRA&pid=ImgRaw&r=0"),
                Plato("Quesadillas de huitlacoche", "Con queso y hongos del maíz", "https://th.bing.com/th/id/R.f3d42685f15e901659a66fa177baf6b1?rik=15hGXtMW%2bQwX7A&pid=ImgRaw&r=0")
            )
        ),

        // Comida Rápida
        Restaurante(
            id = 3,
            nombre = "Burgers Wow",
            descripcion = "Hamburguesas jugosas y sabrosas",
            imagenUrl = "https://th.bing.com/th/id/OIP.ob44QUCKJlGaiKZ8oMsSXQHaHa?rs=1&pid=ImgDetMain",
            categoria = "Comida Rápida",
            menu = listOf(
                Plato("Hamburguesa Clásica", "Pan, carne, queso y vegetales.", "https://www.hola.com/horizon/landscape/d630cac80890-burgerclasica-adob-t.jpg?im=Resize=(1200)"),
                Plato("Hamburguesa BBQ", "Con salsa barbacoa y cebolla caramelizada.", "https://th.bing.com/th/id/R.2e4044512c4c5aeaeb5225e657f5043a?rik=VVLBv0T%2b7i9thw&riu=http%3a%2f%2ftodofondos.com%2fbin%2ffondos%2f06%2f47%2f80d.jpg&ehk=ShFXff3MJA8roKqDMamg8zmonwp02jo%2f7j36FJyT%2f7o%3d&risl=&pid=ImgRaw&r=0")
            )
        ),
        Restaurante(
            id = 4,
            nombre = "Pizzaprezz",
            descripcion = "Las mejores pizzas en minutos",
            imagenUrl = "https://i.pinimg.com/originals/c8/bb/48/c8bb48f1d914aa29a95035a82b057bec.png",
            categoria = "Comida Rápida",
            menu = listOf(
                Plato("Pizza Pepperoni", "Clásica con extra queso", "https://th.bing.com/th/id/OIP.LtmxNN5l2idXmwWbZOT-zwHaE9?rs=1&pid=ImgDetMain"),
                Plato("Pizza Suprema", "Con muchos vegetales", "https://media.licdn.com/dms/image/v2/D4D12AQHR8UsaGjBb4w/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1725534115002?e=2147483647&v=beta&t=M-zcNUeEpxNgw1zZmUOzE6CFk_0H60aNHq8htwv-Ceo")
            )
        ),

        // Bebidas
        Restaurante(
            id = 5,
            nombre = "Power Shakes",
            descripcion = "Bebidas proteicas ideales para antes y después del entrenamiento",
            imagenUrl = "https://img.freepik.com/premium-vector/protein-shake-vector-icon-can-be-used-gym-iconset_120816-76028.jpg",
            categoria = "Bebidas",
            menu = listOf(
                Plato("Shake de Chocolate Proteico", "Con proteína de suero y plátano", "https://static.wixstatic.com/media/4c5035_359bc2317fc0420eae03b8474c408e14~mv2.jpg/v1/fill/w_1000,h_1000,al_c,q_85,usm_0.66_1.00_0.01/4c5035_359bc2317fc0420eae03b8474c408e14~mv2.jpg"),
                Plato("Smoothie de Vainilla y Avena", "Energía para tu día", "https://th.bing.com/th/id/OIP.0PB4meXI97Q7pjKeott6kAHaE8?rs=1&pid=ImgDetMain")
            )
        ),
        Restaurante(
            id = 6,
            nombre = "Green Detox",
            descripcion = "Jugos naturales para limpiar y revitalizar tu cuerpo",
            imagenUrl = "https://th.bing.com/th/id/OIP.oJk957akpkXdibN5u0c2FQHaE8?w=2000&h=1334&rs=1&pid=ImgDetMain",
            categoria = "Bebidas",
            menu = listOf(
                Plato("Jugo Verde Detox", "Con apio, pepino y manzana verde", "https://th.bing.com/th/id/R.2c8fb4bdc5620e1042babed8b714719b?rik=UpMoPBw66VgbjQ&riu=http%3a%2f%2fcdn2.cocinadelirante.com%2fsites%2fdefault%2ffiles%2fimages%2f2017%2f01%2fjugosverdes.jpg&ehk=mtXrtrTaZsDZ%2fkGQHGKA6cB3JPeZi0p6P%2fWiB9UZCx8%3d&risl=&pid=ImgRaw&r=0"),
                Plato("Jugo de Zanahoria y Jengibre", "Purificante y antioxidante", "https://th.bing.com/th/id/OIP.N-HDujQWuRnu2O2kQohT8AHaE7?rs=1&pid=ImgDetMain")
            )
        )
    )
}
