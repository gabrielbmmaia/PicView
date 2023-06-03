# PicView
O PicView é um aplicativo que utiliza a Unsplash API para obter acesso aos dados necessários. Através dele, é possível visualizar uma ampla variedade de fotografias disponibilizadas por artistas no site da Unsplash. A intenção por trás do desenvolvimento do PicView foi a de colocar em prática a modularização de um aplicativo, bem como a vontade de construir um aplicativo completamente novo utilizando o Jetpack Compose.

## 📱 Layouts do Projeto
Aqui é possível visualizar um resumo das telas esperadas do aplicativo.
![resumo-de-telas](https://github.com/gabrielbmmaia/PicView/assets/109977155/bdd8f25f-e017-422d-9df5-f9920e63e3f5)


## 🔨 Funcionalidades do projeto
`Listar fotos mais recentes da Unsplash` <br>
`Listar todas as fotos de um determinado artista` <br>
`Display de mais informações de uma foto` <br>
`Pesquisar fotos a partir de uma query` <br>
`Pesquisar fotos a partir de uma query e um filtro de cor` <br>
`Favoritar uma foto e adiciona-la à sua lista de favoritos` <br>
`Navegar usuário para o perfil de Instagram do artista` <br>
`Navegar usuário para o Portifólio do artista` <br>
`Navegar usuário para o perfil do Unsplash do artista` <br>

## ✔️ Técnicas e tecnologias utilizadas
`Kotlin`: linguagem utilizada no projeto. <br>
`Jetpack Compose`: projeto completamente construido em Jetpack Compose. <br>
`Modularização`: projeto foi moduralizado dividio por feature utilizando Gradle.kts. <br>
`Flow`: fazer atualizações da tela em tempo real. <br>
`Courutines`: usado para colocar ações demoradas. <br>
`Git`: usado para versionar o código no github. <br>
`Retrofit`: usado para pegar dados da UnsplashApi. <br>
`OkHttp`: usado para interceptar dados do Retrofit. <br>
`Gson`: usado para transformar os dados JSON. <br>
`Room`: biblioteca para criação do banco de dados de fotos Favoritas. <br>
`Hilt`: usado para injeção de dependência. <br>
`Arquitetura Clean + MvvM`: projeto foi feito totalmente na arquitetura Clean e o padrão de projeto MvvM. <br>
`Coil`: biblioteca para carregar as imagens e GIFs. <br>
`Accompanist`: utilizado para animar a transição entre telas. <br>
`Lottie`: utilizado para animar o movimento da Splash Screen a partir de um Raw Json. <br>
`Paging3`: biblioteca para paginação de dados. <br>


## ☀️🌙 Temas do Projeto
O PicView oferece não somente um tema claro e escuro padrão, mas também suporta Dynamic Colors, permitindo uma infinidade de possibilidades de temas ao aplicativo. Essa funcionalidade está disponível para usuários que possuem o sistema operacional Android 12 ou versões superiores.

![dynamic-colors](https://github.com/gabrielbmmaia/PicView/assets/109977155/4f26b1fd-a44f-4d4a-88de-9b00d852331f)

## 📱 Funcionalidades do Card de Foto
O Card de Foto é o Composable principal do aplicativo e aqui podemos ver todas as funcionalidades que ele proporciona ao usuário.

![funcionalidades-card-foto](https://github.com/gabrielbmmaia/PicView/assets/109977155/a45ea746-6d7d-4d09-b427-cddfd1163b0f)

Além dessas funcionalidades, a lista de Card de Foto é adaptada automaticamente de acordo com a rotação da tela, exibindo-se em um layout de duas colunas.

![double-span-demo](https://github.com/gabrielbmmaia/PicView/assets/109977155/b0e2efd4-8831-40c4-9086-1af0e30d3d06)


## ⛴️ Navegação entre Features
![navegacao-features](https://github.com/gabrielbmmaia/PicView/assets/109977155/f4052999-31b3-4e36-8f4c-00e46226005b)


![splash-screen-fox](https://github.com/gabrielbmmaia/PicView/assets/109977155/24cde29d-43ca-4c4f-be4b-b4b44971dbc8)
![splash-screen-mountain](https://github.com/gabrielbmmaia/PicView/assets/109977155/7aff006e-82dc-49a2-93b6-8a32ce7ced5a)
![splash-screen-forest](https://github.com/gabrielbmmaia/PicView/assets/109977155/d22dbe30-afa5-4b06-a6b6-81a5f0576450)
![splash-screen-coffee](https://github.com/gabrielbmmaia/PicView/assets/109977155/13428386-d8cb-4f8f-bc0c-57b7f0497a7c)
![splash-screen-cat](https://github.com/gabrielbmmaia/PicView/assets/109977155/dbfa8586-722d-43a1-93b6-de8f5e46163c)

## 🌎 Api utilizada 03/06/2023
https://unsplash.com/documentation

## 🛠️ Abrir e rodar o projeto

### Pela APK: <br>
Para baixar a APK do aplicativo é só você clicar em PicView dentro de Releases localizado na direita da página ou caso estaja no celular ficará localizado logo abaixo do Readme do projeto. Clicando em PicView três arquivos aparecerão e clique em "pic-view.apk" e depois em Baixar. Caso não esteja permitido o celular baixar aplicativos por outras fontes sem ser a PlayStore será necessário permitir em configurações. Após isso é só abrir e se divertir.

### Pelo Android Studio: <br>
Após baixar o projeto, você pode abrir com o Android Studio. Para isso, na tela de launcher clique em:
Open an Existing Project (ou alguma opção similar) Procure o local onde o projeto está e o selecione (Caso o projeto seja baixado via zip, é necessário extraí-lo
antes de procurá-lo) Por fim clique em OK, O Android Studio deve executar algumas tasks do Gradle para configurar o projeto, aguarde até finalizar. Ao finalizar as 
tasks, você pode executar o App.

## 🎥 Showcase do aplicativo
<div align="center">
 <video src=https://github.com/gabrielbmmaia/PicView/assets/109977155/8f4e7a6c-462d-423c-80b8-82667ee1ff4a width=800/>
<div/>
