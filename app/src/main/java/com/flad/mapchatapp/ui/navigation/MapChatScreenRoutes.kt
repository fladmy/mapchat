package com.flad.mapchatapp.ui.navigation

enum class MapChatScreenRoutes {
    Login,
    Home,
    SignUP,
    AuthRoute,
    AppRoute,
    ChatPage
}

sealed class MapChatNestedScreansRoutes(val route: String){
    object LoginScreen: MapChatNestedScreansRoutes(route = MapChatScreenRoutes.Login.name)
    object SignUp: MapChatNestedScreansRoutes(route = MapChatScreenRoutes.SignUP.name)
    object HomePage: MapChatNestedScreansRoutes(route = MapChatScreenRoutes.Home.name)
    object ChatPage: MapChatNestedScreansRoutes(route = MapChatScreenRoutes.ChatPage.name)

    object AuthRoute: MapChatNestedScreansRoutes(route = MapChatScreenRoutes.AuthRoute.name)
    object AppRoute: MapChatNestedScreansRoutes(route = MapChatScreenRoutes.AppRoute.name)





}
