export const loginUser = (userLogin) => {
  //ese ternario esta de mas por eso lo saque
  //return (userLogin.username === "admin" && userLogin.password === "12345")? true: false;
  return userLogin.username === "admin" && userLogin.password === "12345";
};
