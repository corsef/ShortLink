import {createRouter,createWebHistory} from "vue-router";
import RegistrationPage from "@/components/RegistrationPage.vue";
import LoginPage from "@/components/LoginPage.vue";
import IndexPage from "@/components/IndexPage.vue";


const routes = [{
    path:'/registration',
    name: 'registration',
    component: RegistrationPage
},
{
    path:'/login',
    name: 'login',
    component: LoginPage
},
{
    path: "",
    name: "indexPage",
    component: IndexPage

}
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router