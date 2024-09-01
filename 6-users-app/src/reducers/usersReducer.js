export const usersReducer = (state = [], action) => {
  switch (action.type) {
    case "addUser":
      return [
        ...state,
        //108. agregamos nuevo objeto
        {
          ...action.payload,
          //id ya no es necesario se maneja en el backend
          //id: new Date().getTime(),
        },
      ];
    case "removeUser":
      //devolver filter del state en el return
      //el state es la lista de usuarios
      //usamos predicate como condicion boleana
      return state.filter((user) => user.id !== action.payload);
    case "updateUser":
      //map devuelve uan nueva instancia del arreglo con los cambios
      return state.map((u) => {
        //buscar si u.id  , uy devolvemos otro objeto para que sea inmutable
        if (u.id === action.payload.id) {
          return {
            ...action.payload,
            password:u.password,
          };
        }
        return u;
      });
    case 'loadingUsers':
      return  action.payload;
    default:
      return state;
  }
};
