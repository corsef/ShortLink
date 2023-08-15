import axios from "axios";
//import registrationPage from "@/components/RegistrationPage.vue";



const USER_API_BASE_URL = 'http://localhost:8080/api/profile/'



class UserService{

    getUsers(){
      return axios.get(USER_API_BASE_URL + "get");
}
    addUser(userInfo){
        return axios({
            method: 'POST',
            url: (USER_API_BASE_URL + "add"),
            data: {
                firstName: userInfo.firstName,
                lastName: userInfo.lastName
            }
        }).catch(error => {
            console.error('İstek hatası:', error);
        })
    }
    /*restartServer(){
        return axios.get(USER_API_BASE_URL + "/restart")
    }*/

}


export default new UserService();

