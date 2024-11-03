import axios from 'axios';

export const loginUser = async ({username, password}) => {
  //ese ternario esta de mas por eso lo saque
  //return (userLogin.username === "admin" && userLogin.password === "12345")? true: false;
  ////return userLogin.username === "admin" && userLogin.password === "12345";

  try {
    return await axios.post('http://localhost:8080/login', {
      username,
      password,
    })
  }catch (e) {
    throw e;
  }

};
